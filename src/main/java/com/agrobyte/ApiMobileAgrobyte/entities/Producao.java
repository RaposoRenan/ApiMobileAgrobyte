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

    private String nomeProducao;

    @Temporal(TemporalType.DATE)
    private Date dataEntrada;

    @Temporal(TemporalType.DATE)
    private Date dataSaida;

    private int tempoPlantio;

    // Quantidade total de produtos que foram plantados
    private int quantidadePlantada;

    // Quantidade realmente produzida após o plantio
    private int quantidadeProduzida;

    // Observações sobre o processo de produção (pode incluir detalhes sobre a produção ou perdas)
    private String observacoes;

    @OneToMany(mappedBy = "id.producao")
    private Set<InsumoProducao> insumos = new HashSet<>();

    @OneToMany(mappedBy = "producao")
    private Set<PerdaProducao> perdas = new HashSet<>();

    public Producao() {
    }

    public Producao(String nomeProducao, Date dataEntrada, Date dataSaida, int tempoPlantio, int quantidadePlantada, int quantidadeProduzida) {
        this.nomeProducao = nomeProducao;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.tempoPlantio = tempoPlantio;
        this.quantidadePlantada = quantidadePlantada;
        this.quantidadeProduzida = quantidadeProduzida;
    }

    // Métodos para calcular a quantidade final após perdas
    public int getQuantidadeFinalParaEstoque() {
        int totalPerdas = perdas.stream().mapToInt(PerdaProducao::getQuantidadePerdida).sum();
        return this.quantidadeProduzida - totalPerdas;
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

    public int getQuantidadePlantada() {
        return quantidadePlantada;
    }

    public void setQuantidadePlantada(int quantidadePlantada) {
        this.quantidadePlantada = quantidadePlantada;
    }

    public int getQuantidadeProduzida() {
        return quantidadeProduzida;
    }

    public void setQuantidadeProduzida(int quantidadeProduzida) {
        this.quantidadeProduzida = quantidadeProduzida;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
