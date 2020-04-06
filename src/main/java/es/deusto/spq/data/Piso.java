package es.deusto.spq.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.NotPersistent;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Piso{

    @PrimaryKey
    private int id;

    private String nombre;
    private Double coste;
    private String localizacion;
    private int valoracion;
    private String desc;
    private int numeroInquilinos;
    private int nHab;

	private List<Imagen> imagenes; //Array de imagenes que tendra el piso para posteriormente mostrarlas en GUI
    
	@NotPersistent
	private List<Usuario> inquilinos; 
	@NotPersistent
	private Propietario propiertario;
	
    private boolean alquilado;
    public Piso(){

    }

    public Piso(String nombre, Double coste) {
        this.nombre = nombre;
        this.coste = coste;
    }
    
    
    public Piso(Piso piso) {
		this.nombre = piso.nombre;
		this.coste = piso.coste;
		this.localizacion = piso.localizacion;
		this.valoracion = piso.valoracion;
		this.imagenes = piso.imagenes;
		this.alquilado = piso.alquilado;
		this.numeroInquilinos = piso.numeroInquilinos;
	}

    
	public int getNumeroInquilinos() {
		return numeroInquilinos;
	}

	public void setNumeroInquilinos(int numeroInquilinos) {
		this.numeroInquilinos = numeroInquilinos;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getnHab() {
		return nHab;
	}

	public void setnHab(int nHab) {
		this.nHab = nHab;
	}


	public List<Usuario> getInquilinos() {
		return inquilinos;
	}

//	public void setInquilinos(List<Usuario> inquilinos) {
//		if(this.getInquilinos().size() <= this.numeroInquilinos) {
//			this.inquilinos = inquilinos;
//		}
//		else {
//			System.out.println("Piso completo");
//		}
//		
//	}

	public Propietario getPropiertario() {
		return propiertario;
	}

	public void setPropiertario(Propietario propiertario) {
		this.propiertario = propiertario;
	}

}