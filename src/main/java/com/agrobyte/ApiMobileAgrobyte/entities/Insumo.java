package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_insumo")
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double valorUnitario;

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
}
