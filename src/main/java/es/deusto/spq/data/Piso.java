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
    private long id;

    private String nombre;
    private Double coste;

    private List<Imagen> imagenes; //Array de imagenes que tendra el piso para posteriormente mostrarlas en GUI
    
    private boolean alquilado;
    public Piso(){

    }

    public Piso(String nombre, Double coste) {
        this.nombre = nombre;
        this.coste = coste;
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

    @Override
    public String toString() {
        return "Piso [coste=" + coste + ", nombre=" + nombre + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    

}