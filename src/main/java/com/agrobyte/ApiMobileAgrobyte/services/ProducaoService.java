package com.agrobyte.ApiMobileAgrobyte.services;

import com.agrobyte.ApiMobileAgrobyte.DTO.InsumoDTO;
import com.agrobyte.ApiMobileAgrobyte.DTO.InsumoProducaoDTO;
import com.agrobyte.ApiMobileAgrobyte.DTO.ProducaoDTO;
import com.agrobyte.ApiMobileAgrobyte.DTO.ProducaoDTOmin;
import com.agrobyte.ApiMobileAgrobyte.entities.Insumo;
import com.agrobyte.ApiMobileAgrobyte.entities.InsumoProducao;
import com.agrobyte.ApiMobileAgrobyte.entities.Producao;
import com.agrobyte.ApiMobileAgrobyte.entities.StatusProducao;
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

        producao.setNomeProducao(dto.getNomeProducao());
        producao.setTempoPlantio(dto.getTempoPlantio());
        producao.setQuantidadePrevista(dto.getQuantidadePrevista());
        producao.setDataEntrada(LocalDate.now());
        producao.setStatusProducao(StatusProducao.PLANTIO);

        for (InsumoDTO insumoDTO : dto.getInsumos()) {
            Insumo insumo = insumoRepository.getReferenceById(insumoDTO.getId());
            InsumoProducao insumoProducao = new InsumoProducao(insumo, producao, insumoDTO.getQuantidade(), insumoDTO.getValorUnitario());

            producao.getInsumos().add(insumoProducao);
        }

        producaoRepository.save(producao);
        return new ProducaoDTO(producao);
    }

    @Transactional
    public ProducaoDTO update(Long id, ProducaoDTO dto){
        try {
            Producao producao = producaoRepository.getReferenceById(id);

            producao.setNomeProducao(dto.getNomeProducao());
            producao.setTempoPlantio(dto.getTempoPlantio());
            producao.setQuantidadePrevista(dto.getQuantidadePrevista());
            producao.setDataEntrada(dto.getDataEntrada());
            producao.setStatusProducao(dto.getStatus());

            for (InsumoDTO insumoDTO : dto.getInsumos()) {
                Insumo insumo = insumoRepository.getReferenceById(insumoDTO.getId());
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

        // Buscar todas as produções com status "PLANTIO"
        List<Producao> producoesEmPlantio = producaoRepository.findByStatusProducao(StatusProducao.PLANTIO);

        List<ProducaoDTOmin> producoesAtualizadas = new ArrayList<>();

        for (Producao producao : producoesEmPlantio) {
            LocalDate dataPrevistaColheita = producao.getDataEntrada().plusDays(producao.getTempoPlantio());

            // Verifica se a produção já atingiu o tempo de colheita
            if (dataAtual.isAfter(dataPrevistaColheita) || dataAtual.isEqual(dataPrevistaColheita)) {
                producao.setStatusProducao(StatusProducao.PRONTO_PARA_COLHEITA);
                producaoRepository.save(producao);  // Atualiza a produção no banco de dados
                producoesAtualizadas.add(new ProducaoDTOmin(producao));
            }
        }

        return producoesAtualizadas;
    }
}
