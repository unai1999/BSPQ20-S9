package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	Usuario u1;
	
	@Before
	public void setUp() {
		u1 = new Usuario("aa", "bb");
		ArrayList<MensajePrivado> m = new ArrayList<MensajePrivado>();
		MensajePrivado mp = new MensajePrivado("dd", "ee", "hh");
		m.add(mp);
		Piso p = new Piso("ccc", 3.0);
		u1.setPiso(p);
		u1.setTienePiso(true);
		u1.setMensajes(m);
		u1.setMonedero(1000);
	}
	
	@Test
	public void ComprobarUsuario() {
		assertEquals("ccc", u1.getPiso().getNombre());
		assertTrue((u1.getMensajes().size() > 0));
		assertTrue(u1.getMonedero() == 1000);

		
	}

}
