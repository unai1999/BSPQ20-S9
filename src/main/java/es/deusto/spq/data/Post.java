package es.deusto.spq.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.jdo.annotations.PersistenceCapable;


import java.util.ArrayList;
import java.util.List;


import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;


@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Post {

    private String titulo;
    private String autor; //Usuario?
    private String contenido;
    private int likes;
    private String fecha;
    private List<Comentario> comentarios;

    public Post(String titulo, String autor, String contenido) {
       
    
        this.titulo = titulo;
        this.autor = autor;
        this.contenido = contenido;
        this.likes = 0;
        LocalDateTime myObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myObj.format(myFormatObj);
        this.fecha = formattedDate;
        this.comentarios = new ArrayList<Comentario>();
    }

    public Post(Post post) {
		this.autor = post.autor;
		this.comentarios = post.comentarios;
		this.contenido = post.contenido;
		this.fecha = post.fecha;
		this.likes = post.likes;
		this.titulo = post.titulo;
	}

	public void addComentario(Comentario c){
        this.comentarios.add(c);
    }

  

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

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    

}