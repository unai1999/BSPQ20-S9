package es.deusto.spq.data;

import javax.jdo.annotations.PersistenceCapable;



import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;


@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class MensajePrivado {

    private String origen;
    private String destino;
    private String contenido;

    public MensajePrivado(String origen, String destino, String contenido) {
        this.origen = origen;
        this.destino = destino;
        this.contenido = contenido;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    
    
}