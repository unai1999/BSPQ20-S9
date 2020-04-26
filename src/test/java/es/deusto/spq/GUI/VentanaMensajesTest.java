package es.deusto.spq.GUI;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.deusto.spq.data.Usuario;

public class VentanaMensajesTest {

	
	@Test
	public void comprobarVentana() {
		VentanaMensajes v1 = new VentanaMensajes("aaaa", "aaaa", new Usuario("Nombre", "pw"));
		assertTrue(v1 != null);
	}
}
