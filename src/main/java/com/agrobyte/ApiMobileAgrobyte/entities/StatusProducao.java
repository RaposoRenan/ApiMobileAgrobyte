package com.agrobyte.ApiMobileAgrobyte.entities;

public enum StatusProducao {
    PLANTIO("Plantio iniciado"),
    PRONTO_PARA_COLHEITA("Pronto para colheita"),
    FINALIZADO("Finalizado");

    private String descricao;

    StatusProducao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}