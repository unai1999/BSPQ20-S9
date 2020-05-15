package es.deusto.spq.data;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;

/**	Clase de comentarios post
 * @author alvar
 *
 */
@PersistenceCapable
public class ComentarioPost {

	@Join
	private Post post;
	
	private String texto;
	
	
	/** Constructor de la clase ComentarioPost
	 * @param post
	 * @param texto
	 */
	public ComentarioPost(Post post, String texto) {
		
		this.post = post;
		this.texto = texto;

	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
}
