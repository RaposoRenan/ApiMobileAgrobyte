package com.agrobyte.ApiMobileAgrobyte.entities;

import com.agrobyte.ApiMobileAgrobyte.DTO.ProdutoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_producao")
public class Producao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = true)
    private Produto produto;

    private String nomeProducao;

    private LocalDate dataEntrada;

    private int tempoPlantio;

    private int quantidadePrevista;

    @Enumerated(EnumType.STRING)
    private StatusProducao statusProducao;

    @OneToMany(mappedBy = "id.producao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InsumoProducao> insumos = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "colheita_id", referencedColumnName = "id")
    private Colheita colheita;

    public List<Insumo> getInsumo(){
        return insumos.stream().map(x -> x.getInsumo()).toList();
    }

}
