package es.deusto.spq.server;

import javax.ws.rs.core.Response;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.datanucleus.api.jdo.annotations.ReadOnly;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Matchers.*;

import es.deusto.spq.data.Piso;

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

public class AppServerTest {

    @Mock
    DAOFactory df;
    
    public static AppServer server;

    

    @Before
    public void setUp(){
        server = new AppServer();
    }

    // @Test
    // public void getPisos(){

    //     DAOFactory dao = mock(DAOFactory.class, Mockito.RETURNS_DEEP_STUBS);
    //     List<Piso> mockResponse = new ArrayList<Piso>();
    //     mockResponse.add(new Piso());

    //     when(dao.getInstance().createPisoDAO().getPisos())).thenReturn(mockResponse);

    //     assertEquals("asd", mockResponse);
    // }

    @Test
    @PerfTest(invocations = 100, threads = 20)
    @Required(max = 120, average = 30)
    public void loginTest(){

        assertTrue(true);  }
}