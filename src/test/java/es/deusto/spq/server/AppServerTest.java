package es.deusto.spq.server;

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

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

public class AppServerTest {

    @Mock
    Response mockResponse;
    

    @Mock
    PisoDAO pdao;
    @Mock
    PostDAO postDAO;
    @Mock
    MensajeDAO mensajeDAO;
    @Mock
    ForoDAO foroDAO;
    @Mock
    UsuarioDAO usuarioDAO;
    
    public static AppServer server;

    

    @Before
    public void setUp(){

        server = new AppServer();
        pdao = new PisoDAO("test");
        postDAO = new PostDAO("test");
        mensajeDAO = new MensajeDAO("test");
        foroDAO = new ForoDAO("test");
        usuarioDAO = new UsuarioDAO("test");

        mockResponse = mock(Response.class);
        when(mockResponse.getStatus()).thenReturn(200);

    }

    @Test
    public void getPisosTest(){

        List<Piso> pisos = new ArrayList<Piso>();
        pisos.add(new Piso("1",1.0));
        pisos.add(new Piso("2", 2.0));
        pisos.add(new Piso("3", 3.0));
        
         pdao = mock(PisoDAO.class, Mockito.RETURNS_DEEP_STUBS);
         when(pdao.getPisos()).thenReturn(pisos);

         DAOFactory.getInstance().setPisoDAO(pdao);

         assertEquals(pisos, server.getPisos());
    }

    @Test
    public void getPostsTest(){

        List<Post> posts = new ArrayList<Post>();
        posts.add(new Post());

        postDAO =  mock(PostDAO.class, Mockito.RETURNS_DEEP_STUBS);
        when(postDAO.getPosts()).thenReturn(posts);

         DAOFactory.getInstance().setPostDAO(postDAO);

         assertEquals(posts, server.getPosts());
    }

    @Test
    public void getMensajesTest(){

        List<MensajePrivado> mensajes = new ArrayList<MensajePrivado>();
        mensajes.add(new MensajePrivado());

        mensajeDAO = mock(MensajeDAO.class, Mockito.RETURNS_DEEP_STUBS);
        when(mensajeDAO.getMensaje(anyString())).thenReturn(mensajes);
        DAOFactory.getInstance().setMensajeDAO(mensajeDAO);
        assertEquals(mensajes, server.getMensajes("test"));
    }

    @Test
    public void getPisoTest(){

    }

    @Test
    public void crearPostTest(){

        foroDAO = mock(ForoDAO.class, Mockito.RETURNS_DEEP_STUBS);
        when(foroDAO.guardar(any(Post.class))).thenReturn(true);
        DAOFactory.getInstance().setForoDAO(foroDAO);

        assertEquals(mockResponse.getStatus(), server.crearPost(new Post()).getStatus());
    }

    @Test
    public void enviarMensaje(){
        
        mensajeDAO = mock(MensajeDAO.class, Mockito.RETURNS_DEEP_STUBS);
        when(mensajeDAO.guardar(any(MensajePrivado.class))).thenReturn(true);
        DAOFactory.getInstance().setMensajeDAO(mensajeDAO);

        assertEquals(server.enviarMensaje(new MensajePrivado()).getStatus(), mockResponse.getStatus());
    }

    @Test
    public void registrarUsuarioTest(){

        usuarioDAO = mock(UsuarioDAO.class, Mockito.RETURNS_DEEP_STUBS);
        when(usuarioDAO.guardar(any(Usuario.class))).thenReturn(true);
        DAOFactory.getInstance().setUsuarioDAO(usuarioDAO);

        assertEquals(server.registrarUsuario(new Usuario("nickname", "nombre", "apellidos", "email", "pw1")).getStatus(), mockResponse.getStatus());

    }

    @Test
    public void actualizarPasswordTest(){
        usuarioDAO = mock(UsuarioDAO.class, Mockito.RETURNS_DEEP_STUBS);
        when(usuarioDAO.actualizarPassword(anyString(),anyString())).thenReturn(true);
        DAOFactory.getInstance().setUsuarioDAO(usuarioDAO);

        assertEquals(server.registrarUsuario(new Usuario("nickname", "nombre", "apellidos", "email", "pw1")).getStatus(), mockResponse.getStatus());
    }

  
    
    
    @Test
    public void loginTest(){
        Usuario u = new Usuario("nickname", "nombre", "apellidos", "email", "pw1");
        usuarioDAO = mock(UsuarioDAO.class, Mockito.RETURNS_DEEP_STUBS);
        when(usuarioDAO.getUsuario(anyString())).thenReturn(u);
        DAOFactory.getInstance().setUsuarioDAO(usuarioDAO);

        assertEquals(server.login(new UsuarioLogin("nickname", "")).getStatus(), 400);

    }

    @Test
    public void guardarPisoTest(){
        pdao = mock(PisoDAO.class, Mockito.RETURNS_DEEP_STUBS);
        when(pdao.guardar(any(Piso.class))).thenReturn(true);
        DAOFactory.getInstance().setPisoDAO(pdao);

        assertEquals(server.guardarPiso(new Piso()).getStatus(), mockResponse.getStatus());
    }

    // @Test
    // @PerfTest(invocations = 100, threads = 20)
    // @Required(max = 120, average = 30)
    // public void loginTest(){

    //     assertTrue(true);  }
}