package com.projectstein.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectstein.cursomc.domain.Pedido;
import com.projectstein.cursomc.repository.PedidoRepository;
import com.projectstein.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Pedido obj = repo.findOne(id);
			if(obj == null) {
				throw new ObjectNotFoundException("Objeto não encontrado! id: "+ 
														id +" Tipo: "+ Pedido.class.getName());
			}
		
		return obj;
	}
	

}
