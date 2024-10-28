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
public class InsumoDTOmin {
    private Long id;
    private String nome;
    private Double valorUnitario;

    public InsumoDTOmin(Long id) {
        this.id = id;
    }

    public InsumoDTOmin(Insumo entity){
        id = entity.getId();
        nome = entity.getNome();
        valorUnitario = entity.getValorUnitario();
    }
}