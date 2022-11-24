/*********************************************************************
 *
 * Class Name: EntregaController
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira de controlador para todas las funciones posibles de la clase entrega en la base de datos
 *
 **********************************************************************
 */


package com.TIComoApp.TIComo.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.TIComoApp.TIComo.model.Entrega;
import com.TIComoApp.TIComo.model.Pedido;
import com.TIComoApp.TIComo.model.Plato;
import com.TIComoApp.TIComo.repository.EntregaRepository;

@CrossOrigin
@RestController
@RequestMapping("ticomo/entregas")



public class EntregaController {	
	@Autowired
	private EntregaRepository entregaRepository;
		
	
	/*
	* 
	*
	* Method name:Index
	* Description of the Method: se encarga de mostrar una lista de entregas de la base de datos
	* Calling arguments: Ninguno
	* Return value: List<Entrega>
	* Required Files: Tabla entregas de MongoDB
	*
	*
	*/
	
	@GetMapping("")
	List<Entrega> index(){
		return entregaRepository.findAll();
	}
	
	/*
	* 
	*
	* Method name:obtenerEntregasCliente
	* Description of the Method: se encarga de mostrar una lista de las distintas entregas asignadas a un cliente de la base de datos
	* Calling arguments: Un id de cliente(para buscarle en la base de datos)
	* Return value: List<Entrega>
	* Required Files: Tabla entregas y de clientes de MongoDB
	*
	*
	*/
	@GetMapping("/{id}")
	public List<Entrega> obtenerEntregasCliente(@PathVariable String id) {
		List<Entrega> entregas = entregaRepository.findAll();
		List<Entrega> entregasCliente = new ArrayList<Entrega>();		
		for(int i=0;i<entregas.size();i++) {
			if(entregas.get(i).getIdCliente().equals(id)) {
				entregasCliente.add(entregas.get(i));
			}
		}
		return entregasCliente;
		
	}
	/*
	* 
	*
	* Method name: create
	* Description of the Method: se encarga de introducir en la base de datos una entrega
	* Calling arguments: Una entrega
	* Return value: Una entrega
	* Required Files: Tabla entregas de MongoDB
	*
	*
	*/
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public
	Entrega create(@RequestBody Entrega entrega) {
		return entregaRepository.save(entrega);
	}
	/*
	* 
	*
	* Method name: asignarRider
	* Description of the Method: se encarga de asignar un rider de la base de datos a una entrega en especifica de la base de datos
	* Calling arguments: Un id (Para buscar la entrega en la base de datos) y un idrider(Para buscar el rider en la base de datos)
	* Return value: Una entrega
	* Required Files: Tabla entregas y riders de MongoDB
	*
	*
	*/
	
	@PutMapping("/{id}")
	public
	Entrega asignarRider(@PathVariable String id, @RequestBody String idRider) {
		Entrega entregaFromDB = entregaRepository.findById(id).orElseThrow(RuntimeException::new);
		entregaFromDB.setIdRider(idRider);
		entregaFromDB.setEstado("reparto");
		
		return entregaRepository.save(entregaFromDB);
		
	}
	/*
	* 
	*
	* Method name: marcarEntrega
	* Description of the Method: se encarga de marcar una entrega en concreto como entregado en la base de datos
	* Calling arguments: Una entrega(Para buscarla en la base de datos)
	* Return value: Una entrega
	* Required Files: Tabla entregas de MongoDB
	*
	*
	*/
	
	@PutMapping("")
	public
	Entrega marcarEntregado(@RequestBody Entrega entrega) {
		Entrega entregaFromDB = entregaRepository.findById(entrega.getId()).orElseThrow(RuntimeException::new);
		entregaFromDB.setEntregado(true);
		entregaFromDB.setIdRider("");
		entregaFromDB.setEstado("entregado");
		return entregaRepository.save(entregaFromDB);
		
	}
	
	/*
	* 
	*
	* Method name: delete
	* Description of the Method: se encarga de eliminar una entrega en concreto en la base de datos
	* Calling arguments: Un id (Para buscar la entrega en la base de datos)
	* Return value: void
	* Required Files: Tabla entregas de MongoDB
	*
	*
	*/
		
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		Entrega entrega = entregaRepository.findById(id).orElseThrow(RuntimeException::new);
		entregaRepository.delete(entrega);

	}
	

}