package es.deusto.spq.server;
import es.deusto.spq.server.PisoDAO;

public class DAOFactory{

    private static DAOFactory instance = new DAOFactory();
    private DAOFactory(){

    }
    public static DAOFactory getInstance(){
        return instance;
    }

    public PisoDAO createPisoDAO(){

        return new PisoDAO();

    }

    public ForoDAO createForoDAO(){

        return new ForoDAO();
    }
}