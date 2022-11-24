/*********************************************************************
 *
 * Class Name: RiderController
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira de controlador para todas las funciones posibles de la clase rider en la base de datos
 *
 **********************************************************************
 */

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

import com.TIComoApp.TIComo.model.Cliente;
import com.TIComoApp.TIComo.model.Rider;
import com.TIComoApp.TIComo.repository.RiderRepository;

@CrossOrigin
@RestController
@RequestMapping("ticomo/riders")



public class RiderController {
	static final  String ERRPWD= "errorPassword";
	static final  String EMFORMERR= "emailFormato";
	static final  String ERRMATR= "errorMatricula";
	
	@Autowired
	private RiderRepository riderRepository;
		
	
	/*
	* 
	*
	* Method name:Index
	* Description of the Method: se encarga de mostrar una lista de riders de la base de datos
	* Calling arguments: Ninguno
	* Return value: List<Rider>
	* Required Files: Tabla riders de MongoDB
	*
	*
	*/
	
	@GetMapping("")
	public
	List<Rider> index(){
		return riderRepository.findAll();
	}
	
	/*
	* 
	*
	* Method name: obtenerRider
	* Description of the Method: se encarga de obtener un rider en concreto de la base de datos
	* Calling arguments: Un id de rider(para buscarle en la base de datos)
	* Return value: Optional<Rider>
	* Required Files: Tabla riders de MongoDB
	*
	*
	*/
	
	@GetMapping("/{id}")
	public
	Optional<Rider> obtenerRider(@PathVariable String id) {
		return riderRepository.findById(id);
		
	}
	/*
	* 
	*
	* Method name: create
	* Description of the Method: se encarga de comprobar si el rider que se está intentando crear en la base de datos sigue los criterios establecidos
	* Calling arguments: Un rider
	* Return value: Un rider
	* Required Files: Tabla riders de MongoDB
	*
	*
	*/
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public
	Rider create(@RequestBody Rider rider) {
		if(rider.contraseniaSegura(rider.getPassword())) {
			String passwordRider = rider.getPassword();
			rider.setPassword(BCrypt.hashpw(passwordRider, BCrypt.gensalt()));	
			if(!rider.comprobarMatricula(rider.getMatricula())) {
				return new Rider(ERRMATR,ERRMATR,ERRMATR,ERRMATR,ERRMATR,ERRMATR,ERRMATR,ERRMATR,ERRMATR);
			}
			else if(!rider.formatoCorreoCorrecto(rider.getEmail())) {
				return new Rider(EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR);
			}else {
				return riderRepository.save(rider);
			}
		}
		else {
			return new Rider(ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD);
		}
	}
	/*
	* 
	*
	* Method name: update
	* Description of the Method: se encarga de actualizar un rider en concreto en la base de datos
	* Calling arguments: Un id (Para buscar el rider en la base de datos) y un rider(Los datos nuevos del cliente)
	* Return value: Un rider
	* Required Files: Tabla riders de MongoDB
	*
	*
	*/
	@PutMapping("/{id}")
	public
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
			riderFromDB.setValoracionMedia(rider.getValoracionMedia());
			
			if(!rider.comprobarMatricula(rider.getMatricula())) {
				return new Rider(ERRMATR,ERRMATR,ERRMATR,ERRMATR,ERRMATR,ERRMATR,ERRMATR,ERRMATR,ERRMATR);
			}
			else if(!rider.formatoCorreoCorrecto(rider.getEmail())) {
				return new Rider(EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR);
			}else {
				return riderRepository.save(riderFromDB);
			}
		}
		else {
			return new Rider(ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD);
		}
		
		
		
	}
	
	/*
	* 
	*
	* Method name: desactivarActivarRider
	* Description of the Method: se encarga de activar/desactivar un rider en concreto en la base de datos
	* Calling arguments: Un rider (Para buscar el rider en la base de datos)
	* Return value: Un rider
	* Required Files: Tabla riders de MongoDB
	*
	*
	*/
	@PutMapping("")
	public
	Rider desactivarActivarRider(@RequestBody Rider rider) {
		Rider riderFromDB = riderRepository.findById(rider.getId()).orElseThrow(RuntimeException::new);
		riderFromDB.setCuentaActiva(rider.isCuentaActiva());
		return riderRepository.save(riderFromDB);
	}
	
	/*
	* 
	*
	* Method name: delete
	* Description of the Method: se encarga de eliminar un rider en concreto en la base de datos
	* Calling arguments: Un id (Para buscar el rider en la base de datos)
	* Return value: void
	* Required Files: Tabla riders de MongoDB
	*
	*
	*/
	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public
	void delete(@PathVariable String id) {
		Rider rider = riderRepository.findById(id).orElseThrow(RuntimeException::new);
		riderRepository.delete(rider);

	}
	
	
}