package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Clase que prueba la funcionalidad correspondiente a la clase Pago
 * @author jonuraga
 *
 */
public class PagoTest {
	
	Pago pago;
	
	@Before
	public void setUp() throws Exception {
		pago = new Pago();
		pago.setEmail("j.uraga@opendeusto.es");
		pago.setPrecio(200);
	}
	
	/**
	 * Test para comprobar que los métodos set y get de email funcionan correctamente
	 */
	@Test
	public void setEmailTest() {
		assertEquals("j.uraga@opendeusto.es", pago.getEmail());
	}
	
	/**
	 * Test para comprobar los get y set de precio
	 */
	@Test
	public void setPrecioTest() {
		assertEquals(200, pago.getPrecio());
	}

}
