package com.agrobyte.ApiMobileAgrobyte.entities;

public enum ResultadoColheita {
    EXCELENTE("Excelente"),
    BOM("Bom"),
    REGULAR("Regular"),
    RUIM("Ruim"),
    PERDA_TOTAL("Perda Total");

    private String descricao;

    ResultadoColheita(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}