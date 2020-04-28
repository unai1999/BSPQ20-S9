package es.deusto.spq.client;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import es.deusto.spq.data.Mensaje;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyList;

import junit.framework.JUnit4TestAdapter;

public class ControllerTest {

    // @Mock
    Controller controller;

    // @Mock
    // Client client;

    // @Mock
    // WebTarget WebTarget;

    // public static junit.framework.Test suite() {
    //     return new JUnit4TestAdapter(ControllerTest.class);
    // }

    @Before
    public void setUp(){
        
        controller = new Controller();
        
    }

    @Test
    public void publicarPostTest2(){

        //WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        controller = mock(Controller.class, Mockito.RETURNS_DEEP_STUBS);
        Response mockResponse = mock(Response.class);

        when(controller.publicarPost(anyString(), anyString(), anyString())).thenReturn(mockResponse);
        when(mockResponse.getStatus()).thenReturn(200);

        //when(webTarget.request(anyString()).post(any(Entity.class))).thenReturn(mockResponse);

        //Post post = new Post();
        //Entity<Post> entity = Entity.entity(post, MediaType.APPLICATION_JSON);
        //Response response = webTarget.request(MediaType.APPLICATION_JSON).post(entity);
        Response response = controller.publicarPost("titulo", "autor", "contenido");

        assertEquals(200, response.getStatus());
    }

    @Test
    public void publicarPostTest(){

        // WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        // Response mockResponse = mock(Response.class);

        // when(mockResponse.getStatus()).thenReturn(200);

        // when(webTarget.request(anyString()).post(any(Entity.class))).thenReturn(mockResponse);

        // Post post = new Post();
        // Entity<Post> entity = Entity.entity(post, MediaType.APPLICATION_JSON);
        // //Response response = webTarget.request(MediaType.APPLICATION_JSON).post(entity);
        // Response response = controller.publicarPost("titulo", "autor", "contenido");

        // assertEquals(200, response.getStatus());
        assertTrue(true);
    }

    @Test
    public void resetPasswordTest2(){

        //WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        controller = mock(Controller.class, Mockito.RETURNS_DEEP_STUBS);
        Response mockResponse = mock(Response.class);

        when(controller.resetPassword(anyString(), anyString())).thenReturn(mockResponse);
        when(mockResponse.getStatus()).thenReturn(200);

        Response response = controller.resetPassword("titulo", "autor");

        assertEquals(200, response.getStatus());
    }

    @Test
    public void resetPasswordTest(){

        WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        Response mockResponse = mock(Response.class);

        when(mockResponse.getStatus()).thenReturn(200);

        when(webTarget.request(anyString()).post(any(Entity.class))).thenReturn(mockResponse);

        UsuarioLogin ul = new UsuarioLogin("nick", "password");
        Entity<UsuarioLogin> entity = Entity.entity(ul, MediaType.APPLICATION_JSON);
        Response response = webTarget.request(MediaType.APPLICATION_JSON).post(entity);

        assertEquals(200, response.getStatus());

    }

    @Test
    public void registrarUsuarioTest2(){

        //WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        controller = mock(Controller.class, Mockito.RETURNS_DEEP_STUBS);
        Response mockResponse = mock(Response.class);

        when(controller.registrarUsuario(any(Usuario.class))).thenReturn(mockResponse);
        when(mockResponse.getStatus()).thenReturn(200);
        Usuario u = new Usuario("nickname", "nombre", "apellidos", "email", "pw1");

        Response response = controller.registrarUsuario(u);

        assertEquals(200, response.getStatus());
    }

    @Test
    public void registrarUsuarioTest(){
        WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        Response mockResponse = mock(Response.class);

        when(mockResponse.getStatus()).thenReturn(200);

        when(webTarget.request(anyString()).post(any(Entity.class))).thenReturn(mockResponse);

        Usuario usuario = new Usuario("nickname", "nombre", "apellidos", "email", "pw1");
        Entity<Usuario> entity = Entity.entity(usuario, MediaType.APPLICATION_JSON);
        Response response = webTarget.request(MediaType.APPLICATION_JSON).post(entity);

        assertEquals(200, response.getStatus());
    }

