package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class InsumoProducaoPK {

    @ManyToOne
    @JoinColumn(name = "insumo_id")
    private Insumo insumo;

    @ManyToOne
    @JoinColumn(name = "producao_id")
    private Producao producao;

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
