package com.agrobyte.ApiMobileAgrobyte.DTO;

import com.agrobyte.ApiMobileAgrobyte.entities.Producao;
import com.agrobyte.ApiMobileAgrobyte.entities.StatusProducao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProducaoDTOmin {

    private Long id;
    private LocalDate dataEntrada;
    private int tempoPlantio;
    private int quantidadePrevista;
    private StatusProducao status;

    public ProducaoDTOmin(Producao entity) {
        id = entity.getId();
        dataEntrada = entity.getDataEntrada();
        tempoPlantio = entity.getTempoPlantio();
        quantidadePrevista = entity.getQuantidadePrevista();
        status = entity.getStatusProducao();
    }
}