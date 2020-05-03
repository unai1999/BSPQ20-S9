package es.deusto.spq.server;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

public class PagoDAO {
    
    private PersistenceManagerFactory pmf;
    private PersistenceManager pm;
    
    protected PagoDAO(){
        pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        pm = pmf.getPersistenceManager();
    }

    
    
}