package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.TIComoApp.TIComo.controller.AdminController;
import com.TIComoApp.TIComo.controller.ClienteController;
import com.TIComoApp.TIComo.model.Administrador;
import com.TIComoApp.TIComo.model.Cliente;
import com.TIComoApp.TIComo.repository.AdministradorRepository;
import com.TIComoApp.TIComo.repository.ClienteRepository;
@SpringBootTest
class AdminControllerTest {

	 @Autowired
	   private AdministradorRepository administradorRepository;
	   @Autowired
	   private AdminController admincontroller;
	   
	   Administrador res=new Administrador("1A","Antonio","Tomás","Toledo@gmail.com", "5555555555Aa", "620000000");

	   @Rule
	   public ExpectedException exception = ExpectedException.none();
	   @Test
	   void testCrearAdmin() {
		   Administrador res= new Administrador("1A","Antonio","Tomás","Toledo@gmail.com", "5555555555Aa", "620000000");
		   Administrador res2=  new Administrador("1A","Antonio","Tomása","Toledo@gmail.com", "5555555555Aa", "620000000");
		   Administrador res3=  new Administrador("1A","Antonio","Tomásw","Toledo@gmail.com", "5555555555wAa", "620000000");
		   Administrador res4=  new Administrador("1A","Antonio","Tomás","Toledo@gmail.com", "5555555555A4", "620002000");
	       admincontroller.create(res);
	       admincontroller.create(res2);
	       admincontroller.create(res3);
	       admincontroller.create(res4);
	       
	      
	      }
	   
		@Test
		   void testActualizarAdmin(){
			   Administrador res2=new Administrador("1A","Antonio","Tomás","Toledo@gmail.com", "5555555555Aa", "620000000");

			   Administrador res3=new Administrador("1A","Antonio","Tomás","Toledo@gmail.com", "5555555555Aa", "620000000");
			   admincontroller.create(res2);
		       admincontroller.create(res3);
		       admincontroller.update("10",res2);
		       admincontroller.update("10",res3);

		       assertEquals(res2.toString(),admincontroller.update("1A", res2).toString());
		       



		   }
		@Test
		void testIndex() {
			List<Administrador> list=admincontroller.index();
			assertEquals(4,list.size());
		}
		
			
			@Test
		   void testEliminarAdmin(){
				 admincontroller.delete("1A");

			       assertThrows(RuntimeException.class,() ->{administradorRepository.findById("1A").orElseThrow(RuntimeException::new);});

		   }
}
