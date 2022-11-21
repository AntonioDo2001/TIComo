package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.TIComoApp.TIComo.model.Entrega;

public class EntregaTest {

	@Test
	void testEntrega() {
		Entrega ejemplo=new Entrega("12","12","12","12","12","12","",0.0,"");
		Entrega ejemplo2=new Entrega("12","12","12","12","12","12","",0.0,"");
		ejemplo.setId("2");
		ejemplo2.setId("2");
		ejemplo.setIdRider("2");
		ejemplo2.setIdRider("2");
		ejemplo.setNombreCliente("Corro");
		ejemplo2.setNombreCliente("Corro");
		ejemplo.setApellidosCliente("Wilfred");
		ejemplo2.setApellidosCliente("Wilfred");
		ejemplo.setDireccion("dx");
		ejemplo2.setDireccion("dx");
		ejemplo.setEntregado(true);
		ejemplo2.setEntregado(true);
		ejemplo.setIdCliente("eee");
		ejemplo2.setIdCliente("eee");
		ejemplo.setEstado("eew");
		ejemplo2.setEstado("eew");
		ejemplo.setPrecioTotal(4);
		ejemplo2.setPrecioTotal(4);
		ejemplo.setNombreRestaurante("pepe");
		ejemplo2.setNombreRestaurante("pepe");
		ejemplo.setFechayhora("19:49");
		ejemplo2.setFechayhora("19:49");
		ejemplo.setTelefonoCliente("666");
		ejemplo2.setTelefonoCliente("666");
		ejemplo.setPedidosRealizados("atascaburras");
		ejemplo2.setPedidosRealizados("atascaburras");

		assertEquals(ejemplo.getId(),ejemplo2.getId());
		assertEquals(ejemplo.getIdRider(), ejemplo2.getIdRider());
		assertEquals(ejemplo.getNombreCliente(),ejemplo2.getNombreCliente());
		assertEquals(ejemplo.getApellidosCliente(), ejemplo2.getApellidosCliente());
		assertEquals(ejemplo.getDireccion(), ejemplo2.getDireccion());
		assertEquals(ejemplo.isEntregado(), ejemplo2.isEntregado());
		assertEquals(ejemplo.getIdCliente(), ejemplo2.getIdCliente());
		assertEquals(ejemplo.getEstado(), ejemplo2.getEstado());
		assertEquals(ejemplo.toString(), ejemplo2.toString());
		assertEquals(ejemplo.getPrecioTotal(), ejemplo2.getPrecioTotal());
		assertEquals(ejemplo.getNombreRestaurante(), ejemplo2.getNombreRestaurante());
		assertEquals(ejemplo.getFechayhora(), ejemplo2.getFechayhora());
		assertEquals(ejemplo.getTelefonoCliente(), ejemplo2.getTelefonoCliente());
		assertEquals(ejemplo.getPedidosRealizados(), ejemplo2.getPedidosRealizados());
		
		
	}
	
}