package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.TIComoApp.TIComo.model.Restaurante;

class RestauranteTest {

	@Test
	void testRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		assertEquals(ejemplo.getId(),ejemplo2.getId());
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
		assertEquals(ejemplo.getRazonSocial(),ejemplo2.getRazonSocial());
		assertEquals(ejemplo.getCIF(),ejemplo2.getCIF());
		assertEquals(ejemplo.getDireccionCompleta(),ejemplo2.getDireccionCompleta());
		assertEquals(ejemplo.getTelefono(),ejemplo2.getTelefono());
		assertEquals(ejemplo.getEmail(),ejemplo2.getEmail());
		assertEquals(ejemplo.getCategoria(),ejemplo2.getCategoria());
	}

	@Test
	void testGetIdRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		assertEquals(ejemplo.getId(),ejemplo2.getId());
	}

	@Test
	void testSetIdRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		ejemplo.setId("5");
		ejemplo2.setId("5");
		assertEquals(ejemplo.getId(),ejemplo2.getId());
	}

	@Test
	void testGetNombreRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
	}

	@Test
	void testSetNombreRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		ejemplo.setNombre("La Azada");
		ejemplo2.setNombre("La Azada");
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
	}

	@Test
	void testGetRazonSocialRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		assertEquals(ejemplo.getRazonSocial(),ejemplo2.getRazonSocial());
	}

	@Test
	void testSetRazonSocialRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		ejemplo.setRazonSocial("Comidas Tradicionales");
		ejemplo2.setRazonSocial("Comidas Tradicionales");
		assertEquals(ejemplo.getRazonSocial(),ejemplo2.getRazonSocial());
	}

	@Test
	void testGetCIFRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		assertEquals(ejemplo.getCIF(),ejemplo2.getCIF());
	}

	@Test
	void testSetCIFRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		ejemplo.setCIF("A9B8C7D6");
		ejemplo2.setCIF("A9B8C7D6");
		assertEquals(ejemplo.getCIF(),ejemplo2.getCIF());
	}

	@Test
	void testGetDireccionCompletaRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		assertEquals(ejemplo.getDireccionCompleta(),ejemplo2.getDireccionCompleta());
	}

	@Test
	void testSetDireccionCompletaRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		ejemplo.setDireccionCompleta("Calle Juan de Avila 2");
		ejemplo2.setDireccionCompleta("Calle Juan de Avila 2");
		assertEquals(ejemplo.getDireccionCompleta(),ejemplo2.getDireccionCompleta());
	}

	@Test
	void testGetTelefonoRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		assertEquals(ejemplo.getTelefono(),ejemplo2.getTelefono());
	}

	@Test
	void testSetTelefonoRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		ejemplo.setTelefono("562830164");
		ejemplo2.setTelefono("562830164");
		assertEquals(ejemplo.getTelefono(),ejemplo2.getTelefono());
	}

	@Test
	void testGetEmailRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		assertEquals(ejemplo.getEmail(),ejemplo2.getEmail());
	}

	@Test
	void testSetEmailRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		ejemplo.setEmail("LaAzada@gmail.com");
		ejemplo2.setEmail("LaAzada@gmail.com");
		assertEquals(ejemplo.getEmail(),ejemplo2.getEmail());
	}

	@Test
	void testGetCategoriaRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		assertEquals(ejemplo.getCategoria(),ejemplo2.getCategoria());
	}

	@Test
	void testSetCategoriaRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		ejemplo.setCategoria("Comida Casera");
		ejemplo2.setCategoria("Comida Casera");
		assertEquals(ejemplo.getCategoria(),ejemplo2.getCategoria());
	}

	@Test
	void testtoStringRestaurante() {
		Restaurante ejemplo=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		Restaurante ejemplo2=new Restaurante("1","El molino","Comidas Manchegas S.L","A1B2C3D4","Calle Gran Capitan 6","999999999", "elmolino@gmail.com", "Comida tradicional");
		assertEquals(ejemplo.toString(),ejemplo2.toString());}

}

