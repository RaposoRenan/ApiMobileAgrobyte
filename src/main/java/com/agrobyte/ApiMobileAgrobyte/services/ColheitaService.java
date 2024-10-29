package com.agrobyte.ApiMobileAgrobyte.services;

import com.agrobyte.ApiMobileAgrobyte.DTO.ColheitaDTO;
import com.agrobyte.ApiMobileAgrobyte.entities.Colheita;
import com.agrobyte.ApiMobileAgrobyte.entities.Producao;
import com.agrobyte.ApiMobileAgrobyte.entities.Produto;
import com.agrobyte.ApiMobileAgrobyte.entities.StatusProducao;
import com.agrobyte.ApiMobileAgrobyte.repositories.ColheitaRepository;
import com.agrobyte.ApiMobileAgrobyte.repositories.ProducaoRepository;
import com.agrobyte.ApiMobileAgrobyte.repositories.ProdutoRepository;
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

    @Autowired
    private ProdutoRepository produtoRepository;

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

    @Transactional
    public ColheitaDTO realizarColheita(ColheitaDTO dto) {
        Producao producao = producaoRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Produção não encontrada"));

        Colheita colheita = new Colheita();
        colheita.setDataColheita(LocalDate.now());
        int qntdColhida = Math.max(producao.getQuantidadePrevista() - (dto.getPerdaDoenca() + dto.getPerdaErro()), 0);
        colheita.setQntdColhida(qntdColhida);
        colheita.setPerdaDoenca(dto.getPerdaDoenca());
        colheita.setPerdaErro(dto.getPerdaErro());
        colheita.setProducao(producao);

        colheitaRepository.save(colheita);

        producao.setStatusProducao(StatusProducao.FINALIZADO);
        producao.setColheita(colheita);

        Produto produto = producao.getProduto();
        if (produto != null) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + colheita.getQntdColhida());
            produtoRepository.save(produto); // Salva o produto atualizado no repositório
        }

        producaoRepository.save(producao);
        return new ColheitaDTO(colheita);
    }
}
