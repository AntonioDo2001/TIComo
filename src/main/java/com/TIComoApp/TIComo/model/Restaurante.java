/*********************************************************************
 *
 * Class Name: Plato
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira para todo lo relativo a la creación de los restaurantes del sistema TIComo
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
@Document(collection = "restaurantes")
public class Restaurante {

	@Id
	private String id;
	@NonNull
	private String nombre;
	@NonNull
	private String razonSocial;
	@NonNull
	private String CIF;
	@NonNull
	private String direccionCompleta;
	@NonNull
	private String telefono;
	@NonNull
	private String email;
	@NonNull
	private String categoria;
	
	//Constructor
	public Restaurante(String id, String nombre, String razonSocial, String CIF, String direccionCompleta,
			String telefono, String email, String categoria) {
		this.id = id;
		this.nombre = nombre;
		this.razonSocial = razonSocial;
		this.CIF = CIF;
		this.direccionCompleta = direccionCompleta;
		this.telefono = telefono;
		this.email = email;
		this.categoria = categoria;
	}

	//Getters, Setters y toString
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

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String CIF) {
		this.CIF = CIF;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Restaurante [id=" + id + ", nombre=" + nombre + ", razonSocial=" + razonSocial + ", CIF=" + CIF
				+ ", direccionCompleta=" + direccionCompleta + ", telefono=" + telefono + ", email=" + email
				+ ", categoria=" + categoria + "]";
	}
	
	
	
}
