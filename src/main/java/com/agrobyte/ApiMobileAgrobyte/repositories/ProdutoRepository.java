package com.agrobyte.ApiMobileAgrobyte.repositories;

import com.agrobyte.ApiMobileAgrobyte.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}