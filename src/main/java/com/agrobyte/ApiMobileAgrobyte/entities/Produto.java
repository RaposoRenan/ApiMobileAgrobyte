package com.agrobyte.ApiMobileAgrobyte.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double valorUnitario;
    private Integer quantidadeEstoque;
    private LocalDate dataValidade;

    @OneToMany(mappedBy = "produto")
    private List<Producao> producao = new ArrayList<>();

    public List<Produto> getProducao() {
        return producao.stream().map(x -> x.getProduto()).toList();
    }
}
