package es.deusto.spq.data.dto;

import java.io.Serializable;

public class PisoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
    private Double coste;
    private String localizacion;
    private int valoracion;
    private String desc;
    private int numeroInquilinos;
    private int nHab;
    
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getCoste() {
		return coste;
	}
	public void setCoste(Double coste) {
		this.coste = coste;
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getNumeroInquilinos() {
		return numeroInquilinos;
	}
	public void setNumeroInquilinos(int numeroInquilinos) {
		this.numeroInquilinos = numeroInquilinos;
	}
	public int getnHab() {
		return nHab;
	}
	public void setnHab(int nHab) {
		this.nHab = nHab;
	}
    
    
    

}
