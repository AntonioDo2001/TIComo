package com.TIComoApp.TIComo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.TIComoApp.TIComo.model.Entrega;
import com.TIComoApp.TIComo.model.Pedido;
import com.TIComoApp.TIComo.repository.EntregaRepository;

@CrossOrigin
@RestController
@RequestMapping("ticomo/entregas")



public class EntregaController {	
	@Autowired
	private EntregaRepository entregaRepository;
		
	
	
	
	@GetMapping("")
	List<Entrega> index(){
		return entregaRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	List<Entrega> obtenerEntregasCliente(@PathVariable String idCliente) {
		List<Entrega> entregas = entregaRepository.findAll();
		List<Entrega> entregasCliente = new ArrayList<Entrega>();		
		for(int i=0;i<entregas.size();i++) {
			if(entregas.get(i).getIdCliente().equals(idCliente)) {
				entregasCliente.add(entregas.get(i));
			}
		}
		return entregasCliente;
		
	}
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	Entrega create(@RequestBody Entrega entrega) {
		return entregaRepository.save(entrega);
	}
	
	
	@PutMapping("/{id}")
	Entrega asignarRider(@PathVariable String id, String idRider) {
		Entrega entregaFromDB = entregaRepository.findById(id).orElseThrow(RuntimeException::new);
		entregaFromDB.setIdRider(idRider);
		
		return entregaRepository.save(entregaFromDB);
		
	}
	
		
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	void delete(@PathVariable String id) {
		Entrega entrega = entregaRepository.findById(id).orElseThrow(RuntimeException::new);
		entregaRepository.delete(entrega);

	}
	

}