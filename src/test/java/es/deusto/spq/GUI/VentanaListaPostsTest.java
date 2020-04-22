package es.deusto.spq.GUI;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import es.deusto.spq.data.Post;

public class VentanaListaPostsTest {

	@Test
	public void validarVentana() { 
		List<Post> posts = new ArrayList<Post>();
		Post p1 = new Post("aa", "bbb", "ccc");
		Post p2 = new Post("aa", "bbb", "ccc");
		posts.add(p1);
		posts.add(p2);
		List<Post> posts2 = new ArrayList<Post>();
		
		VentanaListaPosts v1 = new VentanaListaPosts(posts, posts, "aaa", "aaa");
		assertTrue(v1 != null);
		VentanaListaPosts v2 = new VentanaListaPosts(posts2, posts2, "aaa", "aaa");
		assertTrue(v2 != null);
	}
}
