package es.deusto.spq.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.spq.data.ComentarioPost;
import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Post;

/**	Clase para guardar los comentarios en la base de datos
 * @author alvar
 *
 */
public class ComentarioPostDAO {

	private PersistenceManagerFactory pmf;
    private PersistenceManager pm;
    
    /**	Constructor de la clase ComentarioPostDAO
     * 
     */
    protected ComentarioPostDAO(){
        pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        pm = pmf.getPersistenceManager();
    }
   
   
    /** Metodo para guardar en la base de datos los comentarios de los posts
     * @param o objeto a guardar
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
    
   
    /** Query para obtener comentarios de la base de datos
     * @param piso	del que se desea obtener los comentarios
     * @return
     */
    public List<ComentarioPost> getComentarios(Post post) {
    	List<ComentarioPost> comentarios = new ArrayList<ComentarioPost>();
    	Transaction tx = pm.currentTransaction();
    	try {
			System.out.println(" * Retrieving an extent for ComentarioPiso");
			tx.begin();
			Extent<ComentarioPost> extent = pm.getExtent(ComentarioPost.class, true);
			for (ComentarioPost c : extent) {
				if(c.getPost().getTitulo().equals(post.getTitulo())) {
					
					comentarios.add(c);
				}
				
			}
			tx.commit();
		} catch (Exception e) {
			System.out.println(" $ Error retrieving ComentarioPost: " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
    	return comentarios;
    }

    
}
