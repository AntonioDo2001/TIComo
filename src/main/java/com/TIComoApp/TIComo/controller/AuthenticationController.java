/*********************************************************************
 *
 * Class Name: AuthenticationController
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira de controlador para las funciones de resgistrarse el cliente y loguearse el administrador, el cliente y el rider en la base de datos
 *
 **********************************************************************
 */


package com.TIComoApp.TIComo.controller;

import java.util.List;

import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.TIComoApp.TIComo.model.Administrador;
import com.TIComoApp.TIComo.model.Cliente;
import com.TIComoApp.TIComo.model.Rider;
import com.TIComoApp.TIComo.repository.ClienteRepository;
import com.TIComoApp.TIComo.repository.AdministradorRepository;
import com.TIComoApp.TIComo.repository.RiderRepository;

@CrossOrigin
@RestController
@RequestMapping("ticomo/authentication")
public class AuthenticationController {
	static final  String ERRPWD= "errorPassword";
	static final  String ERREMAIL= "emailRepetido";


	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private AdministradorRepository adminRepository;
	
	@Autowired
	private RiderRepository riderRepository;

	/*
	* 
	*
	* Method name:create
	* Description of the Method: se encarga de realizar el registro del cliente en la base de datos
	* Calling arguments: un cliente(Es el que queremos introducir en la base de datos)
	* Return value: un cliente
	* Required Files: Tabla clientes de MongoDB
	*
	*
	*/
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/register")
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
			}else {
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
	* Method name:loginUser
	* Description of the Method: se encarga de comprobar si el email y la contraseña introducidos pertenece a un administrador, un cliente o un rider de la base de datos
	* Calling arguments: dos strings, el email y la contraseña (Son el email y la contraseña que queremos comprobar en la base de datos)
	* Return value: un JsonObject
	* Required Files: Tabla clientes, administradores y riders de MongoDB
	*
	*
	*/
	@GetMapping("/login/{email}/{password}")
	public
	JsonObject loginUser(@PathVariable String email, @PathVariable String password) {
		boolean esClienteLogin = false;
		boolean esRiderLogin = false;
		boolean esAdminLogin = false;
		
		Cliente clienteEncontrado = null;
		Administrador adminEncontrado = null;
		Rider riderEncontrado = null;
		
		
		List<Cliente> listaClientes = clienteRepository.findAll();
		List<Administrador> listaAdmin = adminRepository.findAll();
		List<Rider> listaRider = riderRepository.findAll();
		
		for(int i=0; i<listaClientes.size();i++) {
			if(listaClientes.get(i).getEmail().equalsIgnoreCase(email)) {
				esClienteLogin = true;
				clienteEncontrado = listaClientes.get(i);
			}
		}
		
		for(int j=0; j<listaAdmin.size();j++) {
			if(listaAdmin.get(j).getEmail().equalsIgnoreCase(email)) {
				esAdminLogin = true;
				adminEncontrado = listaAdmin.get(j);
			}
		}
		
		for(int k=0; k<listaRider.size();k++) {
			if(listaRider.get(k).getEmail().equalsIgnoreCase(email)) {
				esRiderLogin = true;
				riderEncontrado = listaRider.get(k);
			}
		}
		
		if(esClienteLogin) {
			if(BCrypt.checkpw(password, clienteEncontrado.getPassword())) {
				return new JsonObject("{\"respuesta\":\"clienteLogin\",\"idCliente\":\""+clienteEncontrado.getId()+"\"}");
			}
			else {
				return new JsonObject("{\"respuesta\":\"Email o Password incorrectos\"}");
			}
			
		}
		else if(esAdminLogin) {
			if(BCrypt.checkpw(password, adminEncontrado.getPassword())) {
				return new JsonObject("{\"respuesta\":\"adminLogin\"");
			}
			else {
				return new JsonObject("{\"respuesta\":\"Email o Password  incorrecto\"}");
			}
			
		}
		else if(esRiderLogin) {
			if(BCrypt.checkpw(password, riderEncontrado.getPassword())) {
				return new JsonObject("{\"respuesta\":\"riderLogin\"}");
			}
			else {
				return new JsonObject("{\"respuesta\":\"Email o Password incorrecto\"}");
				
				
				
			}
			
		}
		else {
			return new JsonObject("{\"respuesta\":\"Email o Password incorrecto\"}");
		}


	}
}