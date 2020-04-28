//package es.deusto.spq.GUI;
//
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import es.deusto.spq.client.Controller;
//import es.deusto.spq.data.MensajePrivado;
//import es.deusto.spq.data.Usuario;
//
//public class VentanaMensajesTest {
//	
//
//	
//	@Test
//	public void comprobarVentana() {
//		Usuario u1 = new Usuario("aa", "bb");
//		Controller.getInstance().setUsuario(u1);	
//		MensajePrivado m = new MensajePrivado("1", "Titulo", "Cuerpo");
//		
//		ArrayList<MensajePrivado> mensajes = new ArrayList<>();
//		mensajes.add(m);
//		Usuario user = new Usuario("Nombre", "pw");
//		user.setMensajes(mensajes);
//		VentanaMensajes v1 = new VentanaMensajes(user);
//		
//		assertTrue(v1 != null);
//		assertTrue(true);
//	}
//}
