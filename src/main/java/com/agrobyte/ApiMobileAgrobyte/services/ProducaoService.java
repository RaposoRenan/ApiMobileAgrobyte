package com.agrobyte.ApiMobileAgrobyte.services;

import com.agrobyte.ApiMobileAgrobyte.DTO.InsumoDTO;
import com.agrobyte.ApiMobileAgrobyte.DTO.InsumoProducaoDTO;
import com.agrobyte.ApiMobileAgrobyte.DTO.ProducaoDTO;
import com.agrobyte.ApiMobileAgrobyte.entities.Insumo;
import com.agrobyte.ApiMobileAgrobyte.entities.InsumoProducao;
import com.agrobyte.ApiMobileAgrobyte.entities.Producao;
import com.agrobyte.ApiMobileAgrobyte.entities.StatusProducao;
import com.agrobyte.ApiMobileAgrobyte.repositories.InsumoProducaoRepository;
import com.agrobyte.ApiMobileAgrobyte.repositories.InsumoRepository;
import com.agrobyte.ApiMobileAgrobyte.repositories.ProducaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class ProducaoService {

    @Autowired
    private ProducaoRepository producaoRepository;

    @Autowired
    private InsumoRepository insumoRepository;

    @Autowired
    private InsumoProducaoRepository insumoProducaoRepository;

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
            InsumoProducao insumoProducao = new InsumoProducao(insumo, producao, 1, insumo.getValorUnitario());

            producao.getInsumos().add(insumoProducao);
        }

        producaoRepository.save(producao);
        return new ProducaoDTO(producao);
    }
}
