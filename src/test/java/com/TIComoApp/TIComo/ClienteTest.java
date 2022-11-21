package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.TIComoApp.TIComo.model.Administrador;
import com.TIComoApp.TIComo.model.Cliente;

 class ClienteTest {
	@Test
	void testCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		assertEquals(ejemplo.getId(),ejemplo2.getId());
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
		assertEquals(ejemplo.getApellidos(),ejemplo2.getApellidos());
		assertEquals(ejemplo.getEmail(),ejemplo2.getEmail());
		assertEquals(ejemplo.getPassword(),ejemplo2.getPassword());
		assertEquals(ejemplo.getNIF(),ejemplo2.getNIF());
		assertEquals(ejemplo.getDireccionCompleta(),ejemplo2.getDireccionCompleta());
		assertEquals(ejemplo.getTelefono(),ejemplo2.getTelefono());	
	}

	@Test
	void testGetNIFCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		assertEquals(ejemplo.getNIF(),ejemplo2.getNIF());
	}

	@Test
	void testSetNIFCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		ejemplo.setNIF("98215238B");
		ejemplo2.setNIF("98215238B");
		assertEquals(ejemplo.getNIF(),ejemplo2.getNIF());
	}

	@Test
	void testGetDireccionCompletaCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		assertEquals(ejemplo.getDireccionCompleta(),ejemplo2.getDireccionCompleta());
	}

	@Test
	void testSetDireccionCompletaCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		ejemplo.setDireccionCompleta("Juan Avila 12");
		ejemplo2.setDireccionCompleta("Juan Avila 12");
		assertEquals(ejemplo.getDireccionCompleta(),ejemplo2.getDireccionCompleta());
	}

	@Test
	void testGetTelefonoCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		assertEquals(ejemplo.getTelefono(),ejemplo2.getTelefono());
	}

	@Test
	void testSetTelefonoCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		ejemplo.setTelefono("817291863");
		ejemplo2.setTelefono("817291863");
		assertEquals(ejemplo.getTelefono(),ejemplo2.getTelefono());
	}

	@Test
	void testGetIdCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		assertEquals(ejemplo.getId(),ejemplo2.getId());
	}

	@Test
	void testSetIdCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		ejemplo.setId("3");
		ejemplo2.setId("3");
		assertEquals(ejemplo.getId(),ejemplo2.getId());
	}

	@Test
	void testGetNombreCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
	}

	@Test
	void testSetNombreCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		ejemplo.setNombre("Leandro");
		ejemplo2.setNombre("Leandro");
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
	}

	@Test
	void testGetApellidosCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		assertEquals(ejemplo.getApellidos(),ejemplo2.getApellidos());
	}

	@Test
	void testSetApellidosCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		ejemplo.setApellidos("Fernandez");
		ejemplo2.setApellidos("Fernandez");
		assertEquals(ejemplo.getApellidos(),ejemplo2.getApellidos());
	}

	@Test
	void testGetEmailCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		assertEquals(ejemplo.getEmail(),ejemplo2.getEmail());
	}

	@Test
	void testSetEmailCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		ejemplo.setEmail("LFernandez@gmail.com");
		ejemplo2.setEmail("LFernandez@gmail.com");
		assertEquals(ejemplo.getEmail(),ejemplo2.getEmail());
	}

	@Test
	void testGetPasswordCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		assertEquals(ejemplo.getPassword(),ejemplo2.getPassword());
	}

	@Test
	void testSetPasswordCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		ejemplo.setPassword("12445178Aa");
		ejemplo2.setPassword("12445178Aa");
		assertEquals(ejemplo.getPassword(),ejemplo2.getPassword());
	}
	
	@Test
	void testtoStringCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		assertEquals(ejemplo.toString(),ejemplo2.toString());
		
	}
	
	@Test
	void testContraseniaSeguraCliente() {
		Cliente ejemplo=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		Cliente ejemplo2=new Cliente("1","Facundo","Corral","FCorral@gmail.com","12345678Aa","98215698B","Bailen 12", "734523423");
		assertEquals(ejemplo.contraseniaSegura(ejemplo.getPassword()),ejemplo2.contraseniaSegura(ejemplo2.getPassword()));
	
	}

}