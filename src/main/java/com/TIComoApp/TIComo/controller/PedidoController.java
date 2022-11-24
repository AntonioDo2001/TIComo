/*********************************************************************
 *
 * Class Name: EntregaController
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira de controlador para todas las funciones posibles de la clase pedido en la base de datos
 *
 **********************************************************************
 */
package com.TIComoApp.TIComo.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.TIComoApp.TIComo.model.Entrega;
import com.TIComoApp.TIComo.model.Pedido;
import com.TIComoApp.TIComo.repository.PedidoRepository;

@CrossOrigin
@RestController
@RequestMapping("ticomo/pedidos")



public class PedidoController {	
	@Autowired
	private PedidoRepository pedidoRepository;
		
	
	
	/*
	* 
	*
	* Method name:obtenerPedidos
	* Description of the Method: se encarga de mostrar una lista de los distintos pedidos asignados a un cliente de la base de datos
	* Calling arguments: Un id de cliente(para buscarle en la base de datos)
	* Return value: List<Pedido>
	* Required Files: Tabla pedidos y de clientes de MongoDB
	*
	*/
	
	@GetMapping("/{id}")
	public
	List<Pedido> obtenerPedidos(@PathVariable String id) {
		List<Pedido> pedidos = pedidoRepository.findAll();
		List<Pedido> pedidosCliente = new ArrayList<Pedido>();		
		for(int i=0;i<pedidos.size();i++) {
			if(pedidos.get(i).getIdCliente().equals(id)) {
				pedidosCliente.add(pedidos.get(i));
			}
		}
		return pedidosCliente;
		
	}
	
	/*
	* 
	*
	* Method name: create
	* Description of the Method: se encarga de introducir en la base de datos un pedido
	* Calling arguments: Una pedido
	* Return value: Una pedido
	* Required Files: Tabla pedidos de MongoDB
	*
	*
	*/
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public
	Pedido create(@RequestBody Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	/*
	* 
	*
	* Method name: pedidoRealizado
	* Description of the Method: se se encarga de marcar un pedido en concreto como realizado, asigandolo a una entrega en concreto en la base de datos
	* Calling arguments: Un id (Para buscar el pedido en la base de datos) y una entrega (Para buscar la entrega en la base de datos)
	* Return value: Un pedido
	* Required Files: Tabla entregas y pedidos de MongoDB
	*
	*
	*/
	
	@PutMapping("/{id}")
	public
	Pedido pedidoRealizado(@PathVariable String id,@RequestBody Entrega entrega) {
			Pedido pedidoFromDB = pedidoRepository.findById(id).orElseThrow(RuntimeException::new);		
			pedidoFromDB.setPedidoRealizado(true);	
			pedidoFromDB.setIdEntrega(entrega.getId());
			return pedidoRepository.save(pedidoFromDB);
	}
	
	
	/*
	* 
	*
	* Method name: delete
	* Description of the Method: se encarga de eliminar un pedido en concreto en la base de datos
	* Calling arguments: Un id (Para buscar el pedido en la base de datos)
	* Return value: void
	* Required Files: Tabla pedidos de MongoDB
	*
	*
	*/
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public
	void delete(@PathVariable String id) {
		Pedido pedido = pedidoRepository.findById(id).orElseThrow(RuntimeException::new);
		pedidoRepository.delete(pedido);

	}
	

}