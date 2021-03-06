package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Usuario;

/**
 * Clase que testea el correcto guardado de un usuario en la base de datos
 * @author jonuraga
 *
 */
public class UsuarioDAOTest {
	
	UsuarioDAO uDAO;
	Usuario u;
	
	@Before
	public void setUp() {
		uDAO = new UsuarioDAO();
		u = new Usuario();
		u.setNickname("jonuraga"); u.setEmail("aa@gmail.com"); u.setNombre("Jon"); u.setApellidos("Uraga Escapa");
		u.setPw1("12345678"); u.setTienePiso(false);
		
		
	}
	
	/**
	 * Test del método que guarda un usuario en la base de datos
	 */
	@Test
	public void guardarTest() {
		uDAO.guardar(u);
		assertEquals(u.getNombre(), uDAO.getUsuarioFromEmail(u.getEmail()).getNombre());
		assertEquals(u.getNombre(), uDAO.getUsuario(u.getNickname()).getNombre());
	}
}