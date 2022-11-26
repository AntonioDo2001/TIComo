/*********************************************************************
 *
 * Class Name: Valoraciones
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira para todo lo relativo a la creación de la clase de las valoraciones de los riders y los restaurantes
 *
 **********************************************************************
 */

package com.TIComoApp.TIComo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

//Para crear la coleccion en Mongo
import lombok.Data;

@Data
@Document(collection = "valoraciones")
public class Valoracion {
	@Id
	private String id;
	@NonNull
	private String idEntrega;
	@NonNull
	private String esRiderORestaurante;
	@NonNull
	private int valoracion;
	@NonNull
	private String comentario;
	@NonNull
	private String idRiderOnombreRestaurante;

	
	//Constructor
	public Valoracion(String id, String esRiderORestaurante, int valoracion, String comentario,String idRiderOnombreRestaurante) {
		super();
		this.id = id;
		this.esRiderORestaurante = esRiderORestaurante;
		this.valoracion = valoracion;
		this.comentario = comentario;
		this.idRiderOnombreRestaurante = idRiderOnombreRestaurante;
	}
	public Valoracion() {
		
	}

	//Getters, Setters y toString
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
	public String getIdRiderOnombreRestaurante() {
		return idRiderOnombreRestaurante;
	}
	public void setIdRiderOnombreRestaurante(String idRiderOnombreRestaurante) {
		this.idRiderOnombreRestaurante = idRiderOnombreRestaurante;
	}
	public String getIdEntrega() {
		return idEntrega;
	}
	public void setIdEntrega(String idEntrega) {
		this.idEntrega = idEntrega;
	}

	@Override
	public String toString() {
		return "Valoracion [id=" + id + ", esRiderORestaurante=" + esRiderORestaurante + ", valoracion=" + valoracion + ", comentario=" + comentario + "]";
	}
	

	

}