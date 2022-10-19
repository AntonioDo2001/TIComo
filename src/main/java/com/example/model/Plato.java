package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(value = "Platos")
public class Plato {
	@Id
	private String idPlato;
	
	@NonNull
	private String Nombre;/*Preguntar si esto va a ser el id del plato*/
	
	@NonNull
	private String Foto;/*Preguntar como ponerlo*/
	
	@NonNull
	private String Descripcion;
	
	@NonNull 
	private Double Precio;
	
	@NonNull 
	private Boolean AptoVeganos;
	
	@NonNull
	private String idRestaurante;

	public Plato(String nombre, String foto, String descripcion, Double precio, Boolean aptoVeganos,
			String idRestaurante) {
		super();
		Nombre = nombre;
		Foto = foto;
		Descripcion = descripcion;
		Precio = precio;
		AptoVeganos = aptoVeganos;
		this.idRestaurante = idRestaurante;
	}

	public String getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(String idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getFoto() {
		return Foto;
	}

	public void setFoto(String foto) {
		Foto = foto;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Double getPrecio() {
		return Precio;
	}

	public void setPrecio(Double precio) {
		Precio = precio;
	}

	public Boolean getAptoVeganos() {
		return AptoVeganos;
	}

	public void setAptoVeganos(Boolean aptoVeganos) {
		AptoVeganos = aptoVeganos;
	}

	public String getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(String idRestaurante) {
		this.idRestaurante = idRestaurante;
	}
	
	
	
	
}
