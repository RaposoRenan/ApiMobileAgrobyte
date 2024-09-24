package com.agrobyte.ApiMobileAgrobyte.controllers;

import com.agrobyte.ApiMobileAgrobyte.entities.Producao;
import com.agrobyte.ApiMobileAgrobyte.services.ProducaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/producao")
public class ProducaoController {

    @Autowired
    private ProducaoService producaoService;

    // Endpoint para testar o cálculo de colheita
    @PostMapping("/{id}/colher")
    public Producao iniciarColheita(@PathVariable Long id,
                                    @RequestParam Integer perdaErro,
                                    @RequestParam Integer perdaDoenca) {
        return producaoService.iniciarColheita(id, LocalDate.now(), perdaErro, perdaDoenca);
    }
}
