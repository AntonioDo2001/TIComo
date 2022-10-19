package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(value = "Restaurantes")
public class Restaurante {
	@Id
	private String idRestaurante;
	
	@NonNull
	private String RazonSocial;
	
	@NonNull
	private String CIF;
	
	@NonNull
	private String Direccion;
	
	@NonNull 
	private String Telefono;
	
	@NonNull 
	private String Email;
	
	@NonNull 
	private String Categoria;

	public Restaurante(String razonSocial, String cIF, String direccion, String telefono, String email,
			String categoria) {
		super();
		RazonSocial = razonSocial;
		CIF = cIF;
		Direccion = direccion;
		Telefono = telefono;
		Email = email;
		Categoria = categoria;
	}

	public String getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(String idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public String getRazonSocial() {
		return RazonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		RazonSocial = razonSocial;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
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

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	
	
}
