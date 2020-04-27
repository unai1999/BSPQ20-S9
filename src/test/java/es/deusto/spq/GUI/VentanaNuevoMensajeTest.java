package es.deusto.spq.GUI;

import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class VentanaNuevoMensajeTest {

	@Test
	public void comprobarVentana() {
		VentanaNuevoMensaje v1 = new VentanaNuevoMensaje();
		assertTrue(v1 != null);
	}
	
}
