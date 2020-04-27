package es.deusto.spq.data.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Piso;

import junit.framework.JUnit4TestAdapter;

public class PisoAssemblerTest {

	Piso piso;
	PisoDTO pisoDTO;
	PisoDTO pisoDTO2;
	PisoAssembler as;
	PisoAssembler as2;
	
	 public static junit.framework.Test suite() {
         return new JUnit4TestAdapter(PisoAssemblerTest.class);
     }

		
     @Before
     public void setUp() {
    	 
    	 piso = new Piso();
    	 piso.setCoste(50.0);   
    	 piso.setDesc("Piso bonito");
    	 piso.setLocalizacion("calle");
    	 piso.setnHab(2);
    	 piso.setNombre("Piso");
    	 piso.setNumeroInquilinos(3);
    	 piso.setValoracion(5);
    	 
    	 as = new PisoAssembler();
    	 as2 = new PisoAssembler();
     }
     
     @Test
     public void assembleTest(){
    	
    	pisoDTO = as.assemble(piso);
    	
    	assertEquals(pisoDTO.getNombre(), piso.getNombre()); 
    	assertEquals(pisoDTO.getCoste(), piso.getCoste()); 
    	assertEquals(pisoDTO.getLocalizacion(), piso.getLocalizacion()); 
    	assertEquals(pisoDTO.getValoracion(), piso.getValoracion()); 
    	assertEquals(pisoDTO.getDesc(), piso.getDesc()); 
    	assertEquals(pisoDTO.getNumeroInquilinos(), piso.getNumeroInquilinos()); 
    	assertEquals(pisoDTO.getnHab(), piso.getnHab());

    	pisoDTO2 = as2.assemble(null);
    	assertEquals(pisoDTO2, null);
    	
     }
}
