package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_producao")
public class Producao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProducao;

    private LocalDate dataEntrada;

    private LocalDate dataSaida;

    private int tempoPlantio;

    private int quantidadePrevista;

    @Enumerated(EnumType.STRING)
    private StatusProducao statusProducao;

    @OneToMany(mappedBy = "producao")
    private Set<Colheita> colheitas = new HashSet<>();

    public Producao() {
    }

    public Producao(String nomeProducao, LocalDate dataEntrada, LocalDate dataSaida, int tempoPlantio, StatusProducao statusProducao, int quantidadePrevista) {
        this.nomeProducao = nomeProducao;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.tempoPlantio = tempoPlantio;
        this.statusProducao = statusProducao;
        this.quantidadePrevista = quantidadePrevista;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProducao() {
        return nomeProducao;
    }

    public void setNomeProducao(String nomeProducao) {
        this.nomeProducao = nomeProducao;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public int getTempoPlantio() {
        return tempoPlantio;
    }

    public void setTempoPlantio(int tempoPlantio) {
        this.tempoPlantio = tempoPlantio;
    }

    public StatusProducao getStatusProducao() {
        return statusProducao;
    }

    public void setStatusProducao(StatusProducao statusProducao) {
        this.statusProducao = statusProducao;
    }

    public int getQuantidadePrevista() {
        return quantidadePrevista;
    }

    public void setQuantidadePrevista(int quantidadePrevista) {
        this.quantidadePrevista = quantidadePrevista;
    }

    public Set<Colheita> getColheitas() {
        return colheitas;
    }

    public void setColheitas(Set<Colheita> colheitas) {
        this.colheitas = colheitas;
    }
}
