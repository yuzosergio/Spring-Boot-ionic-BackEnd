package com.yuzosergio.Cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzosergio.Cursomc.domain.Categoria;
import com.yuzosergio.Cursomc.repositories.CategoriaRepository;
import com.yuzosergio.Cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

		@Autowired
		private CategoriaRepository repo;
		 
		public Categoria find(Integer id) {
			Optional<Categoria> obj = repo.findById(id);
			
			return obj.orElseThrow(() ->new ObjectNotFoundException("Objeto não encontrado! id: " + id
						+", Tipo: "+ Categoria.class.getName()));
			}
		
		
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	}
