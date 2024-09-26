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

    private void copyDtoToEntity(ProducaoDTO dto, Producao entity) {
        entity.setNomeProducao(dto.getNomeProducao());
        entity.setTempoPlantio(dto.getTempoPlantio());
        entity.setQuantidadePrevista(dto.getQuantidadePrevista());
    }

    @Transactional
    public ProducaoDTO iniciarProducao(ProducaoDTO dto) {
        Producao entity = new Producao();
        copyDtoToEntity(dto, entity);
        entity.setDataEntrada(LocalDate.now());
        entity.setStatusProducao(StatusProducao.PLANTIO);
        entity = repository.save(entity);
        return new ProducaoDTO(entity);
    }

    @Transactional
    public ProducaoDTO update(Long id, ProducaoDTO dto){
        try {
            Producao entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity.setDataEntrada(dto.getDataEntrada());
            entity.setStatusProducao(dto.getStatus());
            entity = repository.save(entity);
            return new ProducaoDTO(entity);

        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try{
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    public Producao iniciarColheita(Long producaoId, LocalDate dataColheita, Integer perdaErro, Integer perdaDoenca) {
        Producao producao = repository.findById(producaoId)
                .orElseThrow(() -> new IllegalArgumentException("Produção não encontrada"));
        Colheita colheita = new Colheita(dataColheita, perdaErro, perdaDoenca);
        producao.setColheita(colheita);
        producao.setStatusProducao(StatusProducao.COLHIDO);
        return repository.save(producao);
    }
}
