package com.TIComoApp.TIComo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document(collection = "admins")
public class Administrador extends Usuario{
	
	@NonNull
	private String zona;

	public Administrador(String id, String nombre, String apellidos, String email, String password, String zona) {
		super(id, nombre, apellidos, email, password);
		this.zona = zona;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	@Override
	public String toString() {
		return "Admin [zona=" + zona + "]";
	}
	
	

}
