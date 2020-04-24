package es.deusto.spq.GUI;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FormularioForoTest {
	@Test
	public void comprobarVentana() {
		FormularioForo f1 = new FormularioForo();
		assertTrue(f1 != null);
	}

}
