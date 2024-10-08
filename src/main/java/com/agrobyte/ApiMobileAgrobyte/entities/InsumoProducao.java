package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
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

    private int quantidade;

    public InsumoProducao(Insumo insumo, Producao producao, int quantidade) {
        id.setInsumo(insumo);
        id.setProducao(producao);
        this.quantidade = quantidade;
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
    
}
