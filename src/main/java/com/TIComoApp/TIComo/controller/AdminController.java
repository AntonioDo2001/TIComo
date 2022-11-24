/*********************************************************************
 *
 * Class Name: AdministradorController
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira de controlador para todas las funciones posibles de la clase administrador en la base de datos
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

import com.TIComoApp.TIComo.model.Administrador;
import com.TIComoApp.TIComo.repository.AdministradorRepository;

@CrossOrigin
@RestController
@RequestMapping("ticomo/admins")



public class AdminController {
	static final  String ERRPWD= "errorPassword";
	
	@Autowired
	private AdministradorRepository adminRepository;
		
	
	/*
	* 
	*
	* Method name:Index
	* Description of the Method: se encarga de mostrar una lista de administradores de la base de datos
	* Calling arguments: Ninguno
	* Return value: List<Administrador>
	* Required Files: Tabla adminstradores de MongoDB
	*
	*
	*/
	@GetMapping("")
	public
	List<Administrador> index(){
		return adminRepository.findAll();
	}
	
	/*
	* 
	*
	* Method name: obtenerAdmin
	* Description of the Method: se encarga de obtener un administrador en concreto de la base de datos
	* Calling arguments: Un id de administrador(Para buscarle en la base de datos)
	* Return value: Optional<Administrador>
	* Required Files: Tabla adminstradores de MongoDB
	*
	*
	*/
	@GetMapping("/{id}")
	public
	Optional<Administrador> obtenerAdmin(@PathVariable String id) {
		return adminRepository.findById(id);
		
	}
	
	/*
	* 
	*
	* Method name: create
	* Description of the Method: se encarga de comprobar si el administrador que se está intentando crear en la base de datos sigue los criterios establecidos
	* Calling arguments: Un administrador
	* Return value: Un administrador
	* Required Files: Tabla adminstradores de MongoDB
	*
	*
	*/
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public
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
	
	/*
	* 
	*
	* Method name: update
	* Description of the Method: se encarga de actualizar un administrador en concreto en la base de datos
	* Calling arguments: Un id (Para buscar el administrador en la base de datos) y un administrador(Los datos nuevos del administrador)
	* Return value: Un administrador
	* Required Files: Tabla adminstradores de MongoDB
	*
	*
	*/
	@PutMapping("/{id}")
	public
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
	/*
	* 
	*
	* Method name: delete
	* Description of the Method: se encarga de eliminar un administrador en concreto en la base de datos
	* Calling arguments: Un id (Para buscar el administrador en la base de datos)
	* Return value: void
	* Required Files: Tabla adminstradores de MongoDB
	*
	*
	*/
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public
	void delete(@PathVariable String id) {
		Administrador admin = adminRepository.findById(id).orElseThrow(RuntimeException::new);
		adminRepository.delete(admin);

	}
	

}