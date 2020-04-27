package es.deusto.spq.GUI;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import es.deusto.spq.data.Imagen;
import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Usuario;

public class VentanaCompararTest {

	@Test
	public void validarVentana() {
		Piso p1 = new Piso("AA", 2.0);
		Piso p2 = new Piso("BB", 3.0);
		Piso p3 = new Piso("CC", 2.0);
		Piso p4 = new Piso("DD", 3.0);
		List<Imagen> imagenes = new ArrayList<Imagen>();
		Imagen i = new Imagen("1", "aaa");
		imagenes.add(i);
		p3.setImagenes(imagenes);
		p4.setImagenes(imagenes);
		Usuario u1 = new Usuario("aa", "bb", "cc", "cd", "dd");
		VentanaComparar v1 = new VentanaComparar(p1, p2, u1);
		assertTrue(v1 != null);
		v1 = new VentanaComparar(p1, p3, u1);
		assertTrue(v1 != null);
		v1 = new VentanaComparar(p3, p2, u1);
		assertTrue(v1 != null);
	}
}
