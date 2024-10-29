package com.agrobyte.ApiMobileAgrobyte.services;

import com.agrobyte.ApiMobileAgrobyte.DTO.ProdutoDTOfull;
import com.agrobyte.ApiMobileAgrobyte.entities.Produto;
import com.agrobyte.ApiMobileAgrobyte.repositories.ProdutoRepository;
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
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    @Transactional(readOnly = true)
    public ProdutoDTOfull findById(Long id){
        Produto produto = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ProdutoDTOfull(produto);
    }

    @Transactional(readOnly = true)
    public Page<ProdutoDTOfull> findAll(Pageable pageable){
        Page<Produto> result = repository.findAll(pageable);
        return result.map(x -> new ProdutoDTOfull(x));
    }

    @Transactional
    public ProdutoDTOfull insert(ProdutoDTOfull dto){

        Produto entity = new Produto();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProdutoDTOfull(entity);
    }

    @Transactional
    public ProdutoDTOfull update(Long id, ProdutoDTOfull dto){
        try {
            Produto entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ProdutoDTOfull(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    private void copyDtoToEntity(ProdutoDTOfull dto, Produto entity) {
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