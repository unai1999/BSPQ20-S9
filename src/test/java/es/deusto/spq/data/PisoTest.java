package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
         return new JUnit4TestAdapter(PisoTest.class);
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
    	
    	 assertTrue(piso.getCoste() == 4.0);
    	 assertEquals("bb", piso.getDesc());
    	 assertTrue(piso.getId() == 1);
    	 assertTrue(piso.getImagenes().get(0).getId() == "1");
    	 assertEquals("cc", piso.getLocalizacion());
    	 assertTrue(piso.getnHab() == 3);
    	 assertEquals("cc", piso.getNombre());
    	 assertTrue(piso.getNumeroInquilinos() == 5);
    	 assertEquals("aa", piso.getPropiertario().getNombre());
    	 assertTrue(piso.getValoracion() == 3);
    	 assertEquals(true, piso.isAlquilado());
    	 assertEquals("Piso [alquilado=true, coste=4.0, id=1, localizacion=cc, nombre=cc, valoracion=3]",piso.toString());
    	 
    	 
    	 assertEquals("aa", piso2.getNombre());
    	 assertTrue(piso2.getCoste() == 3);
    	 
    	 
     }
}
