package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_producao")
public class Producao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // quantidade esperada

    private String nomeProducao;

    @Temporal(TemporalType.DATE)
    private Date dataEntrada;

    @Temporal(TemporalType.DATE)
    private Date dataSaida;

    private int tempoPlantio;

    @Enumerated(EnumType.STRING)
    private StatusProducao statusProducao;


    @OneToMany(mappedBy = "producao")
    private Set<Colheita> colheitas = new HashSet<>();

    public Producao() {
    }

    public Producao(String nomeProducao, Date dataEntrada, int tempoPlantio, StatusProducao statusProducao) {
        this.nomeProducao = nomeProducao;
        this.dataEntrada = dataEntrada;
        this.tempoPlantio = tempoPlantio;
        this.statusProducao = statusProducao;
    }

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

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
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
}
