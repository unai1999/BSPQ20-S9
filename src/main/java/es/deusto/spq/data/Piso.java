package es.deusto.spq.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Piso{

    @PrimaryKey
    private int id;

    private String nombre;
    private Double coste;
    private String localizacion;
    private int valoracion;

	private List<Imagen> imagenes; //Array de imagenes que tendra el piso para posteriormente mostrarlas en GUI
    
    private boolean alquilado;
    public Piso(){

    }

    public Piso(String nombre, Double coste) {
        this.nombre = nombre;
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


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public List<Imagen> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<Imagen> imagenes) {
		this.imagenes = imagenes;
	}

	public boolean isAlquilado() {
		return alquilado;
	}

	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}

    @Override
    public String toString() {
        return "Piso [alquilado=" + alquilado + ", coste=" + coste + ", id=" + id + ", imagenes=" + imagenes
                + ", localizacion=" + localizacion + ", nombre=" + nombre + ", valoracion=" + valoracion + "]";
    }


    

}