package es.deusto.spq.GUI;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.deusto.spq.data.Post;
import es.deusto.spq.data.Usuario;

public class VentanaInfoPostTest {
	
	@Test
	public void comprobarVentana() {
		Post p1 = new Post("aaa", "bbb", "cc");
		Usuario u1 = new Usuario("aa", "aa", "aa", "aa", "aa");
		VentanaInfoPost v1 = new VentanaInfoPost(p1, u1);
		assertTrue(v1 !=null);
	}

}
