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

    // Quantidade total de produtos plantados
    private int quantidadePlantada;

    // Observações sobre a produção
    private String observacoes;

    @OneToMany(mappedBy = "id.producao", cascade = CascadeType.ALL)
    private Set<InsumoProducao> insumos = new HashSet<>();

    @OneToOne(mappedBy = "producao", cascade = CascadeType.ALL)
    private Colheita colheita;

    public Producao() {
    }

    public Producao(String nomeProducao, Date dataEntrada, Date dataSaida, int tempoPlantio, int quantidadePlantada) {
        this.nomeProducao = nomeProducao;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.tempoPlantio = tempoPlantio;
        this.quantidadePlantada = quantidadePlantada;
    }

    // Método para obter a quantidade final para o estoque após a colheita
    public int getQuantidadeFinalParaEstoque() {
        if (colheita != null) {
            return colheita.getQuantidadeFinalParaEstoque();
        }
        return 0; // Caso a colheita ainda não tenha ocorrido
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

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
