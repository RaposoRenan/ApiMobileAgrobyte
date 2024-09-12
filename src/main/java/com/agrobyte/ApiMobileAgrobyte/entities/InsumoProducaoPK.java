package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class InsumoProducaoPK {

    @ManyToOne
    @JoinColumn(name = "insumo_id")
    private Insumo insumo;

    @ManyToOne
    @JoinColumn(name = "producao_id")
    private Producao producao;

    public InsumoProducaoPK() {
    }

    public InsumoProducaoPK(Insumo insumo, Producao producao) {
        this.insumo = insumo;
        this.producao = producao;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Producao getProducao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }
}
