package com.agrobyte.ApiMobileAgrobyte.services;

import com.agrobyte.ApiMobileAgrobyte.DTO.ColheitaDTO;
import com.agrobyte.ApiMobileAgrobyte.entities.Colheita;
import com.agrobyte.ApiMobileAgrobyte.entities.Producao;
import com.agrobyte.ApiMobileAgrobyte.entities.StatusProducao;
import com.agrobyte.ApiMobileAgrobyte.repositories.ColheitaRepository;
import com.agrobyte.ApiMobileAgrobyte.repositories.ProducaoRepository;
import com.agrobyte.ApiMobileAgrobyte.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class ColheitaService {

    @Autowired
    private ColheitaRepository colheitaRepository;

    @Autowired
    private ProducaoRepository producaoRepository;

    @Transactional(readOnly = true)
    public ColheitaDTO findById(Long id){
        Colheita colheita = colheitaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ColheitaDTO(colheita);
    }

    @Transactional(readOnly = true)
    public Page<ColheitaDTO> findAll(Pageable pageable){
        Page<Colheita> result = colheitaRepository.findAll(pageable);
        return result.map(x -> new ColheitaDTO(x));
    }

/*    @Transactional
    public ColheitaDTO realizarColheita(ColheitaDTO dto) {
        // Buscar a produção pelo ID
        Producao producao = producaoRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Produção não encontrada para o ID: " + dto.getId()));

        // Verificar se a produção já foi finalizada
        if (producao.getStatusProducao() == StatusProducao.FINALIZADO) {
            throw new IllegalArgumentException("A produção já está finalizada.");
        }

        // Calcular a quantidade colhida
        int quantidadePrevista = producao.getQuantidadePrevista();
        int qntdColhida = quantidadePrevista - (dto.getPerdaDoenca() != null ? dto.getPerdaDoenca() : 0) - (dto.getPerdaErro() != null ? dto.getPerdaErro() : 0);

        // Criar uma nova entidade de Colheita
        Colheita colheita = new Colheita();
        colheita.setDataColheita(LocalDate.now());
        colheita.setPerdaDoenca(dto.getPerdaDoenca() != null ? dto.getPerdaDoenca() : 0);
        colheita.setPerdaErro(dto.getPerdaErro() != null ? dto.getPerdaErro() : 0);
        colheita.setQntdColhida(qntdColhida);
        colheita.setProducao(producao);

        // Alterar o status da produção para FINALIZADO
        producao.setStatusProducao(StatusProducao.FINALIZADO);
        producao.setColheita(colheita);

        // Salvar a colheita e a produção no banco de dados
        colheitaRepository.save(colheita);
        producaoRepository.save(producao);

        // Retornar os dados da colheita como DTO
        return new ColheitaDTO(colheita);
    }*/
}
