package com.agrobyte.ApiMobileAgrobyte.controllers;

import com.agrobyte.ApiMobileAgrobyte.DTO.ProducaoDTO;
import com.agrobyte.ApiMobileAgrobyte.entities.Producao;
import com.agrobyte.ApiMobileAgrobyte.services.ProducaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("/producao")
public class ProducaoController {

    @Autowired
    private ProducaoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProducaoDTO> findById(@PathVariable Long id){
        ProducaoDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ProducaoDTO>> findAll(Pageable pageable){
        Page<ProducaoDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }
}
