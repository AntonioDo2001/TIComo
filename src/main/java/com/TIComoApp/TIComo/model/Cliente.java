/*********************************************************************
 *
 * Class Name: Cliente
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira para todo lo relativo a la creación de los clientes del sistema TIComo
 *
 **********************************************************************
 */

package com.TIComoApp.TIComo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

//Para crear la coleccion en Mongo
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
	
	//Constructor
	public Cliente(String id, String nombre, String apellidos, String email, String password, String NIF,
			String direccionCompleta, String telefono) {
		super(id, nombre, apellidos, email, password);
		this.NIF = NIF;
		this.direccionCompleta = direccionCompleta;
		this.telefono = telefono;
	}
	
	public Cliente() {
		
	}
	
	//Getters, Setters y toString
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
	
	public boolean telefonoValido(String telefono) {
		if(telefono.length() == 9) {
			return true;
		}
		else {
			return false;
		}
	}

	

	
	

}