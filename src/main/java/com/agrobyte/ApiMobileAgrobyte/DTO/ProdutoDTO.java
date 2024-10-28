package com.agrobyte.ApiMobileAgrobyte.DTO;

import com.agrobyte.ApiMobileAgrobyte.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long id;
    private String nome;
    private Double valorUnitario;

    public ProdutoDTO(Long id) {
        this.id = id;
    }

    public ProdutoDTO(Produto entity){
        id = entity.getId();
        nome = entity.getNome();
        valorUnitario = entity.getValorUnitario();
    }
}
