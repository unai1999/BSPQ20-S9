package es.deusto.spq.data.dto;

import java.io.Serializable;

import es.deusto.spq.data.Piso;

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
    
    
    public static void main(String[] args) {
		PisoDTO pisoDTO = new PisoDTO();
		
		PisoAssembler as = new PisoAssembler();
		
		Piso piso = new Piso();
		 piso.setCoste(50.0);   
    	 piso.setDesc("Piso bonito");
    	 piso.setLocalizacion("calle");
    	 piso.setnHab(2);
    	 piso.setNombre("Piso");
    	 piso.setNumeroInquilinos(3);
    	 piso.setValoracion(5);
    	 
    	pisoDTO = as.assemble(piso);
    	
    	System.out.println("Un " + piso.getNombre() + "  aaa " + pisoDTO.getNombre());
	}

}

