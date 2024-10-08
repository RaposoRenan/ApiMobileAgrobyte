package com.agrobyte.ApiMobileAgrobyte.DTO;

import com.agrobyte.ApiMobileAgrobyte.entities.Insumo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsumoDTO {
    private Long id;
    private String nome;
    private Double valorUnitario;

    public InsumoDTO(Insumo entity) {
        id = entity.getId();
        nome = entity.getNome();
        valorUnitario = entity.getValorUnitario();
    }

    @NotBlank(message = "Campo requerido")
    public String getNome() {
        return nome;
    }

    @Positive(message = "Quantidade tem que ser positiva")
    public Double getValorUnitario() {
        return valorUnitario;
    }
}
