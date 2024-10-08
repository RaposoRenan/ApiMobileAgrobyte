package com.agrobyte.ApiMobileAgrobyte.DTO;

import com.agrobyte.ApiMobileAgrobyte.entities.InsumoProducao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsumoProducaoDTO {

    private Long insumoID;
    private String nome;
    private Double valor;
    private int quantidade;

    public InsumoProducaoDTO(InsumoProducao entity) {
        insumoID = entity.getInsumo().getId();
        nome = entity.getInsumo().getNome();
        valor = entity.getInsumo().getValorUnitario();
        quantidade = entity.getQuantidade();
    }

    public Double getTotal() {
        return valor * quantidade;
    }
}
