package es.deusto.spq.GUI;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.deusto.spq.data.Mensaje;
import es.deusto.spq.data.MensajePrivado;


public class VentanaVerMensajeTest {

	
	@Test
	public void comprobarVentana() {
		MensajePrivado m = new MensajePrivado("", "", "");
		VentanaVerMensaje v1 = new VentanaVerMensaje(m);
		assertTrue(v1 != null);
	}
}
