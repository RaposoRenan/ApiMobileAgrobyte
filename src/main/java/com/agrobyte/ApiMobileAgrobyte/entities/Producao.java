package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

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

    // Relação one-to-one com a classe Colheita
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "colheita_id", referencedColumnName = "id")
    private Colheita colheita;

    public Producao() {
    }

    public Producao(String nomeProducao, LocalDate dataEntrada, int tempoPlantio, StatusProducao statusProducao, int quantidadePrevista) {
        this.nomeProducao = nomeProducao;
        this.dataEntrada = dataEntrada;
        this.tempoPlantio = tempoPlantio;
        this.statusProducao = statusProducao;
        this.quantidadePrevista = quantidadePrevista;
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

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public int getTempoPlantio() {
        return tempoPlantio;
    }

    public void setTempoPlantio(int tempoPlantio) {
        this.tempoPlantio = tempoPlantio;
    }

    public int getQuantidadePrevista() {
        return quantidadePrevista;
    }

    public void setQuantidadePrevista(int quantidadePrevista) {
        this.quantidadePrevista = quantidadePrevista;
    }

    public StatusProducao getStatusProducao() {
        return statusProducao;
    }

    public void setStatusProducao(StatusProducao statusProducao) {
        this.statusProducao = statusProducao;
    }

    public Colheita getColheita() {
        return colheita;
    }

    public void setColheita(Colheita colheita) {
        this.colheita = colheita;
        calcularQuantidadeColhida(); // Calcular quantidade colhida quando a colheita é definida
    }

    // Método para calcular a quantidade colhida
    public void calcularQuantidadeColhida() {
        if (colheita != null && colheita.getPerdaErro() != null && colheita.getPerdaDoenca() != null) {
            int perdas = colheita.getPerdaErro() + colheita.getPerdaDoenca();
            int quantidadeColhida = quantidadePrevista - perdas;
            colheita.setQuantidadeColhida(quantidadeColhida);
        }
    }
}
