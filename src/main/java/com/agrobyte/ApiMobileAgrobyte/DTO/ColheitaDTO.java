package com.agrobyte.ApiMobileAgrobyte.DTO;

import com.agrobyte.ApiMobileAgrobyte.entities.Colheita;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ColheitaDTO {

    private Long id;
    private LocalDate dataColheita;
    private Integer qntdColhida;
    private Integer perdaDoenca;
    private Integer perdaErro;

    public ColheitaDTO(Colheita entity) {
        id = entity.getId();
        dataColheita = entity.getDataColheita();
        qntdColhida = entity.getQntdColhida();
        perdaDoenca = entity.getPerdaDoenca();
        perdaErro = entity.getPerdaErro();
    }
}
