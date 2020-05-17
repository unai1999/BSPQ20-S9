package es.deusto.spq.server;

import es.deusto.spq.data.Usuario;

public class MeterDatosBaseDeDatos {
	
	public static void main(String[] args) {
		
		DAOFactory.getInstance().createPisoDAO().crearAlgunosDatos();
		DAOFactory.getInstance().createPostDAO().crearPosts();
		DAOFactory.getInstance().createUsuarioDAO().guardar(new Usuario("test","test"));
		

	}



	
}
