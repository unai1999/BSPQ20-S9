package es.deusto.spq.server;




public class DAOFactory{

    private static DAOFactory instance;

    private UsuarioDAO usuarioDAO;
    private ForoDAO foroDAO;
    private PisoDAO pisoDAO;
    private MensajeDAO mensajeDAO;
    private PostDAO postDAO;

     
    public DAOFactory(){
        
        //usuarioDAO = new UsuarioDAO();
        //foroDAO = new ForoDAO();
        //pisoDAO = new PisoDAO();
        //mensajeDAO = new MensajeDAO();
        //postDAO = new PostDAO();
    }

    public static DAOFactory getInstance(){
        if(instance == null){
            instance = new DAOFactory(); 
        }
        return instance;      
    }
// Revisar este metodo crear instancia
//cambiar nombres
    public PisoDAO createPisoDAO(){

        if (pisoDAO == null){
            pisoDAO = new PisoDAO();
        }
        return pisoDAO;
    }

    
    public UsuarioDAO createUsuarioDAO(){

        if (usuarioDAO == null){
            usuarioDAO = new UsuarioDAO();
        }
        return usuarioDAO;
    }

    public PostDAO createPostDAO(){

        if (postDAO == null){
            postDAO = new PostDAO();
        }
        return postDAO;
    }

    public MensajeDAO createMensajeDAO(){

        if (mensajeDAO == null){
            mensajeDAO = new MensajeDAO();
        }
        return mensajeDAO;
    }

    public ForoDAO createForoDAO(){

        if (foroDAO == null){
            foroDAO = new ForoDAO();
        }
        return foroDAO;
    }

    

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public void setForoDAO(ForoDAO foroDAO) {
		this.foroDAO = foroDAO;
	}
	
	public void setPisoDAO(PisoDAO pisoDAO) {
		this.pisoDAO = pisoDAO;
	}
	
	public void setMensajeDAO(MensajeDAO mensajeDAO) {
		this.mensajeDAO = mensajeDAO;
	}
	
	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
	}

    
}