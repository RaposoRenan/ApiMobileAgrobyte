package com.agrobyte.ApiMobileAgrobyte.controllers;

import com.agrobyte.ApiMobileAgrobyte.DTO.ColheitaDTO;
import com.agrobyte.ApiMobileAgrobyte.services.ColheitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/colheita")
public class ColheitaController {

    @Autowired
    private ColheitaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ColheitaDTO> findById(@PathVariable Long id){
        ColheitaDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ColheitaDTO>> findAll(Pageable pageable){
        Page<ColheitaDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/realizar")
    @ResponseStatus(HttpStatus.CREATED)
    public ColheitaDTO realizarColheita(@RequestBody ColheitaDTO colheitaDTO) {
        return service.realizarColheita(colheitaDTO);
    }
}