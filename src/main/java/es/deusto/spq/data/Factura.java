package es.deusto.spq.data;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.InheritanceStrategy;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Factura {

    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT, primaryKey="true")
    private long id;
    private String fecha;
    private Piso piso;

    public Factura(long id, String fecha, Piso piso) {
        this.id = id;
        this.fecha = fecha;
        this.piso = piso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Piso getPiso() {
        return piso;
    }

    public void setPiso(Piso piso) {
        this.piso = piso;
    }

    
    
}