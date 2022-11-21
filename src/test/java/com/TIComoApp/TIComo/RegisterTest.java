package com.TIComoApp.TIComo;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import  org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.TIComoApp.TIComo.model.Cliente;

 class RegisterTest {
	Cliente cli;
	@Before
	public void before() {
		System.out.println("before");
		cli=new Cliente(null, null, null, null, null, null, null, null);
		
	}
	
	@Test
	public void testString() {
		cli=new Cliente(null,null,null,null,"hola",null,null,null);
		assertEquals("hola","hola");
		
	}
	
}
