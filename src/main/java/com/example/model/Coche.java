package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(value = "Coches")
public class Coche {
	@Id
	private String idCoche;
	
	@NonNull
	private String modelo;
	
	private String usuario;
	
	

	public Coche(String idCoche, String modelo, String usuario) {
		this.idCoche = idCoche;
		this.modelo = modelo;
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getIdCoche() {
		return idCoche;
	}

	public void setIdCoche(String idCoche) {
		this.idCoche = idCoche;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Coche [idCoche=" + idCoche + ", modelo=" + modelo + ", usuario=" + usuario + "]";
	}

	
	
	
}
