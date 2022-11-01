package com.TIComoApp.TIComo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document(collection = "clientes")
public class Cliente extends Usuario{
	
	@NonNull
	private String NIF;
	@NonNull
	private String direccionCompleta;
	@NonNull
	private String telefono;
	
	public Cliente(String id, String nombre, String apellidos, String email, String password, String NIF,
			String direccionCompleta, String telefono) {
		super(id, nombre, apellidos, email, password);
		this.NIF = NIF;
		this.direccionCompleta = direccionCompleta;
		this.telefono = telefono;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public String getDireccionCompleta() {
		return direccionCompleta;
	}

	public void setDireccionCompleta(String direccionCompleta) {
		this.direccionCompleta = direccionCompleta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [NIF=" + NIF + ", direccionCompleta=" + direccionCompleta + ", telefono=" + telefono + "]";
	}

	

	
	

}
