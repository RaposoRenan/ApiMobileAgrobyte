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

    @OneToMany(mappedBy = "id.product")
    private List<InsumoProducao> items = new ArrayList<>();

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

    public List<InsumoProducao> getItems() {
        return items;
    }

    public List<Producao> getOrders(){
        return items.stream().map(x -> x.getProducao()).toList();
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
