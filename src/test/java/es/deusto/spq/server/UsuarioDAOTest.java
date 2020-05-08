package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Usuario;

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
	
	@Test
	public void guardarTest() {
		uDAO.guardar(u);
		assertEquals(u, uDAO.getUsuarioFromEmail(u.getEmail()));
	}
}