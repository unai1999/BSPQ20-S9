package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Piso;

public class PisoDAOTest {
    
    PisoDAO pisoDAO;
    PisoDAO pisoDAO2;
    Piso p1, p2;
    @Before
    public void setUp(){

        pisoDAO = new PisoDAO();
        pisoDAO2 = new PisoDAO();
        p1 = new Piso();
    	p1.setNombre("Piso 1"); p1.setCoste(800.0); p1.setAlquilado(false);
    	p1.setLocalizacion("Bilbao"); p1.setValoracion(4);
    	p1.setNumeroInquilinos(4); p1.setnHab(3);
        p2 = new Piso();
    	p2.setNombre("Piso 2"); p2.setCoste(800.0); p2.setAlquilado(true);
    	p2.setLocalizacion("Madrid"); p2.setValoracion(3);
    	p2.setNumeroInquilinos(2); p2.setnHab(2);
    }



    @Test
    public void guardarTest(){
        pisoDAO.guardar(p1);
        pisoDAO2.guardar(p2);
        assertEquals(p1, pisoDAO.getPisoByIdBien(p1.getId()));
        assertEquals(p2.getLocalizacion(), pisoDAO2.getPisoByNombre(p2.getNombre()).getLocalizacion());
        pisoDAO2.crearAlgunosDatos();
    }

}