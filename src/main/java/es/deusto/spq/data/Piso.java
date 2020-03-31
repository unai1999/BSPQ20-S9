package es.deusto.spq.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Piso{

    @PrimaryKey
    protected long id;

    protected String nombre;
    protected Double coste;

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

    

}