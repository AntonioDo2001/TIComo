/*********************************************************************
 *
 * Class Name: RestauranteController
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira de controlador para todas las funciones posibles de la clase restaurante en la base de datos
 *
 **********************************************************************
 */

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
	
	@Autowired
	private RestauranteRepository restauranteRepository;
		
	
	/*
	* 
	*
	* Method name:Index
	* Description of the Method: se encarga de mostrar una lista de restaurantes de la base de datos
	* Calling arguments: Ninguno
	* Return value: List<Restaurante>
	* Required Files: Tabla restaurantes de MongoDB
	*
	*
	*/
	
	@GetMapping("")
	public
	List<Restaurante> index(){
		return restauranteRepository.findAll();
	}
	
	/*
	* 
	*
	* Method name:obtenerRestaurante
	* Description of the Method: se encarga de mostrar un restaurante en concreto de la base de datos
	* Calling arguments: Un id de restaurante(para buscarle en la base de datos)
	* Return value: Optional<Restaurante>
	* Required Files: Tabla restaurantes de MongoDB
	*
	*/
	@GetMapping("/{id}")
	public
	Optional<Restaurante> obtenerRestaurante(@PathVariable String id) {
		return restauranteRepository.findById(id);
		
	}
	/*
	* 
	*
	* Method name: create
	* Description of the Method: se encarga de introducir en la base de datos un restaurante
	* Calling arguments: Un restaurante
	* Return value: Un restaurante
	* Required Files: Tabla restaurantes de MongoDB
	*
	*
	*/
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public
	Restaurante create(@RequestBody Restaurante restaurante) {
		return restauranteRepository.save(restaurante);
	}
	/*
	* 
	*
	* Method name: update
	* Description of the Method: se encarga de actualizar un restaurante en concreto en la base de datos
	* Calling arguments: Un id (Para buscar el restaurante en la base de datos) y un restaurante(Los datos nuevos del restaurante)
	* Return value: Un restaurante
	* Required Files: Tabla restaurantes de MongoDB
	*
	*
	*/
	@PutMapping("/{id}")
	public
	Restaurante update(@PathVariable String id, @RequestBody Restaurante restaurante) {
		Restaurante restauranteFromDB = restauranteRepository.findById(id).orElseThrow(RuntimeException::new);
		
		restauranteFromDB.setNombre(restaurante.getNombre());
		restauranteFromDB.setRazonSocial(restaurante.getRazonSocial());
		restauranteFromDB.setCIF(restaurante.getCIF());
		restauranteFromDB.setDireccionCompleta(restaurante.getDireccionCompleta());
		restauranteFromDB.setTelefono(restaurante.getTelefono());
		restauranteFromDB.setEmail(restaurante.getEmail());
		restauranteFromDB.setCategoria(restaurante.getCategoria());
		
		
		return restauranteRepository.save(restauranteFromDB);
		
	}
	/*
	* 
	*
	* Method name: delete
	* Description of the Method: se encarga de eliminar un restaurante en concreto en la base de datos
	* Calling arguments: Un id (Para buscar el restaurante en la base de datos)
	* Return value: void
	* Required Files: Tabla restaurantes de MongoDB
	*
	*
	*/
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public
	void delete(@PathVariable String id) {
		Restaurante restaurante = restauranteRepository.findById(id).orElseThrow(RuntimeException::new);
		restauranteRepository.delete(restaurante);

	}

}