package es.deusto.spq.server;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.deusto.spq.data.Usuario;

@Path("/pagos")
@Produces(MediaType.APPLICATION_JSON)
public class PagoServer {
	
	public PagoServer() {
	}
	
	@Path("/realizarPago")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response realizarPago(int precio, Usuario u) {
		DAOFactory.getInstance().createUsuarioDAO().realizarPago(precio, u.getEmail());
		return Response.ok(Response.Status.OK).build();
	}
	
	@Path("/anyadirFondos")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response anyadirFondos(Usuario u, int cantidad) {
		DAOFactory.getInstance().createUsuarioDAO().anyadirFondos(u.getEmail(), cantidad);
		return Response.ok(Response.Status.OK).build();
	}
	
	



}
