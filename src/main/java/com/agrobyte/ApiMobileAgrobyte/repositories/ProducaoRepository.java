package com.agrobyte.ApiMobileAgrobyte.repositories;

import com.agrobyte.ApiMobileAgrobyte.entities.Producao;
import com.agrobyte.ApiMobileAgrobyte.entities.StatusProducao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProducaoRepository extends JpaRepository<Producao, Long> {

    List<Producao> findByStatusProducao(StatusProducao statusProducao);
}