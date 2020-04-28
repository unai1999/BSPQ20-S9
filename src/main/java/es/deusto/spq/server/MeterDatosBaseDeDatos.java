package es.deusto.spq.server;

public class MeterDatosBaseDeDatos {
	
	public static void main(String[] args) {
		
		DAOFactory.getInstance().createPisoDAO().crearAlgunosDatos();
		DAOFactory.getInstance().createPostDAO().crearPosts();
		DAOFactory.getInstance().createUsuarioDAO().crearUsuario();
		

	}

}
