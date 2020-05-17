package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.ComentarioPost;
import es.deusto.spq.data.Post;

/** Clase para comprobar que los comentarios de la base de datos se almacenan y obtienen correctamente
 * @author alvar
 *
 */
public class ComentarioPostDAOTest {

	
	ComentarioPostDAO comentarioDAO;
	Post post;
	ComentarioPost comentarioPost;
	List<ComentarioPost> comentarios;
	String texto;
	
	@Before
	public void setUp() {
		comentarioDAO = new ComentarioPostDAO();
		post = new Post();
		post.setAutor("Eneko");
        post.setContenido("aaa");
        post.setLikes(3);
        post.setTitulo("bbbb");
  
		comentarioPost = new ComentarioPost(post, "Prueba JTest");
		
		
	}
	
	@Test
	public void guardarTest() {
		comentarioDAO.guardarComentario(comentarioPost);
		
		comentarios = comentarioDAO.getComentarios(post);
		texto = "";
		
		for(ComentarioPost c : comentarios) {
			if(c.getTexto().equals(comentarioPost.getTexto())) {
				texto = c.getTexto();
			}
		}
		
		assertEquals(comentarioPost.getTexto(), texto);
	}
}
