package com.agrobyte.ApiMobileAgrobyte.DTO;

import com.agrobyte.ApiMobileAgrobyte.entities.InsumoProducao;
import com.agrobyte.ApiMobileAgrobyte.entities.Producao;
import com.agrobyte.ApiMobileAgrobyte.entities.StatusProducao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProducaoDTO {

    private Long id;

    @NotBlank(message = "O nome da produção é obrigatório")
    private String nomeProducao;

    private LocalDate dataEntrada;

    @Positive(message = "O tempo de plantio deve ser positivo")
    private int tempoPlantio;

    @Positive(message = "A quantidade prevista deve ser positiva")
    private int quantidadePrevista;

    private StatusProducao status;

    private ProdutoDTO produto;

    private List<InsumoDTOmid> insumos = new ArrayList<>();

    // Construtor que recebe uma entidade Producao
    public ProducaoDTO(Producao entity) {
        id = entity.getId();
        nomeProducao = entity.getNomeProducao();
        dataEntrada = entity.getDataEntrada();
        tempoPlantio = entity.getTempoPlantio();
        quantidadePrevista = entity.getQuantidadePrevista();
        status = entity.getStatusProducao();

        // Mapeamento do produto associado
        if (entity.getProduto() != null) {
            this.produto = new ProdutoDTO(entity.getProduto());
        }

        // Mapeamento dos insumos associados
        for (InsumoProducao insumoProducao : entity.getInsumos()) {
            InsumoDTOmid insumoDTO = new InsumoDTOmid(
                    insumoProducao.getInsumo().getId(),
                    insumoProducao.getInsumo().getNome(),
                    insumoProducao.getInsumo().getValorUnitario(),
                    insumoProducao.getQuantidade(),
                    insumoProducao.getValor()
            );
            this.insumos.add(insumoDTO);
        }
    }
}
