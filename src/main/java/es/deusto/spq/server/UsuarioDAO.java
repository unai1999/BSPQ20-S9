package es.deusto.spq.server;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.spq.data.Usuario;

public class UsuarioDAO {

	 private PersistenceManagerFactory pmf;
	    private PersistenceManager pm;
	    
	    protected UsuarioDAO(){
	        pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	        pm = pmf.getPersistenceManager();
	    }
	    
	    public Usuario getUsuario(String nick) {
	    	Usuario usuario = null;
	    	Transaction tx = pm.currentTransaction();
	    	try {
				tx.begin();
				Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
				for (Usuario u : extent) {
					if (u.getNickname().equals(nick)){
						usuario = u;
						break;
					}
				}
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (tx != null && tx.isActive()) {
		    		tx.rollback();
		    	}
	    	return usuario;
			}
	    }
	    
	    public void guardar(Object o) {
	    	Transaction tx = pm.currentTransaction();
	    	try {
				tx.begin();
				System.out.println("  * Guardando un objeto: " + o);
				pm.makePersistent(o);
				tx.commit();
			} catch (Exception e) {
				System.out.println("  $ Error guardando un objeto: " + e.getMessage());
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
			}
	    }
}
