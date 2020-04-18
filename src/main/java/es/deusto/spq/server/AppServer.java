package es.deusto.spq.server;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import es.deusto.spq.data.*;
import es.deusto.spq.server.*;


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
	
	@Path("/registrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarUsuario(Usuario usuario){
	 	DAOFactory.getInstance().createUsuarioDAO().guardar(usuario);
	 	return Response.status(Response.Status.OK).build();

	 }


	@Path("/resetPassword")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarPassword(final String password){
	//TODO actualizar en la base de datos
	return Response.status(Response.Status.OK).build();



	}

}