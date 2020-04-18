package es.deusto.spq.data;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import junit.framework.JUnit4TestAdapter;

public class PostTest {

        Post post;

        public static junit.framework.Test suite() {
            return new JUnit4TestAdapter(PostTest.class);
        }

        @Before
	    public void setUp() {
            post = new Post("Titulo", "Autor", "Contenido");
    	}

        @Test
        public void incLikesTest(){
            int likesP = post.getLikes();
            post.incLikes();
            assertEquals(likesP + 1, post.getLikes());
        }
}