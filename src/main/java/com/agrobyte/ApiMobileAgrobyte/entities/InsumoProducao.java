package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_insumo_producao")
public class InsumoProducao {

    @EmbeddedId
    private InsumoProducaoPK id = new InsumoProducaoPK();

    private int quantidade;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Date dataSaida;

    public InsumoProducao() {
    }

    public InsumoProducao(Insumo insumo, Producao producao, int quantidade, Date dataSaida) {
        id.setInsumo(insumo);
        id.setProducao(producao);
        this.quantidade = quantidade;
        this.dataSaida = dataSaida;
    }

    public Insumo getInsumo() {
        return id.getInsumo();
    }

    public void setInsumo(Insumo insumo) {
        id.setInsumo(insumo);
    }

    public Producao getProducao() {
        return id.getProducao();
    }

    public void setProducao(Producao producao) {
        id.setProducao(producao);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }
}
