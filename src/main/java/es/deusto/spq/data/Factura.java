package es.deusto.spq.data;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.InheritanceStrategy;


/**
 * Esta clase es una clase basica de una Factura.
 * @author eneko
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Factura {

    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT, primaryKey="true")
    private long id;
    private String fecha;
    private Piso piso;
    private double importe;
    private Usuario cliente;
    private Usuario arrendador;
    

    /**
     * Constructor basico de la clase Factura. 
     * @param id
     * @param fecha
     * @param piso
     * @param cliente
     * @param arrendador
     */
    public Factura(long id, String fecha, Piso piso, Usuario cliente, Usuario arrendador) {
        this.id = id;
        this.fecha = fecha;
        this.piso = piso;
        this.cliente = cliente;
        this.arrendador = arrendador;
    }
    
    public Factura() {
    	
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
    
    public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Piso getPiso() {
        return piso;
    }

    public void setPiso(Piso piso) {
        this.piso = piso;
    }

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Usuario getArrendador() {
		return arrendador;
	}

	public void setArrendador(Usuario arrendador) {
		this.arrendador = arrendador;
	}

    
    
    
}