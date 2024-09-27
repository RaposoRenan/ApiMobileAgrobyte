package com.agrobyte.ApiMobileAgrobyte.services;

import com.agrobyte.ApiMobileAgrobyte.DTO.ProducaoDTO;
import com.agrobyte.ApiMobileAgrobyte.entities.Colheita;
import com.agrobyte.ApiMobileAgrobyte.entities.Producao;
import com.agrobyte.ApiMobileAgrobyte.entities.StatusProducao;
import com.agrobyte.ApiMobileAgrobyte.repositories.ProducaoRepository;
import com.agrobyte.ApiMobileAgrobyte.services.exception.DatabaseException;
import com.agrobyte.ApiMobileAgrobyte.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class ProducaoService {

    @Autowired
    private ProducaoRepository repository;

    @Transactional(readOnly = true)
    public ProducaoDTO findById(Long id){
        Producao producao = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ProducaoDTO(producao);
    }

    @Transactional(readOnly = true)
    public Page<ProducaoDTO> findAll(Pageable pageable){
        Page<Producao> result = repository.findAll(pageable);
        return result.map(ProducaoDTO::new);
    }
}
