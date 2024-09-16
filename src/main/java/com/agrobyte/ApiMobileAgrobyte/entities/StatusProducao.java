package com.agrobyte.ApiMobileAgrobyte.entities;

public enum StatusProducao {
    PLANTIO("Plantio iniciado"),
    EM_CRESCIMENTO("Em crescimento"),
    PRONTO_PARA_COLHEITA("Pronto para colheita"),
    COLHIDO("Colhido"),
    FINALIZADO("Finalizado");

    private String descricao;

    StatusProducao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
