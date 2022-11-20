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

import com.TIComoApp.TIComo.model.Restaurante;
import com.TIComoApp.TIComo.repository.RestauranteRepository;

@CrossOrigin
@RestController
@RequestMapping("ticomo/restaurantes")



public class RestauranteController {
	
	static final  String ERRORTLF= "tlfFormErr";
	static final  String EMFORMERR= "emailFormato";
	
	@Autowired
	private RestauranteRepository restauranteRepository;
		
	
	
	
	@GetMapping("")
	List<Restaurante> index(){
		return restauranteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	Optional<Restaurante> obtenerRestaurante(@PathVariable String id) {
		return restauranteRepository.findById(id);
		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	Restaurante create(@RequestBody Restaurante restaurante) {
		if(!restaurante.telefonoValido(restaurante.getTelefono())) {
			return new Restaurante(ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF);
		}else if(!restaurante.formatoCorreoCorrecto(restaurante.getEmail())) {
			return new Restaurante(EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR);
		}
		else {
			return restauranteRepository.save(restaurante);
		}
		
	}
	
	@PutMapping("/{id}")
	Restaurante update(@PathVariable String id, @RequestBody Restaurante restaurante) {
		Restaurante restauranteFromDB = restauranteRepository.findById(id).orElseThrow(RuntimeException::new);
		if(!restaurante.telefonoValido(restaurante.getTelefono())) {
			return new Restaurante(ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF);
		}
		else {
			restauranteFromDB.setNombre(restaurante.getNombre());
			restauranteFromDB.setRazonSocial(restaurante.getRazonSocial());
			restauranteFromDB.setCIF(restaurante.getCIF());
			restauranteFromDB.setDireccionCompleta(restaurante.getDireccionCompleta());
			restauranteFromDB.setTelefono(restaurante.getTelefono());
			restauranteFromDB.setEmail(restaurante.getEmail());
			restauranteFromDB.setCategoria(restaurante.getCategoria());
			restauranteFromDB.setValoracionMedia(restaurante.getValoracionMedia());
			
			
			return restauranteRepository.save(restauranteFromDB);
		}
		
		
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	void delete(@PathVariable String id) {
		Restaurante restaurante = restauranteRepository.findById(id).orElseThrow(RuntimeException::new);
		restauranteRepository.delete(restaurante);

	}

}