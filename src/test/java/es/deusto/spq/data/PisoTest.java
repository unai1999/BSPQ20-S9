package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;

public class PisoTest {
	
	 Piso piso;
	 Piso piso2;
	 Imagen i;
	 Propietario p;

     public static junit.framework.Test suite() {
         return new JUnit4TestAdapter(PostTest.class);
     }

     @Before
     public void setUp() {
    	 i = new Imagen("1","url");
    	 List<Imagen> imagenes = new ArrayList<Imagen>();
    	 imagenes.add(i);
    	 piso = new Piso();
    	 piso.setAlquilado(true);
    	 piso.setCoste(4.0);
    	 piso.setDesc("bb");
    	 piso.setId(1);
    	 piso.setImagenes(imagenes);
    	 piso.setLocalizacion("cc");
    	 piso.setnHab(3);
    	 piso.setNombre("cc");
    	 piso.setNumeroInquilinos(5);
    	 p = new Propietario("aa", "aa", "aa", "aa", "aa");
    	 piso.setPropiertario(p);
    	 piso.setValoracion(3);
    	 
    	 piso2 = new Piso("aa", 3.0);	 
     }
     
     @Test
     public void comprobarPiso() {
    	 assertEquals("4.0", piso.getCoste());
    	 assertEquals("bb", piso.getDesc());
    	 assertEquals("1", piso.getId());
    	 assertEquals("1", piso.getImagenes().get(0).getId());
    	 assertEquals("cc", piso.getLocalizacion());
    	 assertEquals("5", piso.getInquilinos().size());
    	 assertEquals("3", piso.getnHab());
    	 assertEquals("cc", piso.getNombre());
    	 assertEquals("5", piso.getNumeroInquilinos());
    	 assertEquals("aa", piso.getPropiertario().getNombre());
    	 assertEquals("3", piso.getValoracion());
    	 assertEquals(true, piso.isAlquilado());
    	 
    	 assertEquals("aa", piso2.getNombre());
    	 assertEquals("3.0", piso2.getCoste());
    	 
     }
}
