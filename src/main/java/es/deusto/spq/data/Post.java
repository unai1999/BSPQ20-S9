package es.deusto.spq.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;

/**
* La clase contiene información de cada Post creado
* 
* @author Kike00
* 
*/
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Post {

    /** identificador único del post
    */
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT, primaryKey="true")
    private long id;
    
    private String titulo;
    private String autor;
    private String contenido;
    private int likes;
    /** Fecha y hora decreación del post
    */
    private String fecha;
   // private List<Comentario> comentarios;


   /**	Constructor de la clase Post
	 * @param titulo título del post	
	 * @param autor autor del post
     * @param contenido contenido del texto del post
	 */
    public Post(String titulo, String autor, String contenido) {
       
    
        this.titulo = titulo;
        this.autor = autor;
        this.contenido = contenido;
        this.likes = 0;
        LocalDateTime myObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myObj.format(myFormatObj);
        this.fecha = formattedDate;
       // this.comentarios = new ArrayList<Comentario>();
    }

    public Post(Post post) {
		this.autor = post.autor;
		//this.comentarios = post.comentarios;
		this.contenido = post.contenido;
		this.fecha = post.fecha;
		this.likes = post.likes;
		this.titulo = post.titulo;
	}

	public Post() {
		
	}

//	public void addComentario(Comentario c){
//        this.comentarios.add(c);
//    }

  

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void incLikes(){
        this.likes++;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

//    public List<Comentario> getComentarios() {
//        return comentarios;
//    }
//
//    public void setComentarios(List<Comentario> comentarios) {
//        this.comentarios = comentarios;
//    }

    

}