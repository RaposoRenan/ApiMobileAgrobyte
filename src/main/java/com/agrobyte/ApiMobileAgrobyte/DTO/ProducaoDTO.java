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
    private String nomeProducao;
    private LocalDate dataEntrada;
    private int tempoPlantio;
    private int quantidadePrevista;
    private StatusProducao status;

    private List<InsumoDTOmid> insumos = new ArrayList<>();

    public ProducaoDTO(Producao entity) {
        id = entity.getId();
        nomeProducao = entity.getNomeProducao();
        dataEntrada = entity.getDataEntrada();
        tempoPlantio = entity.getTempoPlantio();
        quantidadePrevista = entity.getQuantidadePrevista();
        status = entity.getStatusProducao();

        for (InsumoProducao insumoProducao : entity.getInsumos()) {
            InsumoDTOmid insumoDTO = new InsumoDTOmid(insumoProducao.getInsumo().getId(), insumoProducao.getInsumo().getNome(), insumoProducao.getInsumo().getValorUnitario(), insumoProducao.getQuantidade(), insumoProducao.getValor());
            insumos.add(insumoDTO);
        }
    }

    @NotBlank(message = "Campo requerido")
    public String getNomeProducao() {
        return nomeProducao;
    }

    @Positive(message = "Quantidade tem que ser positiva")
    public int getTempoPlantio() {
        return tempoPlantio;
    }

    @Positive(message = "Quantidade tem que ser positiva")
    public int getQuantidadePrevista() {
        return quantidadePrevista;
    }
}
