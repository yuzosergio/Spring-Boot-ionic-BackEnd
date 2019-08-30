package com.yuzosergio.Cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzosergio.Cursomc.domain.Categoria;
import com.yuzosergio.Cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

		@Autowired
		private CategoriaRepository repo;
		 
		public Categoria find(Integer id) {
			Optional<Categoria> obj = repo.findById(id);
			return obj.orElse(null);
		}
}
