package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_colheita")
public class Colheita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producao_id")
    private Producao producao;

    // Quantidade total colhida
    private int quantidadeColhida;

    // Quantidade perdida durante a colheita
    private int quantidadePerdida;

    // Data da colheita
    @Temporal(TemporalType.DATE)
    private Date dataColheita;

    // Observações (opcional)
    private String observacoes;

    public Colheita() {
    }

    public Colheita(Producao producao, int quantidadeColhida, int quantidadePerdida, Date dataColheita) {
        this.producao = producao;
        this.quantidadeColhida = quantidadeColhida;
        this.quantidadePerdida = quantidadePerdida;
        this.dataColheita = dataColheita;
    }

    // Método para calcular a quantidade final para o estoque
    public int getQuantidadeFinalParaEstoque() {
        return this.quantidadeColhida - this.quantidadePerdida;
    }

    // Getters e Setters

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

    public Date getDataColheita() {
        return dataColheita;
    }

    public void setDataColheita(Date dataColheita) {
        this.dataColheita = dataColheita;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
