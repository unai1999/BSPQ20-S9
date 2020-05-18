package es.deusto.spq.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FacturaTest {

	Factura f;
	Piso p;
	Usuario u1, u2;
	@Before
	public void setUp() throws Exception {
		p = new Piso("Barakaldo 33", 330.50);
		u1 = new Usuario("Eneko");
		u2 = new Usuario("Unai");
		f = new Factura();
		f.setArrendador(u2);
		f.setCliente("a");
		f.setFecha("07/05/2020");
		f.setId(120123);
		f.setImporte(1200);
		f.setPiso(p);
	}

	@Test
	public void setIdTest() {
		assertEquals(120123, f.getId());
	}
	
	@Test
	public void setFechaTest() {
		assertEquals("07/05/2020", f.getFecha());
	}
	
	@Test
	public void setPisoTest() {
		assertEquals(p, f.getPiso());
	}

	@Test
	public void setImporteTest() {
		assertEquals(1200, f.getImporte(), 1.0);
	}
	
	@Test
	public void setArrendadorTest() {
		assertEquals(u2, f.getArrendador());
	}
	
	@Test
	public void setClienteTest() {
		assertEquals(u1, f.getCliente());
	}
}
