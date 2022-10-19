package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Coche;
import com.example.model.Usuario;
import com.example.repository.CocheRepository;


@Service
public class CocheService {
	
	@Autowired
	private CocheRepository cocheRepo;
	
	
	public CocheService(CocheRepository cocheRepo) {
		this.cocheRepo=cocheRepo;
	}
	
	public void save (Coche coche) {
		cocheRepo.save(coche);
	}
	
	public List<Coche> findAll(){
		return cocheRepo.findAll();
	}
	
	public Optional<Coche> findById(String id){
		return cocheRepo.findById(id);
	}
	
	
	public void deleteById(String id) {
		cocheRepo.deleteById(id);
	}
}
