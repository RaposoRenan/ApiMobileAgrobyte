package com.agrobyte.ApiMobileAgrobyte.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "Estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private String nome;

    private int quantidade;

    private LocalDateTime dataEntrada;

    private LocalDateTime dataSaida;

    private LocalDate dataValidade;
}
