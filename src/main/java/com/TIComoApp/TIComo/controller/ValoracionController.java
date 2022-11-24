/*********************************************************************
 *
 * Class Name: ValoracionController
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira de controlador para todas las funciones posibles de la clase valoracion en la base de datos
 *
 **********************************************************************
 */

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
		
	
	/*
	* 
	*
	* Method name:Index
	* Description of the Method: se encarga de mostrar una lista de valoraciones de la base de datos
	* Calling arguments: Ninguno
	* Return value: List<Valoracion>
	* Required Files: Tabla valoraciones de MongoDB
	*
	*
	*/
	
	@GetMapping("")
	public
	List<Valoracion> index(){
		return valoracionRepository.findAll();
	}
	
	/*
	* 
	*
	* Method name: create
	* Description of the Method: se encarga de introducir en la base de datos un valoración
	* Calling arguments: Una valoracion
	* Return value: Un valoracion
	* Required Files: Tabla valoracioness de MongoDB
	*
	*
	*/
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public
	Valoracion create(@RequestBody Valoracion valoracion) {
		return valoracionRepository.save(valoracion);
		
	}
	


}
