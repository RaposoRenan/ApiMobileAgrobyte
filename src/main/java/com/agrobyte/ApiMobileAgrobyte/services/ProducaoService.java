package com.agrobyte.ApiMobileAgrobyte.services;

import com.agrobyte.ApiMobileAgrobyte.DTO.InsumoDTOmid;
import com.agrobyte.ApiMobileAgrobyte.DTO.ProducaoDTO;
import com.agrobyte.ApiMobileAgrobyte.DTO.ProducaoDTOmin;
import com.agrobyte.ApiMobileAgrobyte.DTO.ProdutoDTO;
import com.agrobyte.ApiMobileAgrobyte.entities.*;
import com.agrobyte.ApiMobileAgrobyte.repositories.*;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class ProducaoService {

    @Autowired
    private ProducaoRepository producaoRepository;

    @Autowired
    private InsumoRepository insumoRepository;

    @Autowired
    private InsumoProducaoRepository insumoProducaoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ColheitaRepository colheitaRepository;

    @Transactional(readOnly = true)
    public ProducaoDTO findById(Long id){
        Producao producao = producaoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ProducaoDTO(producao);
    }

    @Transactional(readOnly = true)
    public Page<ProducaoDTO> findAll(Pageable pageable){
        Page<Producao> result = producaoRepository.findAll(pageable);
        return result.map(x -> new ProducaoDTO(x));
    }

    @Transactional
    public ProducaoDTO insert(ProducaoDTO dto) {
        Producao producao = new Producao();

        Produto produto = produtoRepository.findById(dto.getProduto().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        producao.setProduto(produto);
        producao.setTempoPlantio(dto.getTempoPlantio());
        producao.setQuantidadePrevista(dto.getQuantidadePrevista());
        producao.setDataEntrada(LocalDate.now());
        producao.setStatusProducao(StatusProducao.PLANTIO);

        for (InsumoDTOmid insumoDTO : dto.getInsumos()) {
            Insumo insumo = insumoRepository.getReferenceById(insumoDTO.getId());
            InsumoProducao insumoProducao = new InsumoProducao(insumo, producao, insumoDTO.getQuantidade(), insumoDTO.getValorUnitario());
            insumo.atualizarEstoque(insumoProducao.getQuantidade());
            producao.getInsumos().add(insumoProducao);

        }

        producaoRepository.save(producao);
        return new ProducaoDTO(producao);
    }

    @Transactional
    public ProducaoDTO update(Long id, ProducaoDTO dto){
        try {
            Producao producao = producaoRepository.getReferenceById(id);

            producao.setTempoPlantio(dto.getTempoPlantio());
            producao.setQuantidadePrevista(dto.getQuantidadePrevista());
            producao.setDataEntrada(dto.getDataEntrada());
            producao.setStatusProducao(dto.getStatus());

            for (InsumoDTOmid insumoDTO : dto.getInsumos()) {
                Insumo insumo = insumoRepository.findById(insumoDTO.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Insumo não encontrado com ID: " + insumoDTO.getId()));

                InsumoProducao insumoProducao = new InsumoProducao(insumo, producao, insumoDTO.getQuantidade(), insumoDTO.getValorUnitario());

                producao.getInsumos().add(insumoProducao);
            }
            producaoRepository.save(producao);
            return new ProducaoDTO(producao);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!producaoRepository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try{
            producaoRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    @Transactional
    public List<ProducaoDTOmin> atualizarStatusDeProducao() {
        LocalDate dataAtual = LocalDate.now();

        List<Producao> producoesEmPlantio = producaoRepository.findByStatusProducao(StatusProducao.PLANTIO);

        List<ProducaoDTOmin> producoesAtualizadas = new ArrayList<>();

        for (Producao producao : producoesEmPlantio) {
            LocalDate dataPrevistaColheita = producao.getDataEntrada().plusDays(producao.getTempoPlantio());

            if (dataAtual.isAfter(dataPrevistaColheita) || dataAtual.isEqual(dataPrevistaColheita)) {
                producao.setStatusProducao(StatusProducao.PRONTO_PARA_COLHEITA);
                producaoRepository.save(producao);
                producoesAtualizadas.add(new ProducaoDTOmin(producao));
            }
        }
        return producoesAtualizadas;
    }
}