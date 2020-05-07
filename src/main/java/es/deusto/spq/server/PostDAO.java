package es.deusto.spq.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.spq.data.Post;

public class PostDAO {

	 private PersistenceManagerFactory pmf;
	    private PersistenceManager pm;
	    
	    protected PostDAO(){
	        pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	        pm = pmf.getPersistenceManager();
	    }
	    
	    public void guardarPost(Object o) {
	    	Transaction tx = pm.currentTransaction();
	    	try {
				tx.begin();
				System.out.println("  * Guardando un post: " + o);
				pm.makePersistent(o);
				tx.commit();
			} catch (Exception e) {
				System.out.println("  $ Error guardando un post: " + e.getMessage());
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
			}
	    }
	    
	    public void crearPosts() {
	    	Post p1 = new Post("Buen piso en Bilbao", "Aitor", "El otro dia fui a un piso y me encanto. El piso tiene unas vistas preciosas");
	    	Post p2 = new Post("Desagradable estancia en Madrid", "Ander", "El fin de semana pasado estuve en una casa en Madrid y no me gustó nada");
	    	Post p3 = new Post("Bonitas vistas en el piso de Sevilla", "Aitor", "Estuve en un alojamiento hace dos semanas y me gusto. Las vistas que tenía eran preciosas");
	    	Post p4 = new Post("Recomiendo la casa de Bilbao", "Iñigo", "Recomiendo esta casa a la que fui hace unas semanas. Es un sitio muy acogedor");
	    	
	    	p1.setLikes(20);
	    	p2.setLikes(30);
	    	p3.setLikes(40);
	    	p4.setLikes(50);
	    	
	    	guardarPost(p1);
	    	guardarPost(p2);
	    	guardarPost(p3);
	    	guardarPost(p4);
	    }
	    
	    public List<Post> getPosts() {
	    	List<Post> posts = new ArrayList<Post>();
	    	Transaction tx = pm.currentTransaction();
	    	try {
				System.out.println(" * Retrieving an extent for Post.");
				tx.begin();
				Extent<Post> extent = pm.getExtent(Post.class, true);
				for (Post post : extent) {
					posts.add(post);
				}
				tx.commit();
			} catch (Exception e) {
				System.out.println(" $ Error retrieving Post: " + e.getMessage());
			} finally {
				if(tx != null && tx.isActive()) {
					tx.rollback();
				}
			}
	    	System.out.println(posts.size());
	    	return posts;
	    }
	    
	    public void closeConnection() {
	    	pmf.close();
	    }

}
