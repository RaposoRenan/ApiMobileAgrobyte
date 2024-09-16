package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_colheita")
public class Colheita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producao_id")
    private Producao producao;

    private int quantidadeColhida;

    private int quantidadePerdida;

    @Enumerated(EnumType.STRING)
    private ResultadoColheita resultadoColheita;

    @Enumerated(EnumType.STRING)
    private TipoPerda tipoPerda;

    public Colheita() {
    }

    public Colheita(Producao producao, int quantidadeColhida, int quantidadePerdida, ResultadoColheita resultadoColheita, TipoPerda tipoPerda) {
        this.producao = producao;
        this.quantidadeColhida = quantidadeColhida;
        this.quantidadePerdida = quantidadePerdida;
        this.resultadoColheita = resultadoColheita;
        this.tipoPerda = tipoPerda;
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

    public int getQuantidadeColhida() {
        return quantidadeColhida;
    }

    public void setQuantidadeColhida(int quantidadeColhida) {
        this.quantidadeColhida = quantidadeColhida;
    }

    public int getQuantidadePerdida() {
        return quantidadePerdida;
    }

    public void setQuantidadePerdida(int quantidadePerdida) {
        this.quantidadePerdida = quantidadePerdida;
    }

    public ResultadoColheita getResultadoColheita() {
        return resultadoColheita;
    }

    public void setResultadoColheita(ResultadoColheita resultadoColheita) {
        this.resultadoColheita = resultadoColheita;
    }

    public TipoPerda getTipoPerda() {
        return tipoPerda;
    }

    public void setTipoPerda(TipoPerda tipoPerda) {
        this.tipoPerda = tipoPerda;
    }
}
