package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class IdiomaTest {

	
	Idioma idioma1;
	Idioma idioma2;
	
	@Before
	public void setUp() throws Exception {
		idioma1 = new Idioma("Español");
		idioma2 = new Idioma("Ingles");
	}
	
	@Test
	public void pruebaCambio() {
		
		assertEquals("Nombre", idioma1.getProperty("Nombre"));
		assertEquals("Name", idioma2.getProperty("Nombre"));
	}
	
}
