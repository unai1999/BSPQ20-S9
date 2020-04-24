package es.deusto.spq.GUI;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VentanaRegistroTest {
	
	@Test
	public void comprobarVentana() {
		VentanaRegistro v1 = new VentanaRegistro("", "");
		assertTrue(v1 != null);
	}

}
