package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PagoTest {
	
	Pago pago;
	
	@Before
	public void setUp() throws Exception {
		pago = new Pago();
		pago.setEmail("j.uraga@opendeusto.es");
		pago.setPrecio(200);
	}
	
	@Test
	public void setEmailTest() {
		assertEquals("j.uraga@opendeusto.es", pago.getEmail());
	}
	
	@Test
	public void setPrecioTest() {
		assertEquals(200, pago.getPrecio());
	}

}
