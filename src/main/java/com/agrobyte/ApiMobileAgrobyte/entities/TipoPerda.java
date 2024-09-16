package com.agrobyte.ApiMobileAgrobyte.entities;

public enum TipoPerda {
    PRAGAS("Pragas"),
    DOENCAS("Doenças"),
    CLIMA("Problemas Climáticos"),
    ERRO_HUMANO("Erro Humano"),
    OUTRO("Outro");

    private String descricao;

    TipoPerda(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
