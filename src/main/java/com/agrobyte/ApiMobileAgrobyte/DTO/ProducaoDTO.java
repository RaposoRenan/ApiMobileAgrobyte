package com.agrobyte.ApiMobileAgrobyte.DTO;

import com.agrobyte.ApiMobileAgrobyte.entities.Producao;
import com.agrobyte.ApiMobileAgrobyte.entities.StatusProducao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProducaoDTO {

    private Long id;
    private String nomeProducao;
    private LocalDate dataEntrada;
    private int tempoPlantio;
    private int quantidadePrevista;
    private StatusProducao status;
    private List<InsumoDTO> insumos = new ArrayList<>();

    public ProducaoDTO(Long id, String nomeProducao, LocalDate dataEntrada, int tempoPlantio, int quantidadePrevista, StatusProducao status) {
        this.id = id;
        this.nomeProducao = nomeProducao;
        this.dataEntrada = dataEntrada;
        this.tempoPlantio = tempoPlantio;
        this.quantidadePrevista = quantidadePrevista;
        this.status = status;
    }

    public ProducaoDTO(Producao entity) {
        id = entity.getId();
        nomeProducao = entity.getNomeProducao();
        dataEntrada = entity.getDataEntrada();
        tempoPlantio = entity.getTempoPlantio();
        quantidadePrevista = entity.getQuantidadePrevista();
        status = entity.getStatusProducao();
    }

    public Long getId() {
        return id;
    }

    @NotBlank(message = "Campo requerido")
    public String getNomeProducao() {
        return nomeProducao;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    @Positive(message = "Quantidade tem que ser positiva")
    public int getTempoPlantio() {
        return tempoPlantio;
    }

    @Positive(message = "Quantidade tem que ser positiva")
    public int getQuantidadePrevista() {
        return quantidadePrevista;
    }

    public StatusProducao getStatus() {
        return status;
    }

    public List<InsumoDTO> getInsumos() {
        return insumos;
    }
}
