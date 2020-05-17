package es.deusto.spq.server;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Piso;
import es.deusto.spq.data.ComentarioPost;
import es.deusto.spq.data.MensajePrivado;
import es.deusto.spq.data.Usuario;

public class MensajeDAOTest {

	 MensajeDAO mensajeDAO1;
	 MensajePrivado m1;
	 List<MensajePrivado> mensajes;
	 String contenido;
	    @Before
	    public void setUp(){

	        mensajeDAO1 = new MensajeDAO();
	        m1 = new MensajePrivado();
	    	m1.setContenido("aaaaaa");m1.setDestino("Destino");m1.setOrigen("Origen");
	    }



	    @Test
	    public void guardarTest(){
	    	mensajeDAO1.guardar(m1);
			
			mensajes = mensajeDAO1.getMensaje("eneko98");
			contenido = "aaaaaa";
			
			for(MensajePrivado m : mensajes) {
				if(m.getContenido().equals(m1.getContenido())) {
					contenido = m.getContenido();
				}
			}
			
			assertEquals(m1.getContenido(), contenido);
	    }

}
