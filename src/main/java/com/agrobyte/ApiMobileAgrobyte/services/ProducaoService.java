package com.agrobyte.ApiMobileAgrobyte.services;

import com.agrobyte.ApiMobileAgrobyte.entities.Colheita;
import com.agrobyte.ApiMobileAgrobyte.entities.Producao;
import com.agrobyte.ApiMobileAgrobyte.entities.StatusProducao;
import com.agrobyte.ApiMobileAgrobyte.repositories.ProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProducaoService {

    @Autowired
    private ProducaoRepository producaoRepository;

    public Producao iniciarColheita(Long producaoId, LocalDate dataColheita, Integer perdaErro, Integer perdaDoenca) {
        Producao producao = producaoRepository.findById(producaoId)
                .orElseThrow(() -> new IllegalArgumentException("Produção não encontrada"));

        // Criar uma nova colheita
        Colheita colheita = new Colheita(dataColheita, perdaErro, perdaDoenca);

        // Associar colheita à produção e calcular a quantidade colhida
        producao.setColheita(colheita);

        // Atualizar status da produção
        producao.setStatusProducao(StatusProducao.COLHIDO);

        // Salvar produção
        return producaoRepository.save(producao);
    }
}
