package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.ComentarioPiso;
import es.deusto.spq.data.Piso;

/** Clase para comprobar que los comentarios de la base de datos se almacenan y obtienen correctamente
 * @author alvar
 *
 */
public class ComentarioPisoDAOTest {
	
	
	ComentarioPisoDAO comentarioDAO;
	Piso p1;
	ComentarioPiso comentarioPiso;
	List<ComentarioPiso> comentarios;
	String texto;
	@Before
	public void setUp() {
		comentarioDAO = new ComentarioPisoDAO();
		p1 = new Piso();
    	p1.setNombre("Piso Nuevo"); p1.setCoste(800.0); p1.setAlquilado(false);
    	p1.setLocalizacion("Bilbao"); p1.setValoracion(4);
    	p1.setNumeroInquilinos(4); p1.setnHab(3);
    	
		comentarioPiso = new ComentarioPiso(p1, "Prueba JTest");
		
		
	}
	
	@Test
	public void guardarTest() {
		comentarioDAO.guardarComentario(comentarioPiso);
		
		comentarios = comentarioDAO.getComentarios(p1);
		texto = "";
		
		for(ComentarioPiso c : comentarios) {
			if(c.getTexto().equals(comentarioPiso.getTexto())) {
				texto = c.getTexto();
			}
		}
		
		assertEquals(comentarioPiso.getTexto(), texto);
	}
}
