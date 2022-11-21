package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.TIComoApp.TIComo.model.Valoracion;

public class ValoracionTest {

	@Test
	void testValoracion() {
		Valoracion ejemplo=new Valoracion("1","Rider",5,"xd","");
		Valoracion ejemplo2=new Valoracion("1","Rider",5,"xd","");
		assertEquals(ejemplo.getId(),ejemplo2.getId());
		assertEquals(ejemplo.getEsRiderORestaurante(), ejemplo2.getEsRiderORestaurante());
		assertEquals(ejemplo.getValoracion(), ejemplo2.getValoracion());
		assertEquals(ejemplo.getComentario(), ejemplo2.getComentario());
		assertEquals(ejemplo.toString(), ejemplo2.toString());	
	}
	@Test
	void testSetValoracion() {
		Valoracion ejemplo=new Valoracion("1","Rider",5,"xd","");
		Valoracion ejemplo2=new Valoracion("1","Rider",5,"xd","");
		ejemplo.setId("2");
		ejemplo2.setId("2");
		ejemplo.setEsRiderORestaurante("Restaurante");
		ejemplo2.setEsRiderORestaurante("Restaurante");
		ejemplo.setValoracion(4);
		ejemplo2.setValoracion(4);
		ejemplo.setComentario("dx");
		ejemplo2.setComentario("dx");
		assertEquals(ejemplo.getId(),ejemplo2.getId());
		assertEquals(ejemplo.getEsRiderORestaurante(), ejemplo2.getEsRiderORestaurante());
		assertEquals(ejemplo.getValoracion(), ejemplo2.getValoracion());
		assertEquals(ejemplo.getComentario(), ejemplo2.getComentario());
		
		
	}
	
}