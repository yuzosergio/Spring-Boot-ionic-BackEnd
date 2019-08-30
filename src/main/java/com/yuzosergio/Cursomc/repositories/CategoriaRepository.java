package com.yuzosergio.Cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yuzosergio.Cursomc.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria , Integer> {

}
