package es.deusto.spq.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.deusto.spq.data.Pago;


/**
 * Esta clase sirve como servidor de Pago para poder realizar los pagos correspondientes a las reservas
 * @author jonuraga
 *
 */

@Path("/pagos")
@Produces(MediaType.APPLICATION_JSON)
public class PagoServer {
	
	public PagoServer() {
	}
	
	/**
	 * Método que se utiliza para realizar un pago tras recibir el path correspondiente a este método 
	 * @param p Pago que se va a realizar
	 * @return Devuelve la response del servidor
	 */
	@Path("/realizarPago")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response realizarPago(Pago p) {
		DAOFactory.getInstance().createUsuarioDAO().realizarPago(p);
		return Response.ok(Response.Status.OK).build();
	}
	
//	@Path("/anyadirFondos")
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response anyadirFondos(Usuario u, int cantidad) {
//		DAOFactory.getInstance().createUsuarioDAO().anyadirFondos(u.getEmail(), cantidad);
//		return Response.ok(Response.Status.OK).build();
//	}
	
	



}
