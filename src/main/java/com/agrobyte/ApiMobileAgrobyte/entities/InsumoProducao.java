package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_insumo_producao")
public class InsumoProducao {

    @EmbeddedId
    private InsumoProducaoPK id = new InsumoProducaoPK();

    private Integer quantidade;
    private Double valor;

    public InsumoProducao(Insumo insumo, Producao producao, Integer quantidade, Double valor) {
        id.setInsumo(insumo);
        id.setProducao(producao);
        this.quantidade = quantidade;
        this.valor = quantidade * getInsumo().getValorUnitario();
    }

    public Producao getProducao() {
        return id.getProducao();
    }

    public void setProducao(Producao producao) {
        id.setProducao(producao);
    }

    public Insumo getInsumo() {
        return id.getInsumo();
    }

    public void setInsumo(Insumo insumo) {
        id.setInsumo(insumo);
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