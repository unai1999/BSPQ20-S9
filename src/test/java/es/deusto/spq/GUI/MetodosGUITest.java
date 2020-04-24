package es.deusto.spq.GUI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.GUI.MetodosGUI.Resp;

public class MetodosGUITest {

	MetodosGUI mGUI;
	Resp r;	
	
	
	@Before
	public void setUp() {
		mGUI = new MetodosGUI();
		
	}
	
	@Test
	public void validarNombreTest() {
		assertTrue(mGUI.validarNombre("Eneko"));
		assertFalse(mGUI.validarNombre(""));
	}
	
	@Test
	public void validarUsuarioTest() {
		assertTrue(mGUI.validarUsuario("eneko98"));
		assertTrue(mGUI.validarUsuario(""));
	}
	
	@Test
	public void validarContrasenyaTest() {
		assertTrue(mGUI.validarContrasenya("12345678"));
		assertFalse(mGUI.validarContrasenya("a123dg"));
	}
	
	@Test 
	public void validarConfContrasenyaTest() {
		assertTrue(mGUI.validarConfContrasenya("12345678", "12345678"));
		assertFalse(mGUI.validarConfContrasenya("asd12334", "12345678"));
	}
	
	@Test
	public void validarEmailTest() {
		assertTrue(mGUI.validarEmail("enekovalero@gmail.com"));
		assertFalse(mGUI.validarEmail("eneko"));
	}

	@Test
	public void validate(){
		r = MetodosGUI.validate("12345", "123456");
		assertEquals(Resp.MISSMATCH, r);
		r = MetodosGUI.validate("p1", "p1");
		assertEquals(Resp.LENGTH, r);
		r = MetodosGUI.validate("123456", "123456");
		assertEquals(Resp.VALID, r);
	}
}
