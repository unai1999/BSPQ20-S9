package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;

public class MensajePrivadoTest {

	
	MensajePrivado m1;
	

    @Before
    public void setUp() {
    	
   	 m1 = new MensajePrivado();
   	 
   	 m1.setContenido("Este contenido es para un test");
   	 m1.setOrigen("aa");;
   	 m1.setDestino("bb"); 	 
    }
    
    @Test
    public void comprobarPiso() {
   	
   	 
   	 assertEquals("bb", m1.getDestino());
   	 assertEquals("aa",m1.getOrigen());
   	
   	 assertEquals("Este contenido es para un test", m1.getContenido());
   
   	
   	 
   	 
    }
}
