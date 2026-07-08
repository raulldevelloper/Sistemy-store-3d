package com.projectstore.rtdias3d.repository;

import com.projectstore.rtdias3d.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
