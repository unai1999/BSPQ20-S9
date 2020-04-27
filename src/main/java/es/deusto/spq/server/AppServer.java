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
import es.deusto.spq.server.DAOFactory;


@Path("/pisos")
@Produces(MediaType.APPLICATION_JSON)
public class AppServer {

	
	public AppServer() {
		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Piso> getPisos(){
		List<Piso> pisos = new ArrayList<Piso>();

		pisos = DAOFactory.getInstance().createPisoDAO().getPisos();
		
		return pisos;
	}
	
	@Path("/post")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> getPosts(){
		List<Post> posts = new ArrayList<Post>();

		posts = DAOFactory.getInstance().createPostDAO().getPosts();
		
		return posts;
	}

	@Path("/mensajes/{usuario}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MensajePrivado> getMensajes(@PathParam("usuario") final String usuario){
		List<MensajePrivado> mensajes = new ArrayList<MensajePrivado>();

		mensajes = DAOFactory.getInstance().createMensajeDAO().getMensaje(usuario);
		
		return mensajes;
	}
	
	@Path("/1")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDonationInfo() {
		
		return Response.ok("respuesta servidor").build();
	}

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Piso getPiso(@PathParam("id") final int id){

		Piso p = null;
		p = DAOFactory.getInstance().createPisoDAO().getPiso(id);


		return p;
	}


	@Path("/foro/submit")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearPost(final Post post){
	 	DAOFactory.getInstance().createForoDAO().guardar(post);
	 	return Response.status(Response.Status.OK).build();

	}

	@Path("/mensajes/enviar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response enviarMensaje(MensajePrivado mp){
		
	 	DAOFactory.getInstance().createMensajeDAO().guardar(mp);
	 	return Response.status(Response.Status.OK).build();

	 }
	
	@Path("/registrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarUsuario(Usuario usuario){
	 	DAOFactory.getInstance().createUsuarioDAO().guardar(usuario);
	 	return Response.status(Response.Status.OK).build();

	}

	@Path("/reset")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response actualizarPassword(UsuarioLogin ul){

		DAOFactory.getInstance().createUsuarioDAO().actualizarPassword(ul.getNick(), ul.getPassword());		
		return Response.status(Response.Status.OK).build();
	}

	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(UsuarioLogin ul){
		Usuario u = DAOFactory.getInstance().createUsuarioDAO().getUsuario(ul.getNick());

	 	if(u == null) {
	 		return Response.status(Response.Status.NOT_FOUND).build();
	 	}else if(!u.getPw1().equals(ul.getPassword())) {
			return Response.status(Response.Status.BAD_REQUEST).build();
	 	}else{
			return Response.status(Response.Status.OK).build();
		 	}
		
		
			 
	 }


	

}