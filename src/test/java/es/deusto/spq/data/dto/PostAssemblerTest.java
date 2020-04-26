package es.deusto.spq.data.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Post;
import junit.framework.JUnit4TestAdapter;

public class PostAssemblerTest {

	
	Post post;
	PostDTO postDTO;
	PostAssembler as;
	
	 public static junit.framework.Test suite() {
         return new JUnit4TestAdapter(PostAssemblerTest.class);
     }
	
		
     @Before
     public void setUp() {
    	 post = new Post();
    	 post.setContenido("Post 100");
    	 post.setFecha("12/02/2020");
    	 post.setLikes(1232);
    	 post.setTitulo("Mi piso nuevo");
    	 
    	 as = new PostAssembler();
     }
     
     @Test
     public void assembleTest(){
    	
    	postDTO = as.assemble(post);
    	
    	assertEquals(postDTO.getTitulo(), post.getTitulo()); 
    	
    	 
     }
	
}
