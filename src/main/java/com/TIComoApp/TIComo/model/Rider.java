/*********************************************************************
 *
 * Class Name: Rider
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira para todo lo relativo a la creación de los riders del sistema TIComo
 *
 **********************************************************************
 */
package com.TIComoApp.TIComo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

//Para crear la coleccion en Mongo
import lombok.Data;

@Data
@Document(collection = "riders")
public class Rider extends Usuario{

	@NonNull
	private String NIF;
	@NonNull
	private String tipoVehiculo;
	private String matricula;
	private String carnet;
	@NonNull
	private double valoracionMedia;
	
	//Constructor
	public Rider(String id, String nombre, String apellidos, String email, String password, String NIF,
			String tipoVehiculo, String matricula, String carnet) {
		super(id, nombre, apellidos, email, password);
		this.NIF = NIF;
		this.tipoVehiculo = tipoVehiculo;
		this.matricula = matricula;
		this.carnet = carnet;
		this.valoracionMedia = 0.0;
	}
	//Getters, Setters y toString
	public String getNIF() {
		return NIF;
	}
	public void setNIF(String NIF) {
		this.NIF = NIF;
	}
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCarnet() {
		return carnet;
	}
	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
	public double getValoracionMedia() {
		return valoracionMedia;
	}
	public void setValoracionMedia(double valoracionMedia) {
		this.valoracionMedia = valoracionMedia;
	}
	@Override
	public String toString() {
		return "Rider [NIF=" + NIF + ", tipoVehiculo=" + tipoVehiculo + ", matricula=" + matricula + ", carnet="
				+ carnet + "]";
	}
	
	public boolean comprobarMatricula (String matricula){

	    if (matricula.toUpperCase().matches("^[0-9]{4}[A-Z]{3}$")) {
	        return true;

	    }else{

	        return false;
	    }      
	}
		
}