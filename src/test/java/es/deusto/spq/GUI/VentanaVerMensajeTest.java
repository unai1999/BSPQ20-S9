package es.deusto.spq.GUI;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.deusto.spq.data.Mensaje;
import es.deusto.spq.data.MensajePrivado;


public class VentanaVerMensajeTest {

	
	@Test
	public void comprobarVentana() {
		// VentanaVerMensaje v1 = new VentanaVerMensaje(new Mensaje("1", "Prueba", "Esto es una prueba"));
		// assertTrue(v1 != null);
		MensajePrivado m = new MensajePrivado("", "", "");
		VentanaVerMensaje v1 = new VentanaVerMensaje(m);
		assertTrue(v1 != null);
	}
}
