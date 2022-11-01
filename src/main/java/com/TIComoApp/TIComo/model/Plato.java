package com.TIComoApp.TIComo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document(collection = "platos")
public class Plato {

	@Id
	private String id;
	@NonNull
	private String nombre;
	@NonNull
	private String foto;
	@NonNull
	private String descripcion;
	@NonNull
	private double precio;
	@NonNull
	private boolean aptoVeganos;
	@NonNull
	private String idRestaurante;
	
	public Plato(String id, String nombre, String foto, String descripcion, double precio, boolean aptoVeganos,
			String idRestaurante) {
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.aptoVeganos = aptoVeganos;
		this.idRestaurante = idRestaurante;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isAptoVeganos() {
		return aptoVeganos;
	}

	public void setAptoVeganos(boolean aptoVeganos) {
		this.aptoVeganos = aptoVeganos;
	}

	public String getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(String idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	@Override
	public String toString() {
		return "Plato [id=" + id + ", nombre=" + nombre + ", foto=" + foto + ", descripcio=" + descripcion + ", precio="
				+ precio + ", aptoVeganos=" + aptoVeganos + ", idRestaurante=" + idRestaurante + "]";
	}

	
	
}
