package es.deusto.spq.server;




public class DAOFactory{

    private static DAOFactory instance;

  
    private UsuarioDAO usuarioDAO;
    private ForoDAO foroDAO;
    private PisoDAO pisoDAO;
    private MensajeDAO mensajeDAO;
    private PostDAO postDAO;
    private ComentarioPisoDAO comentarioPisoDAO;
    private ComentarioPostDAO comentarioPostDAO;
     
    private DAOFactory(){
        
        usuarioDAO = new UsuarioDAO();
        foroDAO = new ForoDAO();
        pisoDAO = new PisoDAO();
        mensajeDAO = new MensajeDAO();
        postDAO = new PostDAO();
        comentarioPisoDAO = new ComentarioPisoDAO();
        comentarioPostDAO = new ComentarioPostDAO();
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

        return pisoDAO;
    }

    public ForoDAO createForoDAO(){

        return foroDAO;
    }
    
    public UsuarioDAO createUsuarioDAO(){

        return usuarioDAO;
    }

    public PostDAO createPostDAO(){

        return postDAO;
    }

    public MensajeDAO createMensajeDAO(){

        return mensajeDAO;
    }
    public ComentarioPisoDAO createComentarioPisoDAO() {
    	
    	return comentarioPisoDAO;
    }
    
    public ComentarioPostDAO createComentarioPostDAO() {
    	
    	return comentarioPostDAO;
    }
}