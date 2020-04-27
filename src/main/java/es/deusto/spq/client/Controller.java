package es.deusto.spq.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Post;
import es.deusto.spq.data.Usuario;
import es.deusto.spq.data.dto.UsuarioLogin;

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

    public Response resetPassword(String nick, String newPassword){
         WebTarget resetTrget = webTarget.path("pisos/reset");
         UsuarioLogin ul = new UsuarioLogin(nick, newPassword);
         System.out.println(ul);
         Entity<UsuarioLogin> entity = Entity.entity(ul, MediaType.APPLICATION_JSON);
         Response response = resetTrget.request().post(entity);
         return response;
    }
    
    public Response registrarUsuario(Usuario usuario) {
    	 WebTarget publicarTarget = webTarget.path("pisos/registrar");
         Entity<Usuario> entity = Entity.entity(usuario, MediaType.APPLICATION_JSON);
         Response response = publicarTarget.request().post(entity);
         return response;
    }
    
    public Response guardarNuevoPiso(Piso piso) {
    	WebTarget publicarTarget = webTarget.path("pisos/newPiso");
    	Entity<Piso> entity = Entity.entity(piso, MediaType.APPLICATION_JSON);
    	Response response = publicarTarget.request().post(entity);
    	return response;
    }

    public Response login(String u, String p){
        WebTarget loginTarget = webTarget.path("pisos/login");
        UsuarioLogin ul = new UsuarioLogin(u, p);
        System.out.println(ul);
        Entity<UsuarioLogin> entity = Entity.entity(ul, MediaType.APPLICATION_JSON);
        Response response = loginTarget.request().post(entity);
         
        return response;
    }
    
    public List<Piso> getPisos(){
        List<Piso> pisos = new ArrayList<Piso>();
        WebTarget pisosWebTarget = webTarget.path("pisos");
        GenericType<List<Piso>> genericType = new GenericType<List<Piso>>(){}; 
        pisos = pisosWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
        for (Piso p : pisos){
            System.out.println(p);
        }
        return pisos;
    }
	
	public List<Post> getPost(){
        List<Post> posts = new ArrayList<Post>();
        WebTarget pisosWebTarget = webTarget.path("pisos/post");
        GenericType<List<Post>> genericType = new GenericType<List<Post>>(){}; 
        posts = pisosWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
        for (Post p : posts){
            System.out.println(p);
        }
        return posts;
    }
}