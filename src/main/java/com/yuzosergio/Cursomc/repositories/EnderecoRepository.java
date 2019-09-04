package com.yuzosergio.Cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yuzosergio.Cursomc.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco , Integer> {

}
