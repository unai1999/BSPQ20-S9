package es.deusto.spq.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.NotPersistent;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Piso{

    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT, primaryKey="true")
    private long id;

    private String nombre;
    private Double coste;
    private String localizacion;
    private int valoracion;
    private String desc;
    private int numeroInquilinos;
    private int nHab;
    
    
    
    private double lat;
    private double lon;
    
    private int vecesComprado;
    private int likes;
    private int vecesVisitado;
    
	private List<Imagen> imagenes; //Array de imagenes que tendra el piso para posteriormente mostrarlas en GUI
    
	@NotPersistent
	private List<Usuario> inquilinos; 
	@NotPersistent
	private Propietario propiertario;
	
    private boolean alquilado;
    
    public int getVecesComprado() {
		return vecesComprado;
	}

	public void setVecesComprado(int vecesComprado) {
		this.vecesComprado = vecesComprado;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getVecesVisitado() {
		return vecesVisitado;
	}

	public void setVecesVisitado(int vecesVisitado) {
		this.vecesVisitado = vecesVisitado;
	}

	public List<Usuario> getInquilinos() {
		return inquilinos;
	}

	public void setInquilinos(List<Usuario> inquilinos) {
		this.inquilinos = inquilinos;
	}


	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

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

    @Override
    public String toString() {
        return "Piso [alquilado=" + alquilado + ", coste=" + coste + ", id=" + id 
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


//	public List<Usuario> getInquilinos() {
//		return inquilinos;
//	}

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