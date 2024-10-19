package com.agrobyte.ApiMobileAgrobyte.controllers;

import com.agrobyte.ApiMobileAgrobyte.DTO.InsumoDTOfull;
import com.agrobyte.ApiMobileAgrobyte.DTO.InsumoDTOmid;
import com.agrobyte.ApiMobileAgrobyte.services.InsumoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/insumo")
public class InsumoController {

    @Autowired
    private InsumoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<InsumoDTOmid> findById(@PathVariable Long id){
        InsumoDTOmid dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<InsumoDTOmid>> findAll(Pageable pageable){
        Page<InsumoDTOmid> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<InsumoDTOfull> insert(@Valid @RequestBody InsumoDTOfull dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<InsumoDTOfull> update(@PathVariable Long id, @Valid @RequestBody InsumoDTOfull dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
