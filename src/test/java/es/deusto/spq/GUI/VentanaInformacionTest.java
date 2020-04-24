package es.deusto.spq.GUI;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import es.deusto.spq.data.Imagen;
import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Usuario;

public class VentanaInformacionTest {
	@Test
	public void validarVentana() { 
		Piso p1 = new Piso("AA", 2.0);
		Piso p2 = new Piso("BB", 3.0);
		Piso p3 = new Piso("CC", 4.0);
		Piso p4 = new Piso("DD", 5.0);
		Piso p5 = new Piso("EE", 6.0);
		Piso p6 = new Piso("FF", 7.0);
		List<Imagen> imagenes = new ArrayList<Imagen>();
		List<Imagen> imagenes2 = new ArrayList<Imagen>();
		List<Imagen> imagenes3 = new ArrayList<Imagen>();
		List<Imagen> imagenes4 = new ArrayList<Imagen>();
		List<Imagen> imagenes5 = new ArrayList<Imagen>();
		Imagen i = new Imagen("1", "aaa");
		Imagen i2 = new Imagen("2", "aaa");
		Imagen i3 = new Imagen("3", "aaa");
		Imagen i4 = new Imagen("3", "aaa");
		Imagen i5 = new Imagen("3", "aaa");
		imagenes.add(i);
		imagenes2.add(i);
		imagenes2.add(i2);
		imagenes3.add(i);
		imagenes3.add(i2);
		imagenes3.add(i3);
		imagenes4.add(i);
		imagenes4.add(i2);
		imagenes4.add(i3);
		imagenes4.add(i4);
		imagenes5.add(i);
		imagenes5.add(i2);
		imagenes5.add(i3);
		imagenes5.add(i4);
		imagenes5.add(i5);
		p2.setImagenes(imagenes);
		p3.setImagenes(imagenes2);
		p4.setImagenes(imagenes3);
		p5.setImagenes(imagenes4);
		p6.setImagenes(imagenes5);
		Usuario u1 = new Usuario("aa", "bb", "cc", "cd", "dd");
		
		VentanaInformacion v1 = new VentanaInformacion(p1, u1, "aaa", "aaa");
		assertTrue(v1 != null);
		v1 = new VentanaInformacion(p2, u1, "aaa", "aaa");
		assertTrue(v1 != null);
		v1 = new VentanaInformacion(p3, u1, "aaa", "aaa");
		assertTrue(v1 != null);
		v1 = new VentanaInformacion(p4, u1, "aaa", "aaa");
		assertTrue(v1 != null);
		v1 = new VentanaInformacion(p5, u1, "aaa", "aaa");
		assertTrue(v1 != null);
		v1 = new VentanaInformacion(p6, u1, "aaa", "aaa");
		assertTrue(v1 != null);
	}

}
