package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.MensajePrivado;
import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Post;


//estos tests estan ignorados en el pom porque neceistan que el servidor esté funcionando
public class ControllerTestPerf {

    @Before
    public void setUp() {

    }

    @Test
    @PerfTest(invocations = 100, threads = 10)
    @Required(max = 120, average = 30)
    public void getPisosTestPerf() {

        
        List<Piso> pisos = new ArrayList<Piso>();
        pisos = Controller.getInstance().getPisos();

        assertTrue(pisos.size()>0);
        
    }

    @Test
    @PerfTest(invocations = 100, threads = 10)
    @Required(max = 120, average = 30)
    public void loginTestPerf(){

        Response r = Controller.getInstance().login("test", "test");

        assertEquals(200, r.getStatus());
        
    }
    
    @Test
    @PerfTest(invocations = 100, threads = 10)
    @Required(max = 120, average = 30)
    public void getPostTestPerf() {

        List<Post> posts = new ArrayList<Post>();
        posts = Controller.getInstance().getPost();

        assertTrue(posts.size()>0);
        
    }

    @Test
    @PerfTest(invocations = 100, threads = 10)
    @Required(max = 120, average = 30)
    public void getMensajesTestPerf(){

        List<MensajePrivado> mensajes = new ArrayList<MensajePrivado>();
        mensajes = Controller.getInstance().getMensajes("test");

        assertTrue(mensajes.size()>0);
    }
    
    
}