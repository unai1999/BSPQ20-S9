package es.deusto.spq.data;

public class Mensaje {

	private String id;
	private String cuerpo;
	private String titulo;
	
	public Mensaje(String id, String titulo, String cuerpo) {
		
		this.id = id;
		this.setTitulo(titulo);
		this.cuerpo = cuerpo;
	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
