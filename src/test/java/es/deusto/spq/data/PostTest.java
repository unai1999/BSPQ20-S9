package es.deusto.spq.data;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import junit.framework.JUnit4TestAdapter;

public class PostTest {

        Post post;
        Comentario c;

        public static junit.framework.Test suite() {
            return new JUnit4TestAdapter(PostTest.class);
        }

        @Before
	    public void setUp() {
            post = new Post("Titulo", "Autor", "Contenido");
            c = new Comentario(1, "Autor", "Contenido");
    	}

        @Test
        public void incLikesTest(){
            int likesP = post.getLikes();
            post.incLikes();
            assertEquals(likesP + 1, post.getLikes());
        }

        @Test
        public void addComentarioTest(){
            assertEquals(0, post.getComentarios().size());
            post.addComentario(c);
            assertEquals(1, post.getComentarios().size());
            assertEquals(c, post.getComentarios().get(0));
        }
}