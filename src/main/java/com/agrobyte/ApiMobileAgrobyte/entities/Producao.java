package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_producao")
public class Producao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProducao;

    private LocalDate dataEntrada;

    private int tempoPlantio;

    private int quantidadePrevista;

    @Enumerated(EnumType.STRING)
    private StatusProducao statusProducao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "colheita_id", referencedColumnName = "id")
    private Colheita colheita;

    @OneToMany(mappedBy = "id.producao")
    private List<InsumoProducao> insumos = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producao producao = (Producao) o;
        return Objects.equals(id, producao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
