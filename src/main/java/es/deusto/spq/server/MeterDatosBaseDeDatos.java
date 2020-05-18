package es.deusto.spq.server;

import es.deusto.spq.client.Controller;
import es.deusto.spq.data.Factura;
import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Usuario;

public class MeterDatosBaseDeDatos {
	
	public static void main(String[] args) {
		
		DAOFactory.getInstance().createPisoDAO().crearAlgunosDatos();
		DAOFactory.getInstance().createPostDAO().crearPosts();
		Usuario u = new Usuario("test", "test");
		DAOFactory.getInstance().createUsuarioDAO().guardar(u);
		// Piso p = new Piso("nombre", 100.0);
		// DAOFactory.getInstance().createPisoDAO().guardar(p);
		// Factura f = new Factura("fecha", p, new Usuario("nickname", "p"), new Usuario("a","p"));
		// DAOFactory.getInstance().createPisoDAO().guardar(f);

	}



	
}
