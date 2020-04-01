package es.deusto.spq.server;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.spq.data.Piso;

public class PisoDAO{

    private PersistenceManagerFactory pmf;

    protected PisoDAO(){

        pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    }

    public Piso getPiso(long id){

        Piso piso = null;

        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        try {
            tx.begin();
            Extent<Piso> extent = pm.getExtent(Piso.class, true);
            for(Piso p : extent){
                if(piso.getId() == (id)){
                    piso = p;
                    break;
                }
            }

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (tx != null && tx.isActive()){
                tx.rollback();
            }
            pm.close();
        }
        
        return piso;
    }
}