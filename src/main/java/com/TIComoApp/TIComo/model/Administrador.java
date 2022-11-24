/*********************************************************************
 *
 * Class Name: Administrador
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira para todo lo relativo a la creación de los administradores del sistema TIComo
 *
 **********************************************************************
 */


package com.TIComoApp.TIComo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

//Para crear la coleccion en Mongo
import lombok.Data;

@Data
@Document(collection = "admins")
public class Administrador extends Usuario{
	
	@NonNull
	private String zona;
	
	//Constructor
	public Administrador(String id, String nombre, String apellidos, String email, String password, String zona) {
		super(id, nombre, apellidos, email, password);
		this.zona = zona;
	}
	//Getters, Setters y toString
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
