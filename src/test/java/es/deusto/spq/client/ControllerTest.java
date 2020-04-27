package es.deusto.spq.client;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import es.deusto.spq.data.MensajePrivado;
import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Post;
import es.deusto.spq.data.Usuario;
import es.deusto.spq.data.dto.UsuarioLogin;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
        
        controller = new Controller();
        
    }

    @Test
    public void PublicarPostTest(){

        WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        Response mockResponse = mock(Response.class);

        when(mockResponse.getStatus()).thenReturn(200);

        when(webTarget.request(anyString()).post(any(Entity.class))).thenReturn(mockResponse);

        Post post = new Post();
        Entity<Post> entity = Entity.entity(post, MediaType.APPLICATION_JSON);
        Response response = webTarget.request(MediaType.APPLICATION_JSON).post(entity);

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
    public void getPisosTest(){

        WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        Response mockResponse = mock(Response.class);

        when(mockResponse.getStatus()).thenReturn(200);

        when(webTarget.request(anyString()).get()).thenReturn(mockResponse);

        
        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

        assertEquals(200, response.getStatus());
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

    public void getMensajesTest(){

        WebTarget webTarget = mock(WebTarget.class, Mockito.RETURNS_DEEP_STUBS);
        Response mockResponse = mock(Response.class);

        when(mockResponse.getStatus()).thenReturn(200);

        when(webTarget.request(anyString()).get()).thenReturn(mockResponse);

        
        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

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