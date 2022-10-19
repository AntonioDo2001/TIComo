package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(value = "Riders")
public class Rider {
	@Id
	private String idRider;
	
	@NonNull
	private String Nombre;
	
	@NonNull
	private String Apellido;
	
	@NonNull
	private String NIF;
	
	@NonNull 
	private String TipoVehiculo;
	
	
	private String Matricula;
	
	
	private String Carnet;
	
	@NonNull
	private String Email;
	
	@NonNull
	private String Password;

	public Rider(String nombre, String apellido, String nIF, String tipoVehiculo, String matricula, String carnet,
			String email, String password) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		NIF = nIF;
		TipoVehiculo = tipoVehiculo;
		Matricula = matricula;
		Carnet = carnet;
		Email = email;
		Password = password;
	}

	public String getIdRider() {
		return idRider;
	}

	public void setIdRider(String idRider) {
		this.idRider = idRider;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public String getTipoVehiculo() {
		return TipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		TipoVehiculo = tipoVehiculo;
	}

	public String getMatricula() {
		return Matricula;
	}

	public void setMatricula(String matricula) {
		Matricula = matricula;
	}

	public String getCarnet() {
		return Carnet;
	}

	public void setCarnet(String carnet) {
		Carnet = carnet;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	
	


}
