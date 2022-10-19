package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Coche;

import com.example.service.CocheService;


@RequestMapping("api1")
@RestController
public class CocheController {
	
	@Autowired
	private CocheService cocheServ;
	
	
	@PostMapping(value= "/coches")
	public void save(@RequestBody Coche coche) {
		cocheServ.save(coche);
	}
	
	@GetMapping(value= "/coches")
	public List	<Coche> findAll(){
		return cocheServ.findAll();
	}
	
	@GetMapping(value= "/coche/{id}")
	public Optional<Coche> findById(@PathVariable String id) {
		return cocheServ.findById(id);	
	}
	
	@GetMapping(value="/coches/{id}")
	public List<ArrayList<Coche>> findByIdCoche(@PathVariable String id) {
		ArrayList<Coche> coches = new ArrayList();
		coches=(ArrayList<Coche>) cocheServ.findAll();
		ArrayList<Coche> cochesUsuario = new ArrayList();
		for(int i=0;i<coches.size();i++) {
			if(coches.get(i).getUsuario().equals(id)) {
				cochesUsuario.add(coches.get(i));
				
			}
		}
		
		return Arrays.asList(cochesUsuario);
	}	
}