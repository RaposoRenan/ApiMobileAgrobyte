package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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

    @OneToOne
    @JoinColumn(name = "producao_id")
    private Producao producao;
}