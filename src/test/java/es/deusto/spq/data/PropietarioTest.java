package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PropietarioTest {
	
	Propietario p;
	
	@Before
	public void setUp() {
		p = new Propietario("aa", "bb", "cc", "dd", "ee");
		List<Piso> pisos = new ArrayList<Piso>();
		Piso piso = new Piso("aa", 3.0);
		pisos.add(piso);
		p.setPisos(pisos);
	}
	
	@Test
	public void comprobarPropietario() {
		assertEquals("aa", p.getNickname());
		assertEquals("cc", p.getApellidos());
		assertEquals("dd", p.getEmail());
		assertEquals("ee", p.getPw());
		assertTrue(p.getPisos().size() > 0);
	}

}
