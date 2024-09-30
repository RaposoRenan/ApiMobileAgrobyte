package com.agrobyte.ApiMobileAgrobyte.DTO;

import com.agrobyte.ApiMobileAgrobyte.entities.Insumo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class InsumoDTO {
    private Long id;
    private String nome;
    private Double valorUnitario;

    public InsumoDTO(Long id, String nome, Double valorUnitario) {
        this.id = id;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
    }

    public InsumoDTO(Insumo entity) {
        id = entity.getId();
        nome = entity.getNome();
        valorUnitario = entity.getValorUnitario();
    }

    public Long getId() {
        return id;
    }

    @NotBlank(message = "Campo requerido")
    public String getNome() {
        return nome;
    }

    @Positive(message = "Quantidade tem que ser positiva")
    public Double getValorUnitario() {
        return valorUnitario;
    }
}
