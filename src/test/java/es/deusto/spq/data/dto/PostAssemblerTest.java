package es.deusto.spq.data.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Post;
import junit.framework.JUnit4TestAdapter;

public class PostAssemblerTest {

	
	Post post;
	PostDTO postDTO;
	PostDTO postDTO2;
	PostAssembler as;
	PostAssembler as2;
	
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
    	 as2 = new PostAssembler();
     }
     
     @Test
     public void assembleTest(){
    	
    	postDTO = as.assemble(post);
    	
    	assertEquals(postDTO.getTitulo(), post.getTitulo()); 
    	assertEquals(postDTO.getAutor(), post.getAutor()); 
    	assertEquals(postDTO.getContenido(), post.getContenido()); 
    	assertEquals(postDTO.getFecha(), post.getFecha()); 
    	assertEquals(postDTO.getLikes(), post.getLikes());

    	postDTO2 = as.assemble(null);
    	assertEquals(postDTO2, null);
    	
     }
	
}
