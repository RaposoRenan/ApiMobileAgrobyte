package com.agrobyte.ApiMobileAgrobyte.DTO;

import com.agrobyte.ApiMobileAgrobyte.entities.Insumo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsumoDTO {
    private Long id;
    private String nome;
    private Double valorUnitario;
    private Integer quantidade;

    public InsumoDTO(Long id) {
        this.id = id;
    }

    public InsumoDTO(Insumo entity){
        id = entity.getId();
        nome = entity.getNome();
        valorUnitario = entity.getValorUnitario();
        quantidade = getQuantidade();
    }
}
