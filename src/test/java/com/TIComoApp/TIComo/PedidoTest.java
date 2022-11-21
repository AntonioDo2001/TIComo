package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.TIComoApp.TIComo.model.Pedido;

public class PedidoTest {
	@Test
	void testPedido() {
		Pedido ejemplo=new Pedido("123", "Atascaburras", 5, 2, "","");
		Pedido ejemplo2=new Pedido("123", "Atascaburras", 5, 2, "","");
		ejemplo.setId("2");
		ejemplo2.setId("2");
		ejemplo.setNombrePlato("Cocido");
		ejemplo2.setNombrePlato("Cocido");
		ejemplo.setPrecioPlato(10);
		ejemplo2.setPrecioPlato(10);
		ejemplo.setCantidadPlato(10);
		ejemplo2.setCantidadPlato(10);
		ejemplo.setIdCliente("23");
		ejemplo2.setIdCliente("23");
		ejemplo.setPrecioTotal(20);
		ejemplo2.setPrecioTotal(20);
		ejemplo.setPedidoRealizado(false);
		ejemplo2.setPedidoRealizado(false);
		ejemplo.setNombreRestaurante("casaudillo");
		ejemplo2.setNombreRestaurante("casadauillo");
		
		
		assertEquals(ejemplo.getId(),ejemplo2.getId());
		assertEquals(ejemplo.getNombrePlato(), ejemplo2.getNombrePlato());
		assertEquals(ejemplo.getPrecioPlato(),ejemplo2.getPrecioPlato());
		assertEquals(ejemplo.getCantidadPlato(), ejemplo2.getCantidadPlato());
		assertEquals(ejemplo.isPedidoRealizado(), ejemplo2.isPedidoRealizado());
		assertEquals(ejemplo.getPrecioTotal(),ejemplo2.getPrecioTotal());
		assertEquals(ejemplo.getIdCliente(), ejemplo2.getIdCliente());
		assertEquals(ejemplo.toString(), ejemplo2.toString());
		assertEquals(ejemplo.getNombreRestaurante(), ejemplo2.getNombreRestaurante());
		
		
	}
}