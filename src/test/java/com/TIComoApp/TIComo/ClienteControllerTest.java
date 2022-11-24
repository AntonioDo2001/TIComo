package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.TIComoApp.TIComo.controller.ClienteController;
import com.TIComoApp.TIComo.model.Cliente;
import com.TIComoApp.TIComo.repository.ClienteRepository;
@SpringBootTest
class ClienteControllerTest {

	 @Autowired
	   private ClienteRepository clienteRepository;
	   @Autowired
	   private ClienteController clientecontroller;
	   


	   @Rule
	   public ExpectedException exception = ExpectedException.none();
	   @Test
	   void testA() {
		   Cliente res= new Cliente("1A","Antonio","Tomás","Toledo@gmail.com", "ijhdfisbdfsdif13987JIB", "62000000X", "Calle Desengaño 21 3ºA", "123456789");
		   Cliente res2= new Cliente("1B","Antonio","Tomás","Toled222o@gmail.com", "ijhdfisbdfsdif13987JIV", "62000000C", "Calle Desengaño 21 3ºC", "123456787");
		   Cliente res3= new Cliente("1C","Antonio","Tomás","Toledo", "ijhd4564654sdfDSD", "62000000S", "Calle ejemplo", "123456781");
		   Cliente res4= new Cliente("1R","Antonio","Tomás","Toledo@gmail.com", "ijhdfisbdfsdif13987JIsjd", "62000000W", "Calle Desengaño 22", "5554");
		   Cliente res5= new Cliente("1P","Juan","Tomás","ciudadreal@gmail.com", "ij", "62000000W", "Calle Desengaño 22", "123456789");
		   Cliente res6= new Cliente("1N","Paco","Tomás","ejemplo@gmail.com", "ijhdfisbdfsdif13987JIsjd", "62000000W", "Calle Desengaño 22", "5554");
		   
	       clientecontroller.create(res);
	       clientecontroller.create(res2);
	       clientecontroller.create(res3);
	       clientecontroller.create(res4);
	       clientecontroller.create(res4);
	       clientecontroller.create(res5);
	       
	      
	      }
	   
		@Test
		   void testB(){
			   Cliente res= new Cliente("1A","Antonio","Tomás","Toledo@gmail.com", "ijhdfisbdfsdif13987JIB", "62000000X", "Calle Desengaño 21 3ºA", "123456789");
			   Cliente res2= new Cliente("1B","Antonio","Tomás","Toledo@gmail.com", "ijhdfisbdfsdif13987JIV", "62000000C", "Calle Desengaño 21 3ºC", "123456787");
			   Cliente res3= new Cliente("1C","Antonio","Tomás","Toledo", "ijhd4564654sdfDSD", "62000000S", "Calle ejemplo", "123456781");
			   Cliente res4= new Cliente("1R","Antonio","Tomás","Toledo@gmail.com", "ijhdfisbdfsdif13987JIsjd", "62000000W", "Calle Desengaño 22", "5554");
			   Cliente res5= new Cliente("1P","Juan","Tomás","ciudadreal@gmail.com", "ij", "62000000W", "Calle Desengaño 22", "123456789");
			   Cliente res6= new Cliente("1N","Paco","Tomás","ejemplo@gmail.com", "ijhdfisbdfsdif13987JIsjd", "62000000W", "Calle Desengaño 22", "5554");

			   clientecontroller.update("1A",res3);
		       clientecontroller.update("1A",res5);
		       clientecontroller.update("1A",res4);
		       clientecontroller.update("1A",res6);

		       assertEquals(res2.toString(),clientecontroller.update("1A", res2).toString());
		       



		   }
		@Test
		void testD() {
			List<Cliente> list=clientecontroller.index();
			assertNotEquals(0,list.size());
		}
		
			
			@Test
		   void testE(){
		       clientecontroller.delete("1B");



		   }
			
			@Test
			   void testobtenerCliente(){
				 
			       assertNotEquals(null,clientecontroller.obtenerCliente("63624df247774a5c1af31a30"));
			       



			   }
}