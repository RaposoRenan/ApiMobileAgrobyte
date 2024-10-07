package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;

import java.util.*;

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

    public Insumo() {
    }

    public Insumo(Long id, String nomeInsumo, Double valorUnitario) {
        this.id = id;
        this.nome = nomeInsumo;
        this.valorUnitario = valorUnitario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Set<InsumoProducao> getInsumos() {
        return insumos;
    }

    public List<Producao> getProducao(){
        return insumos.stream().map(x -> x.getProducao()).toList();
    }

    public void setInsumos(Set<InsumoProducao> insumos) {
        this.insumos = insumos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Insumo insumo = (Insumo) o;
        return Objects.equals(id, insumo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
