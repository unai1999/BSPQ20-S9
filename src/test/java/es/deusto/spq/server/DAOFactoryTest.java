package es.deusto.spq.server;

import org.junit.Before;

public class DAOFactoryTest {
    
    DAOFactory df;

    @Before
    public void setUp(){
        df = DAOFactory.getInstance();
    }
    
}