package es.deusto.spq.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 
/** Clase que obtiene los diferentes idiomas del .properties
 * @author alvar
 *
 */
public class Idioma extends Properties{
 
    private static final long serialVersionUID = 1L;
 
    /** Constructor de la clase idioma
     * @param idioma en el que se quiere ver la app
     */
    public Idioma(String idioma){
    	
    	
        //Modificar si quieres añadir mas idiomas
        //Cambia el nombre de los ficheros o añade los necesarios
        switch(idioma){
            case "Español":
	            	try (InputStream input = new FileInputStream("src/main/resources/espanol.properties")) {
	
	
	                    // load a properties file
	                    this.load(input);                 
	
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                }
                    break;
            case "Ingles":
	            	try (InputStream input = new FileInputStream("src/main/resources/ingles.properties")) {
	
	                   
	
	                    // load a properties file
	                    this.load(input);                 
	
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                }
                    break;
            default:
            	try (InputStream input = new FileInputStream("src/main/resources/espanol.properties")) {

                  

                    // load a properties file
                    this.load(input);                 

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        }
 
    }
 
    
    public static void main(String[] args) {
		
	}
}