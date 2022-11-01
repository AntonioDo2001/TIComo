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

import com.TIComoApp.TIComo.model.Rider;
import com.TIComoApp.TIComo.repository.RiderRepository;

@CrossOrigin
@RestController
@RequestMapping("ticomo/riders")



public class RiderController {
	static final  String ERRPWD= "errorPassword";
	
	@Autowired
	private RiderRepository riderRepository;
		
	
	
	
	@GetMapping("")
	List<Rider> index(){
		return riderRepository.findAll();
	}
	
	@GetMapping("/{id}")
	Optional<Rider> obtenerRider(@PathVariable String id) {
		return riderRepository.findById(id);
		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	Rider create(@RequestBody Rider rider) {
		if(rider.contraseniaSegura(rider.getPassword())) {
			String passwordRider = rider.getPassword();
			rider.setPassword(BCrypt.hashpw(passwordRider, BCrypt.gensalt()));
			
			return riderRepository.save(rider);
		}
		else {
			return new Rider(ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD);
		}
	}
	
	@PutMapping("/{id}")
	Rider update(@PathVariable String id, @RequestBody Rider rider) {
		Rider riderFromDB = riderRepository.findById(id).orElseThrow(RuntimeException::new);
		if(rider.contraseniaSegura(rider.getPassword())) {
			riderFromDB.setNombre(rider.getNombre());
			riderFromDB.setApellidos(rider.getApellidos());
			riderFromDB.setNIF(rider.getNIF());
			riderFromDB.setTipoVehiculo(rider.getTipoVehiculo());
			riderFromDB.setMatricula(rider.getMatricula());
			riderFromDB.setCarnet(rider.getCarnet());
			riderFromDB.setEmail(rider.getEmail());
			riderFromDB.setPassword(rider.getPassword());
			
			return riderRepository.save(riderFromDB);
		}
		else {
			return new Rider(ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD);
		}
		
		
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	void delete(@PathVariable String id) {
		Rider rider = riderRepository.findById(id).orElseThrow(RuntimeException::new);
		riderRepository.delete(rider);

	}
	
	
}