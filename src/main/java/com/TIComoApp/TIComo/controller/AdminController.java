package com.TIComoApp.TIComo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
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

import com.TIComoApp.TIComo.model.Administrador;
import com.TIComoApp.TIComo.repository.AdministradorRepository;

@CrossOrigin
@RestController
@RequestMapping("ticomo/admins")



public class AdminController {
	static final  String ERRPWD= "errorPassword";
	
	@Autowired
	private AdministradorRepository adminRepository;
		
	
	
	
	@GetMapping("")
	List<Administrador> index(){
		return adminRepository.findAll();
	}
	
	@GetMapping("/{id}")
	Optional<Administrador> obtenerAdmin(@PathVariable String id) {
		return adminRepository.findById(id);
		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	Administrador create(@RequestBody Administrador admin) {
		if(admin.contraseniaSegura(admin.getPassword())) {
			String passwordAdmin = admin.getPassword();
			admin.setPassword(BCrypt.hashpw(passwordAdmin, BCrypt.gensalt()));
			
			return adminRepository.save(admin);
		}
		else {
			return new Administrador(ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD);
		}
	}
	
	@PutMapping("/{id}")
	Administrador update(@PathVariable String id, @RequestBody Administrador admin) {
		if(admin.contraseniaSegura(admin.getPassword())) {
			Administrador adminFromDB = adminRepository.findById(id).orElseThrow(RuntimeException::new);
			
			adminFromDB.setNombre(admin.getNombre());
			adminFromDB.setApellidos(admin.getApellidos());
			adminFromDB.setZona(admin.getZona());
			adminFromDB.setEmail(admin.getEmail());
			adminFromDB.setPassword(admin.getPassword());
			
			return adminRepository.save(adminFromDB);
		}
		else {
			return new Administrador(ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD);
		}
		
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	void delete(@PathVariable String id) {
		Administrador admin = adminRepository.findById(id).orElseThrow(RuntimeException::new);
		adminRepository.delete(admin);

	}
	

}
