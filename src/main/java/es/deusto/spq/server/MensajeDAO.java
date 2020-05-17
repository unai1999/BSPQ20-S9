package es.deusto.spq.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.spq.data.MensajePrivado;

public class MensajeDAO {

    private PersistenceManagerFactory pmf;
    private PersistenceManager pm;
    
    protected MensajeDAO(){
        pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        pm = pmf.getPersistenceManager();
	}
	
	public MensajeDAO(String s){
		
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

    public List<MensajePrivado> getMensaje(String usuario) {
    	List<MensajePrivado> mensajes = new ArrayList<MensajePrivado>();
    	Transaction tx = pm.currentTransaction();
    	try {
			System.out.println(" * Retrieving an extent for Piso.");
			tx.begin();
			Extent<MensajePrivado> extent = pm.getExtent(MensajePrivado.class, true);
			for (MensajePrivado m : extent) {
                if(m.getDestino().equals(usuario)){
                    mensajes.add(m);
                }
                
			}
			tx.commit();
		} catch (Exception e) {
			System.out.println(" $ Error retrieving Piso: " + e.getMessage());
		} finally {
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
    	return mensajes;
    }

}