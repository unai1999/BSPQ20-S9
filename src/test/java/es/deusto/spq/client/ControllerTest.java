package es.deusto.spq.client;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
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
}