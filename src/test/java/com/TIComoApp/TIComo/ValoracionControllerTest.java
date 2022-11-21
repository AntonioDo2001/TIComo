package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.TIComoApp.TIComo.model.Valoracion;
import com.TIComoApp.TIComo.repository.ValoracionRepository;
import com.TIComoApp.TIComo.controller.PedidoController;
import com.TIComoApp.TIComo.controller.ValoracionController;

@SpringBootTest
public class ValoracionControllerTest {
	@Autowired
    private ValoracionController valcontroller;
	@Test
	void testA() {
		Valoracion val=new Valoracion("1","Rider",8,"Bien","");
		valcontroller.create(val);
	}
	@Test
	void testB() {
		valcontroller.index();
	}

}