/*********************************************************************
 *
 * Class Name: PlatoController
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira de controlador para todas las funciones posibles de la clase plato en la base de datos
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

import com.TIComoApp.TIComo.model.Plato;
import com.TIComoApp.TIComo.repository.PlatoRepository;

@CrossOrigin
@RestController
@RequestMapping("ticomo/platos")



public class PlatoController {
	
	@Autowired
	private PlatoRepository platoRepository;
		
	/*
	* 
	*
	* Method name:Index
	* Description of the Method: se encarga de mostrar una lista de platos de la base de datos
	* Calling arguments: Ninguno
	* Return value: List<Plato>
	* Required Files: Tabla platos de MongoDB
	*
	*
	*/
	
	
	@GetMapping("")
	public
	List<Plato> index(){
		return platoRepository.findAll();
	}
	/*
	* 
	*
	* Method name:obtenerPlato
	* Description of the Method: se encarga de mostrar un plato en concreto de la base de datos
	* Calling arguments: Un id de plato(para buscarle en la base de datos)
	* Return value: Optional<plato>
	* Required Files: Tabla platos de MongoDB
	*
	*/
	
	@GetMapping("/{id}")
	public
	Optional<Plato> obtenerPlato(@PathVariable String id) {
		return platoRepository.findById(id);
		
	}
	/*
	* 
	*
	* Method name: create
	* Description of the Method: se encarga de introducir en la base de datos un platp
	* Calling arguments: Un plato
	* Return value: Un plato
	* Required Files: Tabla platos de MongoDB
	*
	*
	*/
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public
	Plato create(@RequestBody Plato plato) {
		return platoRepository.save(plato);
	}
	/*
	* 
	*
	* Method name: update
	* Description of the Method: se encarga de actualizar un plato en concreto en la base de datos
	* Calling arguments: Un id (Para buscar el plato en la base de datos) y un plato(Los datos nuevos del plato)
	* Return value: Un plato
	* Required Files: Tabla platos de MongoDB
	*
	*
	*/
	@PutMapping("/{id}")
	public
	Plato update(@PathVariable String id, @RequestBody Plato plato) {
		Plato platoFromDB = platoRepository.findById(id).orElseThrow(RuntimeException::new);
		
		platoFromDB.setNombre(plato.getNombre());
		platoFromDB.setFoto(plato.getFoto());
		platoFromDB.setDescripcion(plato.getDescripcion());
		platoFromDB.setPrecio(plato.getPrecio());
		platoFromDB.setAptoVeganos(plato.isAptoVeganos());
		platoFromDB.setNombreRestaurante(plato.getNombreRestaurante());
		
		
		return platoRepository.save(platoFromDB);
		
	}
	/*
	* 
	*
	* Method name: delete
	* Description of the Method: se encarga de eliminar un plato en concreto en la base de datos
	* Calling arguments: Un id (Para buscar el plato en la base de datos)
	* Return value: void
	* Required Files: Tabla platos de MongoDB
	*
	*
	*/
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public
	void delete(@PathVariable String id) {
		Plato plato = platoRepository.findById(id).orElseThrow(RuntimeException::new);
		platoRepository.delete(plato);

	}

}