package es.deusto.spq.data;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;


/**	Clase para los comentarios de los pisos
 * @author alvar
 *
 */
@PersistenceCapable
public class ComentarioPiso {
	
	@Join 
	private Piso piso;
	
	private String texto;
	
	
	/**	Constructor de la clase ComentarioPiso
	 * @param piso	
	 * @param texto
	 */
	public ComentarioPiso(Piso piso, String texto) {
		
		this.piso = piso;
		this.texto = texto;
		
	}

	public Piso getPiso() {
		return piso;
	}

	public void setPiso(Piso piso) {
		this.piso = piso;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
