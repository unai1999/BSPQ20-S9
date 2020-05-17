package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/** Clase para comprobar que los comentarios se crean correctamente
 * @author alvar
 *
 */
public class ComentarioPisoTest {

	
	ComentarioPiso comentario;
	Piso piso;
	
	@Before
	public void setUp() throws Exception {
		piso = new Piso();
		piso.setCoste(200.0);
		comentario = new ComentarioPiso(piso, "Prueba");
		
	}
	
	@Test
	public void pruebaCambio() {
		
		assertEquals("Prueba", comentario.getTexto());
		assertTrue(200.0 == comentario.getPiso().getCoste());
	}
}
