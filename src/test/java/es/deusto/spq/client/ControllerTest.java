package es.deusto.spq.client;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Post;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import junit.framework.JUnit4TestAdapter;

public class ControllerTest {

    
    Controller controller;

    @Mock
    Client client;

    @Mock
    WebTarget WebTarget;

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(ControllerTest.class);
    }

    @Before
    public void setUp(){
        
        
    }

    @Test
    public void PublicarPostTest(){

        // when(controller.publicarPost("a", "a", "a")).thenReturn(Response.status(Response.Status.OK).build());

        // assertEquals(controller.publicarPost("a", "a", "a").getStatus(), Status.OK.getStatusCode());
    }
    
    // hacer mockito
//	@Test
//	public void validarGetPisos() {
//		List<Piso> pisos = new ArrayList<Piso>();
//		pisos = controller.getPisos();
//		assertTrue(pisos.size() > 0);
//	}
//	
//	@Test
//	public void validarGetPosts() {
//		List<Post> posts = new ArrayList<Post>();
//		posts = controller.getPost();
//		assertTrue(posts.size() > 0);
//	}
}