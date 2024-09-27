package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_insumo_producao")
public class InsumoProducao {

    @EmbeddedId
    private InsumoProducaoPK id = new InsumoProducaoPK();

    private int quantidade;

    public InsumoProducao() {}

    public InsumoProducao(Insumo insumo, Producao producao, int quantidade) {
        id.setInsumo(insumo);
        id.setProducao(producao);
        this.quantidade = quantidade;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InsumoProducao that = (InsumoProducao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
