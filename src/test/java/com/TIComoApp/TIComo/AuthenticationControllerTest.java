package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;
import org.bson.json.JsonObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.TIComoApp.TIComo.model.Cliente;
import com.TIComoApp.TIComo.controller.AuthenticationController;


@SpringBootTest
class AuthenticationControllerTest {
	@Autowired
	private AuthenticationController autcontroller;

	
	@Test
	void createTest() {
		Cliente cliente= new Cliente("10","Paco","PEPE","pacopepe@gmail.com", "12345678Ab","Norte","","666666666");//cambiar a uno que no existe
		Cliente cliente2= new Cliente("10","Paco","PEPE","pacopepe@gmail.com", "12345678Ab","Norte","","");
		Cliente cliente3= new Cliente("10","Paco","PEPE","pacopepe", "12345678Ab","Norte","","");
		Cliente cliente4= new Cliente("10","Paco","PEPE","paco@gmail.com", "12345678Ab","Norte","","");
       autcontroller.create(cliente);
       autcontroller.create(cliente2);
       autcontroller.create(cliente3);
       autcontroller.create(cliente4);
	}
	
	@Test
	void loginTest() {
		
		JsonObject jadmin=autcontroller.loginUser("javieradmin@ticomo.com","44444444Zz");
		JsonObject jcliente=autcontroller.loginUser("tomasclienteticomo@gmail.com","22222222Cc");
		JsonObject jrider=autcontroller.loginUser("joseluisrider@ticomo.com","12345678Aa");
		assertEquals("{\"respuesta\":\"adminLogin\"",jadmin.toString());
		assertEquals("{\"respuesta\":\"clienteLogin\",\"idCliente\":\"63624d6c47774a5c1af31a2f\"}",jcliente.toString());
		assertEquals("{\"respuesta\":\"riderLogin\",\"idRider\":\"63624be447774a5c1af31a2c\"}",jrider.toString());
		
		JsonObject jadmin2=autcontroller.loginUser("javieradmin@ticomo.com","44444444Zzz");
		JsonObject jcliente2=autcontroller.loginUser("tomasclienteticomo@gmail.com","22222222Ccc");
		JsonObject jrider2=autcontroller.loginUser("joseluisrider@ticomo.com","12345678Aaa");
		assertEquals("{\"respuesta\":\"Email o Password  incorrecto\"}",jadmin2.toString());
		assertEquals("{\"respuesta\":\"Email o Password incorrectos\"}",jcliente2.toString());
		assertEquals("{\"respuesta\":\"Email o Password incorrecto\"}",jrider2.toString());

	}

}