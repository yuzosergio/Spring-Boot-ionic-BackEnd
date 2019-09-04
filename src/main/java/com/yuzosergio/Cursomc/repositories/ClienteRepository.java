package com.yuzosergio.Cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yuzosergio.Cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente , Integer> {

}
