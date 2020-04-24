package es.deusto.spq.data.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Piso;
import es.deusto.spq.data.PostTest;
import junit.framework.JUnit4TestAdapter;

public class PisoAssemblerTest {

	Piso piso;
	PisoDTO pisoDTO;
	PisoAssembler as;
	
	 public static junit.framework.Test suite() {
         return new JUnit4TestAdapter(PostTest.class);
     }

		
     @Before
     public void setUp() {
    	 piso.setCoste(50.0);   
    	 piso.setDesc("Piso bonito");
    	 piso.setLocalizacion("calle");
    	 piso.setnHab(2);
    	 piso.setNombre("Piso");
    	 piso.setNumeroInquilinos(3);
    	 piso.setValoracion(5);
    	 as = new PisoAssembler();
     }
     
     @Test
     public void assembleTest(){
    	
    	pisoDTO = as.assemble(piso);
    	
    	assertEquals(pisoDTO.getNombre(), piso.getNombre()); 
    	 
     }
}
