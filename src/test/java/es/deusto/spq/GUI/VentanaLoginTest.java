package es.deusto.spq.GUI;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VentanaLoginTest {
	
	@Test
	public void ComprobarVentana() {
		VentanaLogin v1 = new VentanaLogin();
		assertTrue(v1 != null);
		
	}

}
