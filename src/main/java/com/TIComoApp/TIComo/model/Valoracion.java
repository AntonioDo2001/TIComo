package com.TIComoApp.TIComo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document(collection = "valoraciones")
public class Valoracion {
	@Id
	private String id;
	@NonNull
	private String esRiderORestaurante;
	@NonNull
	private String nombre;
	@NonNull
	private int valoracion;
	@NonNull
	private String comentario;
	
	public Valoracion(String id, String esRiderORestaurante, String nombre, int valoracion, String comentario) {
		super();
		this.id = id;
		this.esRiderORestaurante = esRiderORestaurante;
		this.nombre = nombre;
		this.valoracion = valoracion;
		this.comentario = comentario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEsRiderORestaurante() {
		return esRiderORestaurante;
	}

	public void setEsRiderORestaurante(String esRiderORestaurante) {
		this.esRiderORestaurante = esRiderORestaurante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Valoracion [id=" + id + ", esRiderORestaurante=" + esRiderORestaurante + ", nombre=" + nombre
				+ ", valoracion=" + valoracion + ", comentario=" + comentario + "]";
	}
	

	

}
