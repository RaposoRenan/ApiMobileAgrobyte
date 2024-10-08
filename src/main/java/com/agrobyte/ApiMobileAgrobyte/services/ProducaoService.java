package com.agrobyte.ApiMobileAgrobyte.services;

import com.agrobyte.ApiMobileAgrobyte.DTO.InsumoProducaoDTO;
import com.agrobyte.ApiMobileAgrobyte.DTO.ProducaoDTO;
import com.agrobyte.ApiMobileAgrobyte.entities.*;
import com.agrobyte.ApiMobileAgrobyte.repositories.InsumoProducaoRepository;
import com.agrobyte.ApiMobileAgrobyte.repositories.InsumoRepository;
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

    @Autowired
    private InsumoRepository insumoRepository;

    @Autowired
    private InsumoProducaoRepository insumoProducaoRepository;

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

    @Transactional
    public ProducaoDTO insert(ProducaoDTO dto){

        Producao producao = new Producao();

        producao.setDataEntrada(LocalDate.now());
        producao.setStatusProducao(StatusProducao.PLANTIO);

        for (InsumoProducaoDTO insumoDTO : dto.getInsumos()){
            Insumo insumo = insumoRepository.getReferenceById(insumoDTO.getInsumoID());
            InsumoProducao insumos = new InsumoProducao(insumo, producao , insumoDTO.getQuantidade());
            producao.getInsumos().add(insumos);
        }

        repository.save(producao);
        insumoProducaoRepository.saveAll(producao.getInsumos());
        return new ProducaoDTO(producao);
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

    private void copyDtoToEntity(ProducaoDTO dto, Producao entity) {
        entity.setNomeProducao(dto.getNomeProducao());
        entity.setTempoPlantio(dto.getTempoPlantio());
        entity.setQuantidadePrevista(dto.getQuantidadePrevista());
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
}
