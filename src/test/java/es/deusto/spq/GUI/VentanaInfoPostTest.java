package es.deusto.spq.GUI;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.deusto.spq.data.Post;

public class VentanaInfoPostTest {
	
	@Test
	public void comprobarVentana() {
		Post p1 = new Post("aaa", "bbb", "cc");
		VentanaInfoPost v1 = new VentanaInfoPost(p1, "", "8080");
		assertTrue(v1 !=null);
	}

}
