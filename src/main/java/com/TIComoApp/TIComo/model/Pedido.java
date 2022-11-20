package com.TIComoApp.TIComo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document(collection = "pedidos")

public class Pedido {
	@Id
	private String id;
	@NonNull
	private String nombrePlato;
	@NonNull
	private int precioPlato;
	@NonNull
	private int cantidadPlato;
	@NonNull
	private int precioTotal;
	@NonNull
	private boolean pedidoRealizado;
	@NonNull
	private String idCliente;
	@NonNull
	private String idEntrega;
	@NonNull
	private String nombreRestaurante;
	
	
	public Pedido(String id, String nombrePlato, int precioPlato, int cantidadPlato, String idCliente, String nombreRestaurante) {
		super();
		this.id = id;
		this.nombrePlato = nombrePlato;
		this.precioPlato = precioPlato;
		this.cantidadPlato = cantidadPlato;
		this.precioTotal = calcularPrecioTotal();
		this.pedidoRealizado = false;
		this.idCliente = idCliente;
		this.idEntrega = "";
		this.nombreRestaurante = nombreRestaurante;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombrePlato() {
		return nombrePlato;
	}

	public void setNombrePlato(String nombrePlato) {
		this.nombrePlato = nombrePlato;
	}

	public int getPrecioPlato() {
		return precioPlato;
	}

	public void setPrecioPlato(int precioPlato) {
		this.precioPlato = precioPlato;
	}

	public int getCantidadPlato() {
		return cantidadPlato;
	}

	public void setCantidadPlato(int cantidadPlato) {
		this.cantidadPlato = cantidadPlato;
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}

	public boolean isPedidoRealizado() {
		return pedidoRealizado;
	}

	public void setPedidoRealizado(boolean pedidoRealizado) {
		this.pedidoRealizado = pedidoRealizado;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public void setIdEntrega(String idEntrega) {
		this.idEntrega = idEntrega;
	}
	public String getIdEntrega() {
		return idEntrega;
	}
	public String getNombreRestaurante() {
		return nombreRestaurante;
	}
	public void setNombreRestaurante(String nombreRestaurante) {
		this.nombreRestaurante = nombreRestaurante;
	}
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", nombrePlato=" + nombrePlato + ", precioPlato=" + precioPlato + ", cantidadPlato="
				+ cantidadPlato + ", precioTotal=" + precioTotal + ", pedidoRealizado=" + pedidoRealizado
				+ ", idCliente=" + idCliente + "]";
	}
	
	public int calcularPrecioTotal() {
		return this.precioPlato * this.cantidadPlato;
	}

}
