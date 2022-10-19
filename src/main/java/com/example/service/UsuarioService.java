package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Usuario;
import com.example.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	
	public UsuarioService(UsuarioRepository usuarioRepo) {
		this.usuarioRepo=usuarioRepo;
	}
	
	public void save (Usuario usuario) {
		usuarioRepo.save(usuario);
	}
	
	public List<Usuario> findAll(){
		return usuarioRepo.findAll();
	}
	
	public Optional<Usuario> findById(String id){
		return usuarioRepo.findById(id);
	}
	
	public void deleteById(String id) {
		usuarioRepo.deleteById(id);
	}
	
}
