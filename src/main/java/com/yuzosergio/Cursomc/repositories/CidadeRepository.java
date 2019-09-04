package com.yuzosergio.Cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yuzosergio.Cursomc.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade , Integer> {

}
 