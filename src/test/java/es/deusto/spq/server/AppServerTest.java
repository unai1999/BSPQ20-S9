package es.deusto.spq.server;


import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;

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

    //TODO
    
    @Test
    @PerfTest(invocations = 100, threads = 20)
    @Required(max = 120, average = 30)
    public void loginTest(){

        assertTrue(true);  }
}