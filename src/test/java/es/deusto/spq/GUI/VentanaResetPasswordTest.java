package es.deusto.spq.GUI;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VentanaResetPasswordTest {
	
	@Test
	public void comprobarVentana() {
		VentanaResetPassword v1 = new VentanaResetPassword("");
		assertTrue(v1 != null);
	}

}
