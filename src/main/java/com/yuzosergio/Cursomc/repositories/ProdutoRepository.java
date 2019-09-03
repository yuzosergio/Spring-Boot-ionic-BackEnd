package com.yuzosergio.Cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yuzosergio.Cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto , Integer> {

}
 