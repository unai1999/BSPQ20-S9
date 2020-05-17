package es.deusto.spq.client;


import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.deusto.spq.data.MensajePrivado;
import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Post;
import es.deusto.spq.data.Usuario;
import es.deusto.spq.data.dto.UsuarioLogin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyList;

import junit.framework.JUnit4TestAdapter;

public class ControllerTest {

    Controller controller;

    @Mock
    WebTarget webTarget, wt;

    @Mock
    Response response;

    List<Piso> pisos;
    List<Post> posts;
    List<MensajePrivado> mensajes;


    // public static junit.framework.Test suite() {
    //     return new JUnit4TestAdapter(ControllerTest.class);
    // }

    final Logger logger = LoggerFactory.getLogger(ControllerTest.class);

    @Before
    public void setUp(){
        
        controller = new Controller();

        
        

        Response mockResponse = mock(Response.class);
        when(mockResponse.getStatus()).thenReturn(200);

        wt = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        when(wt.request().post(any(Entity.class))).thenReturn(mockResponse);
        //when(wt.request(MediaType.APPLICATION_JSON).get(any(GenericType.class))).thenReturn(pisos);

        webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        controller.setWebTarget(webTarget);
        when(webTarget.path(anyString())).thenReturn(wt);
        
        
    }

    @Test
    public void publicarPostTest(){

        logger.debug("test");
        
    
        Response response = controller.publicarPost("titulo", "autor", "contenido");

        assertEquals(200, response.getStatus());
    }


    @Test
    public void resetPasswordTest(){

    
        Response response = controller.resetPassword("u", "p");

        assertEquals(200, response.getStatus());

    }


    @Test
    public void registrarUsuarioTest(){
        
    
        Usuario u = new Usuario("nickname", "nombre", "apellidos", "email", "pw1");
        Response response = controller.registrarUsuario(u);

        assertEquals(200, response.getStatus());
  
    }

    @Test
    public void guardarNuevoPisoTest(){
        
        Piso p = new Piso("nombre", 5.0);
        Response response = controller.guardarNuevoPiso(p);

        assertEquals(200, response.getStatus());
    }

    @Test
    public void loginTest(){

    
        Response response = controller.login("u", "p");

        assertEquals(200, response.getStatus());
    }


    @Test
    public void getPisosTest(){

        pisos = new ArrayList<Piso>();
        pisos.add(new Piso("nombre", 4.9));

        
        when(wt.request(MediaType.APPLICATION_JSON).get(any(GenericType.class))).thenReturn(pisos);
        webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        controller.setWebTarget(webTarget);
        when(webTarget.path(anyString())).thenReturn(wt);
        assertEquals(pisos, controller.getPisos());
    }

    
    @Test
    public void getPostTest(){

        posts = new ArrayList<Post>();
        posts.add(new Post());


        when(wt.request(MediaType.APPLICATION_JSON).get(any(GenericType.class))).thenReturn(posts);
        webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        controller.setWebTarget(webTarget);
        when(webTarget.path(anyString())).thenReturn(wt);
        assertEquals(posts, controller.getPost());
    }

    
    @Test
    public void getMensajesTest(){

        mensajes = new ArrayList<MensajePrivado>();
        mensajes.add(new MensajePrivado());

        when(wt.request(MediaType.APPLICATION_JSON).get(any(GenericType.class))).thenReturn(mensajes);
        webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        controller.setWebTarget(webTarget);
        when(webTarget.path(anyString())).thenReturn(wt);
        assertEquals(mensajes, controller.getMensajes("test"));
    }
    
    
    @Test
    public void enviarMensajeTest(){

        response = controller.enviarMensaje(new MensajePrivado());

        assertEquals(200, response.getStatus());
    }

}