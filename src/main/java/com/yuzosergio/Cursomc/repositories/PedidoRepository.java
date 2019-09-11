package com.yuzosergio.Cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yuzosergio.Cursomc.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido , Integer> {

}
 