package com.agrobyte.ApiMobileAgrobyte.controllers;

import com.agrobyte.ApiMobileAgrobyte.DTO.ProducaoDTO;
import com.agrobyte.ApiMobileAgrobyte.DTO.ProducaoDTOmin;
import com.agrobyte.ApiMobileAgrobyte.services.ProducaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/producao")
public class ProducaoController {

    @Autowired
    private ProducaoService service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProducaoDTO> findById(@PathVariable Long id){
        ProducaoDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
    @GetMapping
    public ResponseEntity<Page<ProducaoDTO>> findAll(Pageable pageable){
        Page<ProducaoDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
    @PostMapping
    public ResponseEntity<ProducaoDTO> insert(@Valid @RequestBody ProducaoDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProducaoDTO> update(@PathVariable Long id, @Valid @RequestBody ProducaoDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
    @PutMapping("/atualizar-status")
    public ResponseEntity<List<ProducaoDTOmin>> atualizarStatusDeProducoes() {
        List<ProducaoDTOmin> producoesAtualizadas = service.atualizarStatusDeProducao();
        return ResponseEntity.ok(producoesAtualizadas);
    }
}