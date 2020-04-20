package es.deusto.spq.data.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.PostTest;
import es.deusto.spq.data.Usuario;
import junit.framework.JUnit4TestAdapter;

public class UsuarioAssemblerTest {
	
	
	Usuario usuario;
	UsuarioDTO usuarioDTO;
	UsuarioAssembler as;
	
	 public static junit.framework.Test suite() {
         return new JUnit4TestAdapter(PostTest.class);
     }

     @Before
     public void setUp() {
    	 usuario = new Usuario("Alvarfez", "Alvar", "Fern Vill", "opendeusto", "1234" );    
    	 as = new UsuarioAssembler();
     }
     
     @Test
     public void assembleTest(){
    	
    	usuarioDTO = as.assemble(usuario);
    	
    	assertEquals(usuarioDTO.getNombre(), usuario.getNombre()); 
    	 
     }

}
