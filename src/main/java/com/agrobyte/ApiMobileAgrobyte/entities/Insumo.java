package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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
    private Integer quantidadeEstoque;
    private LocalDate dataValidade;

    @OneToMany(mappedBy = "id.insumo")
    private Set<InsumoProducao> insumos = new HashSet<>();

    public List<Producao> getProducao() {
        return insumos.stream().map(x -> x.getProducao()).toList();
    }

    public void atualizarEstoque(Integer quantidade) {
        this.quantidadeEstoque = Math.max(this.quantidadeEstoque - quantidade, 0);
    }
}