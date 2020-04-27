package es.deusto.spq.GUI;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.deusto.spq.data.Usuario;

public class VentanaInfoUsuarioTest {

	@Test
	public void comprobarVentana() {
		Usuario u1 = new Usuario("aa", "bb", "cc", "cd", "dd");
		VentanaInfoUsuario v1 = new VentanaInfoUsuario(u1);
		assertTrue(v1 != null);
	}
}
