package es.deusto.spq.data;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import junit.framework.JUnit4TestAdapter;

public class PostTest {

        Post post;
        Comentario c;
        List<Comentario> listaComentario;

        public static junit.framework.Test suite() {
            return new JUnit4TestAdapter(PostTest.class);
        }

        @Before
	    public void setUp() {
        	listaComentario = new ArrayList<Comentario>();
            post = new Post("Titulo", "Autor", "Contenido");
            c = new Comentario(1, "Autor", "Contenido");
            //listaComentario.add(c);
            post.setAutor("Eneko");
            post.setContenido("aaa");
            post.setLikes(3);
            //post.setComentarios(listaComentario);
            post.setTitulo("bbbb");
            c.setContenido("aaaa");
    	}
//        @Test
//        public void setComentariosTest() {
//        	assertTrue(post.getComentarios().size()> 0);
//        }

        @Test
        public void setAutorTest() {
        	assertEquals("Eneko", post.getAutor());
        }
        
       
        @Test
        public void incLikesTest(){
            int likesP = post.getLikes();
            post.incLikes();
            assertEquals(likesP + 1, post.getLikes());
        }
//        @Test
//        public void addComentarioTest(){
//            assertEquals(1, post.getComentarios().size());
//            assertEquals(c, post.getComentarios().get(0));
//        }
  
}