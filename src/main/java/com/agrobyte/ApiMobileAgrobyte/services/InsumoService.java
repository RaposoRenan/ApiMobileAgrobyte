package com.agrobyte.ApiMobileAgrobyte.services;

import com.agrobyte.ApiMobileAgrobyte.DTO.InsumoDTOfull;
import com.agrobyte.ApiMobileAgrobyte.entities.Insumo;
import com.agrobyte.ApiMobileAgrobyte.repositories.InsumoRepository;
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

@Service
public class InsumoService {
    @Autowired
    private InsumoRepository repository;

    @Transactional(readOnly = true)
    public InsumoDTOfull findById(Long id){
        Insumo insumo = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new InsumoDTOfull(insumo);
    }

    @Transactional(readOnly = true)
    public Page<InsumoDTOfull> findAll(Pageable pageable){
        Page<Insumo> result = repository.findAll(pageable);
        return result.map(x -> new InsumoDTOfull(x));
    }

    @Transactional
    public InsumoDTOfull insert(InsumoDTOfull dto){

        Insumo entity = new Insumo();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new InsumoDTOfull(entity);
    }

    @Transactional
    public InsumoDTOfull update(Long id, InsumoDTOfull dto){
        try {
            Insumo entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new InsumoDTOfull(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    private void copyDtoToEntity(InsumoDTOfull dto, Insumo entity) {
        entity.setNome(dto.getNome());
        entity.setValorUnitario(dto.getValorUnitario());
        entity.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        entity.setDataValidade(dto.getDataValidade());
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