package es.deusto.spq.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComentarioTest {

	Comentario c;
	@Before
	public void setUp() throws Exception {
	
		c = new Comentario(1, "Eneko", "aaaa");
		c.setId(1);
		c.setAutor("Eneko");
		c.setFecha("28/04/2020");
		c.setContenido("bb");
	}

	@Test
	public void setIdTest() {
		assertEquals(1, c.getId());
	}
	
	@Test
	public void setAutorTest() {
		assertEquals("Eneko", c.getAutor());
	}

	@Test
	public void setFechaTest() {
		assertEquals("28/04/2020", c.getFecha());
	}
	@Test
	public void setContenido() {
		assertEquals("bb", c.getContenido());
	}
}
