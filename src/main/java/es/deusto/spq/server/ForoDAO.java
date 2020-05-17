package es.deusto.spq.server;


import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

public class ForoDAO {

    private PersistenceManagerFactory pmf;
    private PersistenceManager pm;
    
    protected ForoDAO(){
        pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        pm = pmf.getPersistenceManager();
	}
	
	public ForoDAO(String s){
		
	}

    public boolean guardar(Object o) {
		Transaction tx = pm.currentTransaction();
		boolean b = true;
    	try {
			tx.begin();
			System.out.println("  * Guardando un objeto: " + o);
			pm.makePersistent(o);
			tx.commit();
		} catch (Exception e) {
			System.out.println("  $ Error guardando un objeto: " + e.getMessage());
			b = false;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		return b;
    }
}