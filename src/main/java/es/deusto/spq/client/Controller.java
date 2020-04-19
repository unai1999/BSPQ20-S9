package es.deusto.spq.client;

import java.io.IOException;
import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.deusto.spq.data.Post;
import es.deusto.spq.data.Usuario;

public class Controller {

    private static Controller instance;

    private Client client;
    private WebTarget webTarget;
    //Usuario?

    public Controller() {

        String hostname;
        String port;
        Properties props = new Properties();
        
        try {
            props.load(Controller.class.getClassLoader().getResourceAsStream("server.properties"));
            hostname = props.getProperty("server.hostname");
            port = props.getProperty("server.port");
        } catch (IOException e) {
            System.out.println("ERROR INICIANDO SERVER");
            e.printStackTrace();
            hostname = props.getProperty("127.0.0.1");
            port = props.getProperty("8080");
        }
        

        client = ClientBuilder.newClient();
        webTarget = client.target(String.format("http://%s:%s/rest", hostname, port));

    }
    
    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public Response publicarPost(String titulo, String autor, String contenido){

         WebTarget publicarTarget = webTarget.path("pisos/foro/submit");
         Post post = new Post(titulo, autor, contenido);
         Entity<Post> entity = Entity.entity(post, MediaType.APPLICATION_JSON);
         Response response = publicarTarget.request().post(entity);
         return response;
         
    }

    public Response resetPassword(String user, String newPassword){
         WebTarget publicarTarget = webTarget.path("pisos/resetPassword");
         Entity<String> entity = Entity.entity(newPassword, MediaType.APPLICATION_JSON);
         Response response = publicarTarget.request().put(entity);
         return response;
    }
    
    public Response registrarUsuario(Usuario usuario) {
    	 WebTarget publicarTarget = webTarget.path("pisos/foro/submit");
         Entity<Usuario> entity = Entity.entity(usuario, MediaType.APPLICATION_JSON);
         Response response = publicarTarget.request().post(entity);
         return response;
    }
}