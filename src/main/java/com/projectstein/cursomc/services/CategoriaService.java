package com.projectstein.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectstein.cursomc.domain.Categoria;
import com.projectstein.cursomc.repository.CategoriaRepository;
import com.projectstein.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
			if(obj == null) {
				throw new ObjectNotFoundException("Objeto não encontrado! id: "+ 
														id +" Tipo: "+ Categoria.class.getName());
			}
		
		return obj;
	}
	

}
