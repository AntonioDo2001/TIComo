package com.TIComoApp.TIComo.model;




import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.data.annotation.Id;

import com.mongodb.lang.NonNull;

import lombok.Data;


@Data
public class Usuario {
	@Id
	private String id;
	@NonNull
	private String nombre;
	@NonNull
	private String apellidos;
	@NonNull
	private String email;
	@NonNull
	private String password;




	public Usuario(String id, String nombre, String apellidos, String email, String password) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;

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




	public String getApellidos() {
		return apellidos;
	}




	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return super.toString();
	}

	public boolean contraseniaSegura(String password) {
		boolean segura = false;
		char clave;
		int  contNumero = 0, contLetraMay = 0, contLetraMin=0;
		for (int i = 0; i < password.length(); i++) {
			clave = password.charAt(i);
			String passValue = String.valueOf(clave);
			if (passValue.matches("[A-Z]")) {
				contLetraMay++;
			} else if (passValue.matches("[a-z]")) {
				contLetraMin++;
			} else if (passValue.matches("[0-9]")) {
				contNumero++;
			}
		}
		if(contLetraMay>0 && contLetraMin>0 && contNumero>0 && password.length()>=8) {
			segura = true;
		}
		return segura;


	}
	
	
	
	public boolean formatoCorreoCorrecto(String email) {
		// Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        // El email a validar
 
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
    
    }
    

	
	
	
	
}