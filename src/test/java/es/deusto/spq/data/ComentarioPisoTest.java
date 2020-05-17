package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ComentarioPisoTest {

	
	ComentarioPiso comentario;
	Piso piso;
	
	@Before
	public void setUp() throws Exception {
		comentario = new ComentarioPiso(piso, "Prueba");
		piso = new Piso();
		piso.setCoste(200.0);
	}
	
	@Test
	public void pruebaCambio() {
		
		assertEquals("Prueba", comentario.getTexto());
		assertTrue(200.0 == comentario.getPiso().getCoste());
	}
}
