package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_colheita")
public class Colheita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataColheita;
    private Integer qntdColhida;
    private Integer perdaDoenca;
    private Integer perdaErro;

    public Colheita(LocalDate dataColheita, Integer perdaErro, Integer perdaDoenca) {
        this.dataColheita = dataColheita;
        this.perdaErro = perdaErro != null ? perdaErro : 0;
        this.perdaDoenca = perdaDoenca != null ? perdaDoenca : 0;
        this.qntdColhida = 0;
    }
}