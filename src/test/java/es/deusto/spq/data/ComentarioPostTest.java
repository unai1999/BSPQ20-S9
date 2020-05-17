package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/** Clase para comprobar que los comentarios se crean correctamente
 * @author alvar
 *
 */
public class ComentarioPostTest {

	
	ComentarioPost comentario;
	Post post;
	
	@Before
	public void setUp() throws Exception {
		comentario = new ComentarioPost(post, "Prueba");
		post = new Post();
		post.setAutor("Alvar");
	}
	
	@Test
	public void pruebaCambio() {
		
		assertEquals("Prueba", comentario.getTexto());
		assertEquals("Alvar", comentario.getPost().getAutor());
	}

}
