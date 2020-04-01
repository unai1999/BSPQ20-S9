package es.deusto.spq.server;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	public List<Piso> getPisos(){
		List<Piso> pisos = new ArrayList<Piso>();

		
		return pisos;
	}
	
	@Path("/1")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDonationInfo() {
		
		return Response.ok("respuesta servidor").build();
	}

	
	@GET
	@Path("/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Piso getPiso(@PathParam("code") int cod){

		Piso p = null;
		p = DAOFactory.getInstance().createPisoDAO().getPiso(cod);


		return p;
	}
}