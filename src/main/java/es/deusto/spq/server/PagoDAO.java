package es.deusto.spq.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.spq.data.Pago;

public class PagoDAO {
    
    private PersistenceManagerFactory pmf;
    private PersistenceManager pm;
    
    protected PagoDAO(){
        pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        pm = pmf.getPersistenceManager();
    }
    
    public void guardarPago(Object o) {
    	Transaction tx = pm.currentTransaction();
    	try {
			tx.begin();
			System.out.println(" * Guardando un objeto: " + o);
			pm.makePersistent(o);
			tx.commit();
		} catch (Exception e) {
			System.out.println(" $ Error guardando un objeto: " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
    }
    
    public List<Pago> getPagosByEmail(String email) {
    	List<Pago> pagos = new ArrayList<Pago>();
    	Transaction tx = pm.currentTransaction();
    	try {
			System.out.println(" * Retrieving an extent for Pago");
			tx.begin();
			Extent<Pago> extent = pm.getExtent(Pago.class, true);
			for (Pago p : extent) {
				if (p.getEmail().equals(email)) {
					pagos.add(p);
				}
			}
			tx.commit();
		} catch (Exception e) {
			System.out.println(" $ Error retrieving Pago: " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
    	return pagos;
    }

    
    
}