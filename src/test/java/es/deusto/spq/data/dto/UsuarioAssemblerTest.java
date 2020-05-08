package es.deusto.spq.data.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


import es.deusto.spq.data.Usuario;
import junit.framework.JUnit4TestAdapter;

public class UsuarioAssemblerTest {
	
	
	Usuario usuario;
	Usuario u2;
	UsuarioDTO usuarioDTO;
	UsuarioDTO usuarioDTO2;
	UsuarioAssembler as;
	
	 public static junit.framework.Test suite() {
         return new JUnit4TestAdapter(UsuarioAssemblerTest.class);
     }

     @Before
     public void setUp() {
    	 usuario = new Usuario("Alvarfez", "Alvar", "Fern Vill", "opendeusto", "1234" );    
    	 as = new UsuarioAssembler();
     }
     
     @Test
     public void assembleTest(){
    	
    	usuarioDTO = as.assemble(usuario);
    	usuarioDTO.setPw2("aa");
    	usuarioDTO.setTienePiso(true);
    	
    	assertEquals(usuarioDTO.getNombre(), usuario.getNombre()); 
    	assertEquals(usuarioDTO.getNickname(), usuario.getNickname());
    	assertEquals(usuarioDTO.getApellidos(), usuario.getApellidos());
    	assertEquals(usuarioDTO.getEmail(), usuario.getEmail());
    	assertEquals(usuarioDTO.getPw1(), usuario.getPw1());
    	assertEquals(usuarioDTO.getPw2(), "aa");
    	assertEquals(true, usuarioDTO.isTienePiso());
    	
    	usuarioDTO2 = as.assemble(u2);
    	assertEquals(null, usuarioDTO2);
    	
     }

}
