package com.TIComoApp.TIComo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document(collection = "entregas")
public class Entrega {
	@Id
	private String id;
	@NonNull
	private String idRider;
	@NonNull
	private String idCliente;
	@NonNull
	private String nombreCliente;
	@NonNull
	private String apellidosCliente;
	@NonNull
	private String direccion;
	@NonNull
	private String telefonoCliente;
	@NonNull
	private String fechayhora;
	@NonNull
	private String pedidosRealizados;
	@NonNull
	private String estado;
	@NonNull
	private boolean entregado;
	@NonNull
	private double precioTotal;
	@NonNull
	private String nombreRestaurante;
	
	public Entrega(String id, String idCliente,String nombreCliente, String apellidosCliente, String direccion, String telefonoCliente, String pedidosRealizados, double precioTotal, String nombreRestaurante) {
		super();
		this.id = id;
		this.idRider = "";
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidosCliente = apellidosCliente;
		this.direccion = direccion;
		this.telefonoCliente = telefonoCliente;
		this.pedidosRealizados = pedidosRealizados;
		this.estado = "listo";
		this.entregado = false;
		this.precioTotal = precioTotal;
		this.nombreRestaurante = nombreRestaurante;
		DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss z");
		this.fechayhora = dateFormat.format(new Date());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdRider() {
		return idRider;
	}

	public void setIdRider(String idRider) {
		this.idRider = idRider;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidosCliente() {
		return apellidosCliente;
	}

	public void setApellidosCliente(String apellidosCliente) {
		this.apellidosCliente = apellidosCliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFechayhora() {
		return fechayhora;
	}

	public String getPedidosRealizados() {
		return pedidosRealizados;
	}
	public void setPedidosRealizados(String pedidosRealizados) {
		this.pedidosRealizados = pedidosRealizados;
	}
	public String getTelefonoCliente() {
		return telefonoCliente;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setFechayhora(String fechayhora) {
		this.fechayhora = fechayhora;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	public String getNombreRestaurante() {
		return nombreRestaurante;
	}
	public void setNombreRestaurante(String nombreRestaurante) {
		this.nombreRestaurante = nombreRestaurante;
	}
	@Override
	public String toString() {
		return "Entrega [id=" + id + ", idRider=" + idRider + ", nombreCliente=" + nombreCliente + ", apellidosCliente="
				+ apellidosCliente + ", direccion=" + direccion + ", entregado=" + entregado + "]";
	}
	
	

	
}
