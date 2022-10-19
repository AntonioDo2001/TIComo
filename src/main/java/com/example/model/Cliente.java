package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(value = "Clientes")
public class Cliente {
	@Id
	private String idCliente;
	
	@NonNull
	private String Nombre;
	
	@NonNull
	private String Apellido;
	
	@NonNull
	private String NIF;
	
	@NonNull 
	private String Direccion;
	
	@NonNull 
	private String Telefono;
	
	@NonNull
	private String Email;
	
	@NonNull
	private String Password;

	public Cliente(String nombre, String apellido, String nIF, String direccion, String telefono, String email,
			String password) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		NIF = nIF;
		Direccion = direccion;
		Telefono = telefono;
		Email = email;
		Password = password;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
	
	

}