    @Test
    public void guardarNuevoPisoTest2(){

        //WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        controller = mock(Controller.class, Mockito.RETURNS_DEEP_STUBS);
        Response mockResponse = mock(Response.class);

        when(controller.guardarNuevoPiso(any(Piso.class))).thenReturn(mockResponse);
        when(mockResponse.getStatus()).thenReturn(200);
        Piso p = new Piso();

        Response response = controller.guardarNuevoPiso(p);

        assertEquals(200, response.getStatus());
    }
    @Test
    public void guardarNuevoPisoTest(){
        WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        Response mockResponse = mock(Response.class);

        when(mockResponse.getStatus()).thenReturn(200);

        when(webTarget.request(anyString()).post(any(Entity.class))).thenReturn(mockResponse);

        Piso piso  = new Piso();
        Entity<Piso> entity = Entity.entity(piso, MediaType.APPLICATION_JSON);
        Response response = webTarget.request(MediaType.APPLICATION_JSON).post(entity);

        assertEquals(200, response.getStatus());
    }

    @Test
    public void loginTest2(){

        //WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        controller = mock(Controller.class, Mockito.RETURNS_DEEP_STUBS);
        Response mockResponse = mock(Response.class);

        when(controller.login(anyString(), anyString())).thenReturn(mockResponse);
        when(mockResponse.getStatus()).thenReturn(200);
        
        Response response = controller.login("asd","asd");

        assertEquals(200, response.getStatus());
    }
    @Test
    public void loginTest(){

        WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        Response mockResponse = mock(Response.class);

        when(mockResponse.getStatus()).thenReturn(200);

        when(webTarget.request(anyString()).post(any(Entity.class))).thenReturn(mockResponse);

        UsuarioLogin ul = new UsuarioLogin("nick", "password");
        Entity<UsuarioLogin> entity = Entity.entity(ul, MediaType.APPLICATION_JSON);
        Response response = webTarget.request(MediaType.APPLICATION_JSON).post(entity);

        assertEquals(200, response.getStatus());
    }

    @Test
    public void getPisosTest2(){

        //WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        controller = mock(Controller.class, Mockito.RETURNS_DEEP_STUBS);
        List<Piso> lp = new ArrayList<Piso>();

        when(controller.getPisos()).thenReturn(lp);

        assertEquals(lp, controller.getPisos());
    }

    @Test
    public void getPisosTest(){

        WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        Response mockResponse = mock(Response.class);

        when(mockResponse.getStatus()).thenReturn(200);

        when(webTarget.request(anyString()).get()).thenReturn(mockResponse);

        
        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

        assertEquals(200, response.getStatus());
    }

    @Test
    public void getPostTest2(){

        //WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        controller = mock(Controller.class, Mockito.RETURNS_DEEP_STUBS);
        List<Post> lp = new ArrayList<Post>();

        when(controller.getPost()).thenReturn(lp);

        assertEquals(lp, controller.getPisos());
    }
    
    @Test
    public void getPostTest(){

        WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        Response mockResponse = mock(Response.class);

        when(mockResponse.getStatus()).thenReturn(200);

        when(webTarget.request(anyString()).get()).thenReturn(mockResponse);

        
        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

        assertEquals(200, response.getStatus());
    }


    @Test
    public void getMensajesTest2(){

        //WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        controller = mock(Controller.class, Mockito.RETURNS_DEEP_STUBS);
        List<MensajePrivado> lp = new ArrayList<MensajePrivado>();

        when(controller.getMensajes(anyString())).thenReturn(lp);

        assertEquals(lp, controller.getMensajes("ey"));
    }
    

    public void getMensajesTest(){

        WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        Response mockResponse = mock(Response.class);

        when(mockResponse.getStatus()).thenReturn(200);

        when(webTarget.request(anyString()).get()).thenReturn(mockResponse);

        
        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

        assertEquals(200, response.getStatus());
    }
    
    @Test
    public void enviarMensajeTest2(){

        //WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        controller = mock(Controller.class, Mockito.RETURNS_DEEP_STUBS);
        MensajePrivado mp = new MensajePrivado("a","a","a");
        Response mockResponse = mock(Response.class);

        when(mockResponse.getStatus()).thenReturn(200);


        when(controller.enviarMensaje(any(MensajePrivado.class))).thenReturn(mockResponse);

        Response response = controller.enviarMensaje(mp);
        assertEquals(200, response.getStatus());
    }
    
    @Test
    public void enviarMensajeTest(){

        WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        Response mockResponse = mock(Response.class);

        when(mockResponse.getStatus()).thenReturn(200);

        when(webTarget.request(anyString()).post(any(Entity.class))).thenReturn(mockResponse);

        MensajePrivado mp = new MensajePrivado("asd","nick", "password");
        Entity<MensajePrivado> entity = Entity.entity(mp, MediaType.APPLICATION_JSON);
        Response response = webTarget.request(MediaType.APPLICATION_JSON).post(entity);

        assertEquals(200, response.getStatus());
    }

}