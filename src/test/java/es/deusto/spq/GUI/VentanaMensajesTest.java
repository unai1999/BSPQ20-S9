package es.deusto.spq.GUI;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import es.deusto.spq.data.Mensaje;
import es.deusto.spq.data.Usuario;

public class VentanaMensajesTest {

	
	@Test
	public void comprobarVentana() {
	
		
		Mensaje m = new Mensaje("1", "Titulo", "Cuerpo");
		
		ArrayList<Mensaje> mensajes = new ArrayList<>();
		mensajes.add(m);
		Usuario user = new Usuario("Nombre", "pw");
		user.setMensajes(mensajes);
		
		VentanaMensajes v1 = new VentanaMensajes(user);
		
		assertTrue(v1 != null);
	}
}
