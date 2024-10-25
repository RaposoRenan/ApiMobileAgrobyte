package com.agrobyte.ApiMobileAgrobyte.repositories;

import com.agrobyte.ApiMobileAgrobyte.entities.InsumoProducao;
import com.agrobyte.ApiMobileAgrobyte.entities.InsumoProducaoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsumoProducaoRepository extends JpaRepository<InsumoProducao, InsumoProducaoPK> {
}
