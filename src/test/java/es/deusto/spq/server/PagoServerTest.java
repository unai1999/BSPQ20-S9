package es.deusto.spq.server;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import es.deusto.spq.data.Pago;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import javax.ws.rs.core.Response;

/**
 * Clase que comprueba el funcionamiento del servidor de pago
 * @author jonuraga
 *
 */
public class PagoServerTest {
	
	@Mock DAOFactory df;
	
	public static PagoServer server;
	
	@Before
	public void setUp() {
		server = new PagoServer();
	}
	
	/**
	 * Test del método que realiza pagos, comprueba que funciona correctamente y devuelve un status code ok
	 */
	@Test
	public void realizarPagoTest() {
		df = mock(DAOFactory.class, Mockito.RETURNS_DEEP_STUBS);
		Pago p = new Pago();
		p.setEmail("ju@gmail.com");
		p.setPrecio(200);
		
		Response r = server.realizarPago(p);
		assertEquals(200, r.getStatus());
	}

}
