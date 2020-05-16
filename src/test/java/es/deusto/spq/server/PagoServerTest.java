package es.deusto.spq.server;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import es.deusto.spq.data.Pago;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class PagoServerTest {
	
	@Mock DAOFactory df;
	
	public static PagoServer server;
	
	@Before
	public void setUp() {
		server = new PagoServer();
	}
	
	@Test
	public void realizarPagoTest() {
		df = mock(DAOFactory.class, Mockito.RETURNS_DEEP_STUBS);
		Pago p = new Pago();
		p.setEmail("ju@gmail.com"); p.setPrecio(300);
		
		Response r = server.realizarPago(p);
		assertEquals(200, r.getStatus());
		
	}

}
