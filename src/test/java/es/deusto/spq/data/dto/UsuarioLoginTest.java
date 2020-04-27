package es.deusto.spq.data.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UsuarioLoginTest {
	
	UsuarioLogin u1;
	UsuarioLogin u2;
	

	@Before
	public void setUp() {
		u1 = new UsuarioLogin("aa", "bb");
		u2 = new UsuarioLogin("aa", "bb");
		u2.setNick("cc");
		u2.setPassword("dd");
		
	}
	
	@Test
	public void usuarioLoginTest() {
		assertEquals("aa", u1.getNick());
		assertEquals("bb", u1.getPassword());
		assertEquals("cc", u2.getNick());
		assertEquals("dd", u2.getPassword());
		
		assertEquals("UsuarioLogin [nick=aa, password=bb]", u1.toString());
		
	}

}
