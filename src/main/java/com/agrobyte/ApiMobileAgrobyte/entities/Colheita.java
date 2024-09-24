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
    private Integer perdaErro;
    private Integer perdaDoenca;
    private Integer quantidadeColhida;

    public Colheita() {
    }

    public Colheita(LocalDate dataColheita, Integer perdaErro, Integer perdaDoenca) {
        this.dataColheita = dataColheita;
        this.perdaErro = perdaErro != null ? perdaErro : 0;
        this.perdaDoenca = perdaDoenca != null ? perdaDoenca : 0;
        this.quantidadeColhida = 0; // Inicialmente, até o cálculo ser feito.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataColheita() {
        return dataColheita;
    }

    public void setDataColheita(LocalDate dataColheita) {
        this.dataColheita = dataColheita;
    }

    public Integer getPerdaErro() {
        return perdaErro;
    }

    public void setPerdaErro(Integer perdaErro) {
        this.perdaErro = perdaErro;
    }

    public Integer getPerdaDoenca() {
        return perdaDoenca;
    }

    public void setPerdaDoenca(Integer perdaDoenca) {
        this.perdaDoenca = perdaDoenca;
    }

    public Integer getQuantidadeColhida() {
        return quantidadeColhida;
    }

    public void setQuantidadeColhida(Integer quantidadeColhida) {
        this.quantidadeColhida = quantidadeColhida;
    }
}
