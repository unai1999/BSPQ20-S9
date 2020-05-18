package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Post;

public class PostDAOTest {
	 PostDAO postDAO;
	 Post p1;
	 List<Post> posts;
	 String contenido;
	 @Before
	 public void setUp(){
		postDAO = new PostDAO();
	    p1 = new Post();
	    p1.setAutor("Eneko");p1.setContenido("aaaaaa");p1.setFecha("17/05/2020");
	    p1.setLikes(2);
	    p1.setTitulo("Piso bonito");
	 }

	 @Test
	 public void guardarTest(){
		postDAO.guardarPost(p1);
		posts = postDAO.getPosts();
		contenido = "aaaaaa";
		
		for(Post p : posts) {
			if(p.getContenido().equals(p1.getContenido())) {
				contenido = p.getContenido();
			}
		}
		
		assertEquals(p1.getContenido(), contenido); 
	    }
}