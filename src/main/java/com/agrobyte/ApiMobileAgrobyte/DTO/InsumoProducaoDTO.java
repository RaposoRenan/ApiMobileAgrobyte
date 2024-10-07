package com.agrobyte.ApiMobileAgrobyte.DTO;

import com.agrobyte.ApiMobileAgrobyte.entities.InsumoProducao;

public class InsumoProducaoDTO {

    private Long insumoID;
    private String nome;
    private Double valorUnitario;
    private int quantidade;

    public InsumoProducaoDTO(Long insumoID, String nome, Double valorUnitario, int quantidade) {
        this.insumoID = insumoID;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public InsumoProducaoDTO(InsumoProducao entity) {
        insumoID = entity.getInsumo().getId();
        nome = entity.getInsumo().getNome();
        valorUnitario = entity.getInsumo().getValorUnitario();
        quantidade = entity.getQuantidade();
    }

    public Long getInsumoID() {
        return insumoID;
    }

    public String getNome() {
        return nome;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
