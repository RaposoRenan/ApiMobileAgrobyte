package com.agrobyte.ApiMobileAgrobyte.entities;

public enum Categoria {
    INSUMO("Insumo"),
    PRODUTO("Produto");

    private String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
