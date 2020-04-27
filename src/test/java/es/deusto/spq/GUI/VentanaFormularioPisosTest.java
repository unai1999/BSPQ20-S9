package es.deusto.spq.GUI;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VentanaFormularioPisosTest {
	
	@Test
	public void comprobarVentana() {
		VentanaFormularioPisos v1 = new VentanaFormularioPisos();
		assertTrue(v1 != null);
	}

}
