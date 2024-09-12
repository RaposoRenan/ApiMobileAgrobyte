package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_perda_producao")
public class PerdaProducao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producao_id")
    private Producao producao;

    // Quantidade perdida
    private int quantidadePerdida;

    // Motivo da perda (opcionalmente pode ser um enum)
    private String motivoPerda;

    public PerdaProducao() {
    }

    public PerdaProducao(Producao producao, int quantidadePerdida, String motivoPerda) {
        this.producao = producao;
        this.quantidadePerdida = quantidadePerdida;
        this.motivoPerda = motivoPerda;
    }

    public int getQuantidadePerdida() {
        return quantidadePerdida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producao getProducao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }

    public void setQuantidadePerdida(int quantidadePerdida) {
        this.quantidadePerdida = quantidadePerdida;
    }

    public String getMotivoPerda() {
        return motivoPerda;
    }

    public void setMotivoPerda(String motivoPerda) {
        this.motivoPerda = motivoPerda;
    }
}