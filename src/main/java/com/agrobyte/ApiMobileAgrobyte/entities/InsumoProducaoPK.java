package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InsumoProducaoPK that = (InsumoProducaoPK) o;
        return Objects.equals(insumo, that.insumo) && Objects.equals(producao, that.producao);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(insumo);
        result = 31 * result + Objects.hashCode(producao);
        return result;
    }
}
