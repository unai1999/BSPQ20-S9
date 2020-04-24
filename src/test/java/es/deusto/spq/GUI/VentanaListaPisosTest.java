package es.deusto.spq.GUI;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Usuario;

public class VentanaListaPisosTest {

	@Test
	public void validarVentana() { 
		List<Piso> pisos = new ArrayList<Piso>();
		Piso p1 = new Piso("AA", 2.0);
		pisos.add(p1);
		Usuario u1 = new Usuario("aa", "bb", "cc", "cd", "dd");
		List<Piso> pisos2 = new ArrayList<Piso>();
		VentanaListaPisos v1 = new VentanaListaPisos(pisos, pisos, "aaa", "aaa", u1);
		assertTrue(v1 != null);
		VentanaListaPisos v2 = new VentanaListaPisos(pisos2, pisos2, "aaa", "aaa", u1);
		assertTrue(v2 != null);
	}
}
