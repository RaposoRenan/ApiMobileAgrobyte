package com.agrobyte.ApiMobileAgrobyte.repositories;

import com.agrobyte.ApiMobileAgrobyte.entities.Insumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InsumoRepository extends JpaRepository<Insumo, Long> {

    @Query("SELECT obj FROM Insumo obj " +
            "WHERE UPPER(obj.nome) LIKE UPPER(CONCAT('%', :nome, '%'))")
    Page<Insumo> searchByName(String nome, Pageable pageable);
}
