package com.agrobyte.ApiMobileAgrobyte.DTO;

import com.agrobyte.ApiMobileAgrobyte.entities.Insumo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsumoDTOfull {

    private Long id;
    private String nome;
    private Double valorUnitario;
    private Integer quantidadeEstoque;
    private LocalDate dataValidade;

    public InsumoDTOfull(Insumo entity){
        id = entity.getId();
        nome = entity.getNome();
        valorUnitario = entity.getValorUnitario();
        quantidadeEstoque = entity.getQuantidadeEstoque();
        dataValidade = entity.getDataValidade();
    }
}