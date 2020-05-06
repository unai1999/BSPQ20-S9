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
			}
			return usuario;
		}

		public Usuario getUsuarioFromEmail(String email) {
	    	Usuario usuario = null;
	    	Transaction tx = pm.currentTransaction();
	    	try {
				tx.begin();
				Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
				for (Usuario u : extent) {
					if (u.getEmail().equals(email)){
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
			}
			return usuario;
		}
		
		public Usuario getUsuarioFromId(String nick) {
	    	Usuario usuario = null;
	    	Transaction tx = pm.currentTransaction();
	    	try {
				tx.begin();
				usuario = pm.getObjectById(Usuario.class, nick);
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (tx != null && tx.isActive()) {
		    		tx.rollback();
		    	}
			}
			return usuario;
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
//		public void crearUsuario() {
//			Usuario u1 = new Usuario("Iñi", "Iñigo", "Lopez", "lpezinigo@gmail.com", "12345678");
//			guardar(u1);
//		}
		public void actualizarPassword(String email, String newPassword){

			Usuario u = getUsuarioFromEmail(email);
			
			Transaction tx = pm.currentTransaction();
	    	try {
				tx.begin();
				System.out.println("  * Guardando un objeto: " + u);
				u.setPw1(newPassword);
				pm.makePersistent(u);
				tx.commit();
			} catch (Exception e) {
				System.out.println("  $ Error guardando un objeto: " + e.getMessage());
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
			}

		}
		public void actaulizarDatosUsuario(String nick, String nombre, String apellidos, String email, String password) {
			
			Usuario u1 = getUsuario(nick);
			Transaction tx = pm.currentTransaction();

	    	try {
				tx.begin();
				System.out.println("  * Editando los datos del usuario: " + u1);
				u1.setNombre(nombre);
				u1.setApellidos(apellidos);
				u1.setEmail(email); //no se guarda el email
				u1.setPw1(password);
				pm.makePersistent(u1);
				tx.commit();
			} catch (Exception e) {
				System.out.println("  $ Error editando los datos de usuario: " + e.getMessage());
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
			}
			
		}
		
		public void realizarPago(int precio, String email) {
			
			Usuario u = getUsuarioFromEmail(email);
			Transaction tx = pm.currentTransaction();
			try {
				tx.begin();
				System.out.println(" * Comprobando monedero...");
				if (u.pagar(precio) == true) {
					System.out.println(" * Realizando pago...");
					pm.makePersistent(u);
					tx.commit();
				}
			} catch (Exception e) {
				System.out.println(" $ Error en el pago: " + e.getMessage());
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
			}
		}
		
		public void anyadirFondos(String email, int cantidad) {
			
			Usuario u = getUsuarioFromEmail(email);
			Transaction tx = pm.currentTransaction();
			try {
				tx.begin();
				System.out.println(" * Añadiendo fondos...");
				u.setMonedero(u.getMonedero() + cantidad);
				pm.makePersistent(u);
				tx.commit();
			} catch (Exception e) {
				System.out.println(" $ Error añadiendo fondos: " + e.getMessage());
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
			}
		}
}
