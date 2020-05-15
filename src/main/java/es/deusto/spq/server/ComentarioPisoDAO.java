package es.deusto.spq.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.spq.data.ComentarioPiso;
import es.deusto.spq.data.Piso;

public class ComentarioPisoDAO {

	
	 	private PersistenceManagerFactory pmf;
	    private PersistenceManager pm;
	    
	    /** Constructor de la clase ComentarioPisoDAO
	     * 
	     */
	    protected ComentarioPisoDAO(){
	        pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	        pm = pmf.getPersistenceManager();
	    }
	   
	    /** Metodo para almacenar comentarios en la base de datos
	     * @param o
	     */
	    public void guardarComentario(Object o) {
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
	    
	   
	    /** Metodo para obtener los comentarios de las bases de datos
	     * @param piso	del que queremos obtener los comentarios
	     * @return Lista de comentarios
	     */
	    public List<ComentarioPiso> getComentarios(Piso piso) {
	    	List<ComentarioPiso> comentarios = new ArrayList<ComentarioPiso>();
	    	Transaction tx = pm.currentTransaction();
	    	try {
				System.out.println(" * Retrieving an extent for ComentarioPiso");
				tx.begin();
				Extent<ComentarioPiso> extent = pm.getExtent(ComentarioPiso.class, true);
				for (ComentarioPiso c : extent) {
					if(c.getPiso().getNombre().equals(piso.getNombre())) {
						comentarios.add(c);
					}
				}
				tx.commit();
			} catch (Exception e) {
				System.out.println(" $ Error retrieving ComentarioPiso: " + e.getMessage());
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
			}
	    	return comentarios;
	    }

	    
}
