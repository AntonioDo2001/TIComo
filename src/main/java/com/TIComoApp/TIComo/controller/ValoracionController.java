
package com.TIComoApp.TIComo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.TIComoApp.TIComo.model.Valoracion;
import com.TIComoApp.TIComo.repository.ValoracionRepository;

@CrossOrigin
@RestController
@RequestMapping("ticomo/valoraciones")



public class ValoracionController {
	
	
	@Autowired
	private ValoracionRepository valoracionRepository;
	
		
	
	
	
	@GetMapping("")
	public
	List<Valoracion> index(){
		return valoracionRepository.findAll();
	}
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public
	Valoracion create(@RequestBody Valoracion valoracion) {
		
		return valoracionRepository.save(valoracion);
		
	}
	


}
