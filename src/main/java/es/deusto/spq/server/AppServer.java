package es.deusto.spq.server;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import es.deusto.spq.data.*;
import es.deusto.spq.data.dto.UsuarioLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AppServer ofrece los métodos del servidor
 *
 * @author Kike
 * 
 */

//cambiar URL
@Path("/pisos")
@Produces(MediaType.APPLICATION_JSON)
public class AppServer {

	Logger logger = LoggerFactory.getLogger(AppServer.class);

	public AppServer() {
		
	}

	/**
     * Este método devuelve una lista con todos los pisos guardados en la base de datos.
	 * @return lista de objetos tipo Piso
     */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Piso> getPisos(){
		logger.info("Obteniendo lista de pisos...");
		List<Piso> pisos = new ArrayList<Piso>();

		pisos = DAOFactory.getInstance().createPisoDAO().getPisos();
		
		return pisos;
	}
	
	/**
     * Este método devuelve una lista con todos los posts guardados en la base de datos.
	 * @return lista de objetos tipo Post
     */
	@Path("/post")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> getPosts(){

		logger.info("Obteniendo lista de posts...");
		List<Post> posts = new ArrayList<Post>();

		posts = DAOFactory.getInstance().createPostDAO().getPosts();
		
		return posts;
	}

	/**
     * Este método devuelve una lista con los mensajes privados dirigidos a un usuario.
	 * @param usuario nickname del usuario del que se desean obtener los mensajes
	 * @return lista de objetos tipo MensajePrivado
     */
	@Path("/mensajes/{usuario}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MensajePrivado> getMensajes(@PathParam("usuario")  String usuario){
		logger.info("Obteniendo lista de mensajes de "+ usuario);
		List<MensajePrivado> mensajes = new ArrayList<MensajePrivado>();

		mensajes = DAOFactory.getInstance().createMensajeDAO().getMensaje(usuario);
		
		return mensajes;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Piso getPiso(@PathParam("id") final int id){

		Piso p = null;
		p = DAOFactory.getInstance().createPisoDAO().getPiso(id);

		//PisoAssembler pa = new PisoAssembler();
		//PisoDTO piso = pa.assemble(p);
		return p;
	}


	/**
     * Este método gurada en nuevo Post en la base de datos.
	 * @param post objeto tipo Post que se desea guardar
	 * @return contiene la respuesta del servidor
     */
	@Path("/foro/submit")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearPost(final Post post){
		logger.info("Creando post: "+ post.getTitulo());
	 	if(DAOFactory.getInstance().createForoDAO().guardar(post)){
			return Response.status(Response.Status.OK).build();
		 }else{
			return Response.status(Response.Status.CONFLICT).build();
		 }
	 	

	}

	/**
     * Este método guarda un MensajePrivado en la base de datos.
	 * @param mp objeto tipo MensajePrivado que se guardará
	 * @return respuesta del servidor
     */
	@Path("/mensajes/enviar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response enviarMensaje(MensajePrivado mp){
		logger.info("Enviando mensaje a "+ mp.getDestino());
	 	DAOFactory.getInstance().createMensajeDAO().guardar(mp);
	 	return Response.status(Response.Status.OK).build();

	 }
	
	 /**
     * Este método guarda un nuevo usuario en la base de datos.
	 * @param usuario Usuario a guardar
	 * @return respuesta del servidor
     */
	@Path("/registrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarUsuario(Usuario usuario){

		logger.info("Registrando usuario " + usuario.getNickname());
	 	DAOFactory.getInstance().createUsuarioDAO().guardar(usuario);
	 	return Response.status(Response.Status.OK).build();

	}

	/**
     * Este método actualiza la contraseña de un usuario.
	 * @param ul contiene la informacion del usuario
	 * @return respuesta del servidor
     */
	@Path("/reset")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response actualizarPassword(UsuarioLogin ul){

		logger.info("Reseteando contraseña de "+ul.getNick());
		DAOFactory.getInstance().createUsuarioDAO().actualizarPassword(ul.getNick(), ul.getPassword());		
		return Response.status(Response.Status.OK).build();
	}

	/**
     * Este método comprueba si el login de un usuario es correcto
	 * @param ul contiene la información del usuario
	 * @return respuesta del servidor
     */
	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(UsuarioLogin ul){
		Usuario u = DAOFactory.getInstance().createUsuarioDAO().getUsuario(ul.getNick());

	 	if(u == null) {
			logger.error("Usuario no encontrado");
			 return Response.status(Response.Status.NOT_FOUND).build();			 
	 	}else if(!u.getPw1().equals(ul.getPassword())) {
			logger.error("Contraseña inválida");
			return Response.status(Response.Status.BAD_REQUEST).build();
	 	}else{
			logger.info("Login de " + ul.getNick());
			return Response.status(Response.Status.OK).build();
		 	}
		
		
			 
	 }
	
	/**
	 * Método servidor que guarda un piso nuevo en la base de datos
	 * @param piso Piso que se va a guardar en la base de datos
	 * @return Devuelve la response del servidor tras intentar el guardado en base de datos
	 */
	@Path("/newPiso")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarPiso(Piso piso){
		logger.error("Subiendo nuevo piso...");
	 	DAOFactory.getInstance().createPisoDAO().guardar(piso);
	 	return Response.status(Response.Status.OK).build();

	}

	

	@Path("/facturas/{usuario}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Factura> getFacturas(@PathParam("usuario")  String usuario){

		logger.info("Obteniendo lista de posts...");
		List<Factura> fs = DAOFactory.getInstance().createPisoDAO().getFacturas(usuario);
		
		return fs;
	}
	

}