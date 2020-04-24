package es.deusto.spq.server;


public class DAOFactory{

    private static DAOFactory instance = new DAOFactory();
    private DAOFactory(){

    }
    public static DAOFactory getInstance(){
        return instance;
    }
// Revisar este metodo crear instancia
    public PisoDAO createPisoDAO(){

        return new PisoDAO();

    }

    public ForoDAO createForoDAO(){

        return new ForoDAO();
    }
    
    public UsuarioDAO createUsuarioDAO(){

        return new UsuarioDAO();
    }
    public PostDAO createPostDAO(){

        return new PostDAO();
    }
}