/*********************************************************************
 *
 * Class Name: ClienteController
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira de controlador para todas las funciones posibles de la clase cliente en la base de datos
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
import com.TIComoApp.TIComo.repository.ClienteRepository;

@CrossOrigin
@RestController
@RequestMapping("ticomo/clientes")



public class ClienteController {
	static final  String ERRPWD= "errorPassword";
	static final  String EMFORMERR= "emailFormato";
	static final  String ERRORTLF= "tlfFormErr";
	static final  String ERREMAIL= "emailRepetido";
	
	@Autowired
	private ClienteRepository clienteRepository;
		
	
	/*
	* 
	*
	* Method name:Index
	* Description of the Method: se encarga de mostrar una lista de clientes de la base de datos
	* Calling arguments: Ninguno
	* Return value: List<Cliente>
	* Required Files: Tabla clientes de MongoDB
	*
	*
	*/
	
	@GetMapping("")
	public
	List<Cliente> index(){
		return clienteRepository.findAll();
	}
	
	/*
	* 
	*
	* Method name: obtenerCliente
	* Description of the Method: se encarga de obtener un cliente en concreto de la base de datos
	* Calling arguments: Un id de cliente(para buscarle en la base de datos)
	* Return value: Optional<Cliente>
	* Required Files: Tabla clientes de MongoDB
	*
	*
	*/
	@GetMapping("/{id}")
	public
	Optional<Cliente> obtenerCliente(@PathVariable String id) {
		return clienteRepository.findById(id);
		
	}
	
	/*
	* 
	*
	* Method name: create
	* Description of the Method: se encarga de comprobar si el cliente que se está intentando crear en la base de datos sigue los criterios establecidos
	* Calling arguments: Un cliente
	* Return value: Un cliente
	* Required Files: Tabla clientes de MongoDB
	*
	*
	*/
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public
	Cliente create(@RequestBody Cliente cliente) {
		if(cliente.contraseniaSegura(cliente.getPassword())) {
			String passwordCliente = cliente.getPassword();
			cliente.setPassword(BCrypt.hashpw(passwordCliente, BCrypt.gensalt()));
			List<Cliente> listaClientes = clienteRepository.findAll();
			boolean emailRepetido = false;
			for(int i=0;i<listaClientes.size();i++) {
				if(listaClientes.get(i).getEmail().equalsIgnoreCase(cliente.getEmail())) {
					emailRepetido = true;
				}
			}
			if(emailRepetido) {
				return new Cliente(ERREMAIL,ERREMAIL,ERREMAIL,ERREMAIL,ERREMAIL,ERREMAIL,ERREMAIL,ERREMAIL);
			}
			
			else if(!cliente.formatoCorreoCorrecto(cliente.getEmail())){
				return new Cliente(EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR);	
			}
			else if(!cliente.telefonoValido(cliente.getTelefono())) {
				return new Cliente(ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF); 
			}
			else {
				return clienteRepository.save(cliente);
			}
		}
		else {
			return new Cliente(ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD);
		}
		
		
		
	}
	/*
	* 
	*
	* Method name: update
	* Description of the Method: se encarga de actualizar un cliente en concreto en la base de datos
	* Calling arguments: Un id (Para buscar el cliente en la base de datos) y un cliente(Los datos nuevos del cliente)
	* Return value: Un cliente
	* Required Files: Tabla clientes de MongoDB
	*
	*
	*/
	
	@PutMapping("/{id}")
	public
	Cliente update(@PathVariable String id, @RequestBody Cliente cliente) {
		if(cliente.contraseniaSegura(cliente.getPassword())) {
			Cliente clienteFromDB = clienteRepository.findById(id).orElseThrow(RuntimeException::new);
			
			
			clienteFromDB.setNombre(cliente.getNombre());
			clienteFromDB.setApellidos(cliente.getApellidos());
			clienteFromDB.setNIF(cliente.getNIF());
			clienteFromDB.setDireccionCompleta(cliente.getDireccionCompleta());
			clienteFromDB.setTelefono(cliente.getTelefono());
			clienteFromDB.setEmail(cliente.getEmail());
			clienteFromDB.setPassword(BCrypt.hashpw(cliente.getPassword(), BCrypt.gensalt()));
			
			List<Cliente> listaClientes = clienteRepository.findAll();
			boolean emailRepetido = false;
			for(int i=0;i<listaClientes.size();i++) {
				if(listaClientes.get(i).getEmail().equalsIgnoreCase(cliente.getEmail())) {
					emailRepetido = true;
				}
			}
			
			if(!cliente.formatoCorreoCorrecto(cliente.getEmail())){
				return new Cliente(EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR,EMFORMERR);	
			}
			else if(!cliente.telefonoValido(cliente.getTelefono())) {
				return new Cliente(ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF,ERRORTLF); 
			}
			else {
				return clienteRepository.save(clienteFromDB);
			}
		}
		else {
			return new Cliente(ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD);
		}
		
		
	}
	/*
	* 
	*
	* Method name: desactivarActivarCliente
	* Description of the Method: se encarga de activar/desactivar un cliente en concreto en la base de datos
	* Calling arguments: Un cliente (Para buscar el cliente en la base de datos)
	* Return value: Un cliente
	* Required Files: Tabla clientes de MongoDB
	*
	*
	*/
	@PutMapping("")
	public
	Cliente desactivarActivarCliente(@RequestBody Cliente cliente) {
		Cliente clienteFromDB = clienteRepository.findById(cliente.getId()).orElseThrow(RuntimeException::new);
		clienteFromDB.setCuentaActiva(cliente.isCuentaActiva());
		return clienteRepository.save(clienteFromDB);
	}
	/*
	* 
	*
	* Method name: delete
	* Description of the Method: se encarga de eliminar un cliente en concreto en la base de datos
	* Calling arguments: Un id (Para buscar el cliente en la base de datos)
	* Return value: void
	* Required Files: Tabla clientes de MongoDB
	*
	*
	*/
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public
	void delete(@PathVariable String id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(RuntimeException::new);
		clienteRepository.delete(cliente);

	}
	
	

}
