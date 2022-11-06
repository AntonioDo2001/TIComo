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
		
	
	
	
	@GetMapping("")
	List<Cliente> index(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	Optional<Cliente> obtenerCliente(@PathVariable String id) {
		return clienteRepository.findById(id);
		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
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
	
	@PutMapping("/{id}")
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
				return clienteRepository.save(clienteFromDB);
			}
		}
		else {
			return new Cliente(ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD,ERRPWD);
		}
		
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	void delete(@PathVariable String id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(RuntimeException::new);
		clienteRepository.delete(cliente);

	}
	
	

}
