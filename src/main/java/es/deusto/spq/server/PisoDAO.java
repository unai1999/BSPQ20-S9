package es.deusto.spq.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.spq.data.Piso;

public class PisoDAO{

    private PersistenceManagerFactory pmf;
    private PersistenceManager pm;
    
    protected PisoDAO(){
        pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        pm = pmf.getPersistenceManager();
    }
    
    public void guardar(Object o) {
    	Transaction tx = pm.currentTransaction();
    	try {
			tx.begin();
			System.out.println("  * Guardando un objeto: " + o);
			pm.makePersistent(o);
			tx.commit();
		} catch (Exception e) {
			System.out.println("  $ Error guardando un objeto: " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
    }
    
    public void crearAlgunosDatos() {
    	Piso p1 = new Piso();
    	p1.setNombre("Piso 1"); p1.setCoste(800.0); p1.setAlquilado(false);
    	p1.setLocalizacion("Bilbao"); p1.setId(1800); p1.setValoracion(4);
    	p1.setNumeroInquilinos(4); p1.setnHab(3);
    	// Guardar imagenes
    	
    	Piso p2 = new Piso();
    	p2.setNombre("Piso 2"); p2.setCoste(700.0); p2.setAlquilado(false);
    	p2.setLocalizacion("Madrid"); p2.setId(2700); p2.setValoracion(3);
    	p2.setNumeroInquilinos(6); p2.setnHab(4);
    	// Guardar imagenes
    	
    	Piso p3 = new Piso();
    	p3.setNombre("Piso 3"); p3.setCoste(400.0); p3.setAlquilado(false);
    	p3.setLocalizacion("Sevilla"); p3.setId(3400); p3.setValoracion(2);
    	p3.setNumeroInquilinos(8); p3.setnHab(3);
    	// Guardar imagenes
    	
    	Piso p4 = new Piso();
    	p4.setNombre("Piso 4"); p4.setCoste(900.0); p4.setAlquilado(false);
    	p4.setLocalizacion("Bilbao"); p4.setId(4900); p4.setValoracion(5);
    	p4.setNumeroInquilinos(4); p4.setnHab(2);
    	// Guardar imagenes
    	
    	Piso p5 = new Piso();
    	p5.setNombre("Piso 5"); p5.setCoste(800.0); p5.setAlquilado(false);
    	p5.setLocalizacion("Barcelona"); p5.setId(5800); p5.setValoracion(4);
    	p5.setNumeroInquilinos(5); p5.setnHab(3);
    	// Guardar imagenes
    	
    	Piso p6 = new Piso();
    	p6.setNombre("Piso 6"); p6.setCoste(700.0); p6.setAlquilado(false);
    	p6.setLocalizacion("Bilbao"); p6.setId(6700); p6.setValoracion(3);
    	p6.setNumeroInquilinos(4); p6.setnHab(2);
    	// Guardar imagenes
    	
    	guardar(p1);
    	guardar(p2);
    	guardar(p3);
    	guardar(p4);
    	guardar(p5);
    	guardar(p6);
    }
    
    public List<Piso> getPisos() {
    	List<Piso> pisos = new ArrayList<Piso>();
    	Transaction tx = pm.currentTransaction();
    	try {
			System.out.println(" * Retrieving an extent for Piso.");
			tx.begin();
			Extent<Piso> extent = pm.getExtent(Piso.class, true);
			for (Piso piso : extent) {
				pisos.add(piso);
			}
			tx.commit();
		} catch (Exception e) {
			System.out.println(" $ Error retrieving Piso: " + e.getMessage());
		} finally {
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
    	return pisos;
    }
    
    public Piso getPisoById(int id) {
    	List<Piso> pisos = getPisos();
    	for (Piso p : pisos) {
    		if (p.getId() == id) {
    			return p;
    		}
    	}
    	return null;
    }
    
    public void closeConnection() {
    	pmf.close();
    }

    public Piso getPiso(long id){

        Piso piso = null;

        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        try {
            tx.begin();
            Extent<Piso> extent = pm.getExtent(Piso.class, true);
            for(Piso p : extent){
                if(p.getId() == id){
                    piso = p;
                    break;
                }
            }

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (tx != null && tx.isActive()){
                tx.rollback();
            }
            pm.close();
        }
        
        return piso;
    }
}