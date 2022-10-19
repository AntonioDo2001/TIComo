package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(value = "Administradores")
public class Administrador {
	@Id
	private String idAdministrador;
	
	@NonNull
	private String Nombre;
	
	@NonNull
	private String Apellido;
	
	@NonNull
	private String Zona;
	
	@NonNull 
	private String Email;
	
	@NonNull 
	private String Password;

	public Administrador(String nombre, String apellido, String zona, String email, String password) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		Zona = zona;
		Email = email;
		Password = password;
	}

	public String getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(String idAdministrador) {
		this.idAdministrador = idAdministrador;
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

	public String getZona() {
		return Zona;
	}

	public void setZona(String zona) {
		Zona = zona;
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
