package com.TIComoApp.TIComo.controller;

import java.util.List;
import java.util.Optional;

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

import com.TIComoApp.TIComo.model.Plato;
import com.TIComoApp.TIComo.repository.PlatoRepository;

@CrossOrigin
@RestController
@RequestMapping("ticomo/platos")



public class PlatoController {
	
	@Autowired
	private PlatoRepository platoRepository;
		
	
	
	
	@GetMapping("")
	List<Plato> index(){
		return platoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	Optional<Plato> obtenerPlato(@PathVariable String id) {
		return platoRepository.findById(id);
		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	Plato create(@RequestBody Plato plato) {
		return platoRepository.save(plato);
	}
	
	@PutMapping("/{id}")
	Plato update(@PathVariable String id, @RequestBody Plato plato) {
		Plato platoFromDB = platoRepository.findById(id).orElseThrow(RuntimeException::new);
		
		platoFromDB.setNombre(plato.getNombre());
		platoFromDB.setFoto(plato.getFoto());
		platoFromDB.setDescripcion(plato.getDescripcion());
		platoFromDB.setPrecio(plato.getPrecio());
		platoFromDB.setAptoVeganos(plato.isAptoVeganos());
		platoFromDB.setNombreRestaurante(plato.getNombreRestaurante());
		
		
		return platoRepository.save(platoFromDB);
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	void delete(@PathVariable String id) {
		Plato plato = platoRepository.findById(id).orElseThrow(RuntimeException::new);
		platoRepository.delete(plato);

	}

}