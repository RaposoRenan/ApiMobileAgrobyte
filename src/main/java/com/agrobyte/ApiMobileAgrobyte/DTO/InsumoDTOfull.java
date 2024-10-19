package com.agrobyte.ApiMobileAgrobyte.DTO;

import com.agrobyte.ApiMobileAgrobyte.entities.Categoria;
import com.agrobyte.ApiMobileAgrobyte.entities.Insumo;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    private String descricao;
    private Double valorUnitario;
    private Integer quantidadeEstoque;
    private LocalDate dataValidade;
    private Categoria categoria;

    public InsumoDTOfull(Insumo entity){
        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
        valorUnitario = entity.getValorUnitario();
        quantidadeEstoque = entity.getQuantidadeEstoque();
        dataValidade = entity.getDataValidade();
        categoria = entity.getCategoria();
    }
}
