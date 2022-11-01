package com.TIComoApp.TIComo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

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
	public Rider(String id, String nombre, String apellidos, String email, String password, String NIF,
			String tipoVehiculo, String matricula, String carnet) {
		super(id, nombre, apellidos, email, password);
		this.NIF = NIF;
		this.tipoVehiculo = tipoVehiculo;
		this.matricula = matricula;
		this.carnet = carnet;
	}
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
	@Override
	public String toString() {
		return "Rider [NIF=" + NIF + ", tipoVehiculo=" + tipoVehiculo + ", matricula=" + matricula + ", carnet="
				+ carnet + "]";
	}
		
}
