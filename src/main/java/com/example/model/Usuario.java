package com.example.model;




import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//esta anotación es específica de mongoDB y decimos que esta clase se mapea a esa coleccion Usuarios
@Document(value = "Usuarios")
public class Usuario {
	@Id
	private String id;
	
	private String nombre;
	
	private String edad;

	
	

	public Usuario(String id, String nombre, String edad) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		
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

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

	
	
	
	
}