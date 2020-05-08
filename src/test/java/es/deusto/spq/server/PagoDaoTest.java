package es.deusto.spq.server;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Pago;

public class PagoDaoTest {
	
	PagoDAO pDao;
	Pago pago;
	
	@Before
	public void setUp() {
		pDao = new PagoDAO();
		pago = new Pago();
		pago.setEmail("aa@gmail.com");
		pago.setPrecio(100);
	}
	
	
	@Test
	public void guardarYGetPagosTest() {
		pDao.guardarPago(pago);
		List<Pago> pagos = pDao.getPagosByEmail(pago.getEmail());
		for (Pago p : pagos) {
			assertEquals(pago.getEmail(), p.getEmail());
		}
	}

}
