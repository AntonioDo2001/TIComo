package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.TIComoApp.TIComo.model.Plato;

class PlatoTest {


	@Test
	void testPlato() {
		Plato ejemplo=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		Plato ejemplo2=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		assertEquals(ejemplo.getId(),ejemplo2.getId());
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
		assertEquals(ejemplo.getFoto(),ejemplo2.getFoto());
		assertEquals(ejemplo.getDescripcion(),ejemplo2.getDescripcion());
		assertEquals(ejemplo.getPrecio(),ejemplo2.getPrecio());
		assertEquals(ejemplo.isAptoVeganos(),ejemplo2.isAptoVeganos());
		assertEquals(ejemplo.getNombreRestaurante(),ejemplo2.getNombreRestaurante());
	}

	@Test
	void testGetIdPlato() {
		Plato ejemplo=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		Plato ejemplo2=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		assertEquals(ejemplo.getId(),ejemplo2.getId());
		
	}

	@Test
	void testSetIdPlato() {
		Plato ejemplo=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		Plato ejemplo2=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		ejemplo.setId("5");
		ejemplo2.setId("5");
		assertEquals(ejemplo.getId(),ejemplo2.getId());
		
	}

	@Test
	void testGetNombrePlato() {
		Plato ejemplo=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		Plato ejemplo2=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
	}

	@Test
	void testSetNombrePlato() {
		Plato ejemplo=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		Plato ejemplo2=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		ejemplo.setNombre("Cocidito Casero");
		ejemplo2.setNombre("Cocidito Casero");
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
	}

	@Test
	void testGetFotoPlato() {
		Plato ejemplo=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		Plato ejemplo2=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		assertEquals(ejemplo.getFoto(),ejemplo2.getFoto());
	}

	@Test
	void testSetFotoPlato() {
		Plato ejemplo=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		Plato ejemplo2=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		ejemplo.setFoto("Foto2");
		ejemplo2.setFoto("Foto2");
		assertEquals(ejemplo.getFoto(),ejemplo2.getFoto());
	}

	@Test
	void testGetDescripcionPlato() {
		Plato ejemplo=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		Plato ejemplo2=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		assertEquals(ejemplo.getDescripcion(),ejemplo2.getDescripcion());
	}

	@Test
	void testSetDescripcionPlato() {
		Plato ejemplo=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		Plato ejemplo2=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		ejemplo.setDescripcion("Cocidito rico rico y con fundamento");
		ejemplo2.setDescripcion("Cocidito rico rico y con fundamento");
		assertEquals(ejemplo.getDescripcion(),ejemplo2.getDescripcion());
	
	}

	@Test
	void testGetPrecioPlato() {
		Plato ejemplo=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		Plato ejemplo2=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		assertEquals(ejemplo.getPrecio(),ejemplo2.getPrecio());
	}

	@Test
	void testSetPrecioPlato() {
		Plato ejemplo=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		Plato ejemplo2=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		ejemplo.setPrecio(12);
		ejemplo2.setPrecio(12);
		assertEquals(ejemplo.getPrecio(),ejemplo2.getPrecio());
	}

	@Test
	void testIsAptoVeganosPlato() {
		Plato ejemplo=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		Plato ejemplo2=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		assertEquals(ejemplo.isAptoVeganos(),ejemplo2.isAptoVeganos());
	}

	@Test
	void testSetAptoVeganosPlato() {
		Plato ejemplo=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		Plato ejemplo2=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		ejemplo.setAptoVeganos(true);
		ejemplo2.setAptoVeganos(true);
		assertEquals(ejemplo.isAptoVeganos(),ejemplo2.isAptoVeganos());
	}

	@Test
	void testGetNombreRestaurantePlato() {
		Plato ejemplo=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		Plato ejemplo2=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		assertEquals(ejemplo.getNombreRestaurante(),ejemplo2.getNombreRestaurante());
	}

	@Test
	void testSetNombreRestaurantePlato() {
		Plato ejemplo=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		Plato ejemplo2=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		ejemplo.setNombreRestaurante("bsjbf21");
		ejemplo2.setNombreRestaurante("bsjbf21");
		assertEquals(ejemplo.getNombreRestaurante(),ejemplo2.getNombreRestaurante());
	}

	@Test
	void testtoStringPlato() {
		Plato ejemplo=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		Plato ejemplo2=new Plato("1","Cocido de la abuela","Foto1","Cocido tradicional español", 10,false," No asignado");
		assertEquals(ejemplo.toString(),ejemplo2.toString());

	}

}

