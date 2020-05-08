package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Usuario;

public class UsuarioDAOTest {
	
	UsuarioDAO usuarioDAO;
	Usuario u1;
	
	@Before
	public void setUp() {
		usuarioDAO = new UsuarioDAO();
		u1 = new Usuario("aa", "bb", "cc", "dd", "ee");
	}
	@Test 
	public void comprobarUsuarioDAO(){
		usuarioDAO.guardar(u1);
		//System.out.println(usuarioDAO.getUsuario(u1.getNickname()));
		assertEquals(u1.getNombre(), usuarioDAO.getUsuario(u1.getNickname()).getNombre());
		assertEquals(u1.getNombre(), usuarioDAO.getUsuarioFromEmail(u1.getEmail()).getNombre());
		usuarioDAO.actaulizarDatosUsuario("aa", "cc", "dd", "ee", "ff");
	}
    
}