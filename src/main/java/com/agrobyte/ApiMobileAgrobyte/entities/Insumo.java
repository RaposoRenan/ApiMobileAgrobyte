package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_insumo")
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double valorUnitario;

    @OneToMany(mappedBy = "id.insumo")
    private Set<InsumoProducao> insumos = new HashSet<>();

    public List<Producao> getProducao() {
        return insumos.stream().map(x -> x.getProducao()).toList();
    }
}
