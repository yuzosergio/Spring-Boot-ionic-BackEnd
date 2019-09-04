package com.yuzosergio.Cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yuzosergio.Cursomc.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado , Integer> {

}
 