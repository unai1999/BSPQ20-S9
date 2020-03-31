package es.deusto.spq;

import java.util.ArrayList;

public class Piso {
	
	private int id;
	private String nombre;
	private float precio;
	private String localizacion;
	private ArrayList<String> comentarios = new ArrayList<String>();
	private float valoracion;
	private String foto;
	
	public Piso(int id, String nombre, float precio, String localizacion, ArrayList<String> comentarios, float valoracion, String foto) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.localizacion = localizacion;
		this.comentarios = comentarios;
		this.valoracion = valoracion;
		this.foto = foto;
	}
	
	public Piso(Piso piso) {
		this.id = piso.id;
		this.nombre = piso.nombre;
		this.precio = piso.precio;
		this.localizacion = piso.localizacion;
		this.comentarios = piso.comentarios;
		this.valoracion = piso.valoracion;
		this.foto = piso.foto;
		
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public ArrayList<String> getComentarios() {
		return comentarios;
	}
	public void setComentarios(ArrayList<String> comentarios) {
		this.comentarios = comentarios;
	}
	public float getValoracion() {
		return valoracion;
	}
	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}
}
