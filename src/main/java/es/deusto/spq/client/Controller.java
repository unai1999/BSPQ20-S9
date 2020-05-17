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

import es.deusto.spq.data.MensajePrivado;
import es.deusto.spq.data.Pago;
import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Post;
import es.deusto.spq.data.Usuario;
import es.deusto.spq.data.dto.UsuarioLogin;

/**
 * Controller es la clase que gestiona la interacción de la UI con el servidor
 * Se trata de una clase tipo Singleton, por lo que solo existe una instancia de
 * la misma en todo el proceso de ejecución, y se accede a sus métodos de forma
 * estática.
 *
 * @author Kike
 * 
 */

public class Controller {

    private static Controller instance;

    private Client client;
    private WebTarget webTarget;
    private WebTarget requestTarget;
    /**
     * Usuario que ha iniciado sesión.
     */
    Usuario usuarioActual;

    public void setUsuario(Usuario u) {
        instance.usuarioActual = u;
    }

    public Usuario getUsuario() {
        return instance.usuarioActual;
    }

    public void setWebTarget(WebTarget wt) {
        webTarget = wt;
    }

    public String m() {
        return requestTarget.toString();
    }

    /**
     * Constructor de la clase Controller que inicializa el cliente y el webTarget con los datos introducidos
     * en las properties del pom.xml
     */
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
        //System.out.println(String.format("http://%s:%s/rest", hostname, port));

    }

    /**
     * Método para obtener la instancia activa del controller.
     * Representa la forma de llamar a todos los métodos disponibles
     */
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
            instance.setUsuario(null);
        }
        return instance;
    }

    /**
     * Método encargado de publicar posts mediante una llamada POST al servidor
     * 
     * @param titulo titulo del post
     * @param autor autor del post
     * @param contenido contenido del post
     * @return una variable tipo Response con la resupesta del servidor
     */
    public Response publicarPost(String titulo, String autor, String contenido) {

        requestTarget = webTarget.path("pisos/foro/submit");
        Post post = new Post(titulo, autor, contenido);
        Entity<Post> entity = Entity.entity(post, MediaType.APPLICATION_JSON);
        Response response = requestTarget.request().post(entity);

        return response;

    }
    /**
     * Método encargado de resetear la contraseña de un usuario
     * 
     * @param email email al que se enviará el código de confirmación
     * @param newPassword nueva contraseá
     * @return contiene la respuesta del servidor
     */

    public Response resetPassword(String email, String newPassword) {
        WebTarget resetTrget = webTarget.path("pisos/reset");
        UsuarioLogin ul = new UsuarioLogin(email, newPassword);
        Entity<UsuarioLogin> entity = Entity.entity(ul, MediaType.APPLICATION_JSON);
        Response response = resetTrget.request().post(entity);
        return response;
    }

     /**
     * Método encargado de registrar un nuevo usuario
     * 
     * @param usuario usuario con la información necesaria para guardarlo en la base de datos
     * @return contiene la respuesta del servidor
     */
    public Response registrarUsuario(Usuario usuario) {
        WebTarget publicarTarget = webTarget.path("pisos/registrar");
        Entity<Usuario> entity = Entity.entity(usuario, MediaType.APPLICATION_JSON);
        Response response = publicarTarget.request().post(entity);
        return response;
    }

    /**
     * Método encargado de registrar un nuevo piso
     * 
     * @param usuario piso con la información necesaria para guardarlo en la base de datos
     * @return contiene la respuesta del servidor
     */
    public Response guardarNuevoPiso(Piso piso) {
        WebTarget publicarTarget = webTarget.path("pisos/newPiso");
        Entity<Piso> entity = Entity.entity(piso, MediaType.APPLICATION_JSON);
        Response response = publicarTarget.request().post(entity);
        return response;
    }

    /**
     * Método encargado de gestionar el intento de login del usuario
     * 
     * @param u nombre de usuario con el que se ha intentado iniciar sesión
     * @param p contraseña con la que se ha intentado iniciar sesión
     * @return contiene la respuesta del servidor
     */
    public Response login(String u, String p) {
        WebTarget loginTarget = webTarget.path("pisos/login");
        UsuarioLogin ul = new UsuarioLogin(u, p);
        Entity<UsuarioLogin> entity = Entity.entity(ul, MediaType.APPLICATION_JSON);
        Response response = loginTarget.request().post(entity);

        return response;
    }

    /**
     * Método encargado de devolver una lista con los pisos existentes
     * 
     * @return lista de todos los pisos en la base de datos
     */
    public List<Piso> getPisos() {
        List<Piso> pisos = new ArrayList<Piso>();
        WebTarget pisosWebTarget = webTarget.path("pisos");
        GenericType<List<Piso>> genericType = new GenericType<List<Piso>>() {
        };
        pisos = pisosWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
        return pisos;
    }

    /**
     * Método encargado de devolver una lista con los posts existentes
     * 
     * @return lista de todos los posts existentes
     */
    public List<Post> getPost() {
        List<Post> posts = new ArrayList<Post>();
        String path = "pisos/post";
        WebTarget postWebTarget = webTarget.path(path);
        GenericType<List<Post>> genericType = new GenericType<List<Post>>() {
        };
        posts = postWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
    
        return posts;
    }

     /**
     * Método encargado de devolver una lista con los mensajes provados de un usuario
     * 
     * @param usuario usuario del que se desean obtener los mensajes privados
     * 
     * @return lista de todos los mensajes del usuario indicado
     */
    public List<MensajePrivado> getMensajes(String usuario) {
        List<MensajePrivado> mensajes = new ArrayList<MensajePrivado>();
        String path = "pisos/mensajes/" + usuario;
        WebTarget pisosWebTarget = webTarget.path(path);
        GenericType<List<MensajePrivado>> genericType = new GenericType<List<MensajePrivado>>() {
        };
        mensajes = pisosWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
        return mensajes;
    }

     /**
     * Método encargado enviar un mensaje privado
     * 
     * @param mp variable tipo MensajePrivado con la información necesaria
     * @return contiene la respuesta del servidor
     */
    public Response enviarMensaje(MensajePrivado mp) {

        WebTarget publicarTarget = webTarget.path("pisos/mensajes/enviar");
        Entity<MensajePrivado> entity = Entity.entity(mp, MediaType.APPLICATION_JSON);
        Response response = publicarTarget.request().post(entity);

        return response;

    }

    /**
     * Método encargado de realizar un pago
     * 
     * @param p variable tipo Pago con la información necesaria
     * @return contiene la respuesta del servidor
     */
    public Response realizarPago(Pago p) {
        WebTarget publicarTarget = webTarget.path("pagos/realizarPago");
        Pago pago = new Pago();
        pago.setEmail(p.getEmail());
        pago.setPrecio(p.getPrecio());
        Entity<Pago> entity = Entity.entity(pago, MediaType.APPLICATION_JSON);
        Response response = publicarTarget.request().post(entity);

        return response;
    }


    /**
     * Método encargado añadir fondos para un usuario
     * 
     * @param u usuario que recibe los fondos
     * @param cantidad cantidad de dinero
     * 
     * @return contiene la respuesta del servidor
     */
    public Response anyadirFondos(Usuario u, int cantidad) {
        WebTarget publicarTarget = webTarget.path("pagos/anyadirFondos");
        u.setMonedero(u.getMonedero() + cantidad);
        Entity<Usuario> entity = Entity.entity(u, MediaType.APPLICATION_JSON);
        Response response = publicarTarget.request().post(entity);

        return response;
    }

}