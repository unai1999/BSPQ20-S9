package es.deusto.spq.GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Post;

/**
 * Clase que contiene metodos que se usan en las interfaces.
 * @author eneko
 */
public class MetodosGUI {

	enum Resp {
        MISSMATCH,
        LENGTH,
        VALID
    }

	/**
	 * Función que valida el nombre del usuario si no está vacio
	 * @param nombre
	 * @return true si el nombre no está vacio.
	 */
	public boolean validarNombre(String nombre) {
		if(nombre.equals("")) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * Función que valida el nickname del usuario
	 * @param usuario
	 * @return true si el nickname no está vacio o tiene 5 letras o menos.
	 */
	public boolean validarUsuario(String usuario){
		
		 if (usuario.equals("") || usuario.length() <= 5 ){
			  return false;
		  }else {
			  return true;
		  }  
	}
	
	/**
	 * Función que valida la contraseña de la usuario
	 * @param pass1
	 * @return true si la contraseña no está vacia o tiene al menos 8 letras.
	 */
	public boolean validarContrasenya(String pass1){
		  if (pass1.equals("") || pass1.length() < 8) {
			  return false;
		  }else {
			  return true;
		  }  
	}
	
	/**
	 * Función que valida la confirmación de la contraseña.
	 * @param pass1
	 * @param pass2
	 * @return true si la contraseña es igual a la confirmación de contraseña.
	 */
	public boolean validarConfContrasenya(String pass1, String pass2) {
		if(pass1.equals(pass2)) {
			return true;
		}else{
			return false;
		}
		
	}

	/**
	 * Función que valida el email del usuario.
	 * @param email
	 * @return true si el email concuerda con el patrón.
	 */
	public boolean validarEmail(String email) {
		String regex = "^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$";
		if (Pattern.matches(regex, email)) {
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Función que muestra un Popup al usuario si hay algún error.
	 * @param tF
	 * @param mensaje
	 * @return un Popup al usuario si hay algún error.
	 */
	public boolean mensajeError(JTextField tF, String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje); 
		tF.requestFocus();
		return false;
	}
	
	public boolean comprobarVacio(JTextField tf) { 
		if(tf.getText().equals("")) {
			return mensajeError(tf, "Debes rellenar todos los campos");
		} else {
			return true;
		}
	}

	public static Resp validate(String p1, String p2){

        Resp r = Resp.VALID;
        if (p1.equals(p2)) {
            if(p1.length() < 4){
                r = Resp.LENGTH;
                return r;
            }else{
                return r;
            }           
        } else {
            r = Resp.MISSMATCH;
            return r;
		}
	}
	/**
	 * Esta función buscará en todos los pisos aquellos que coincidan con el nombre que pasamos por parametro (texto)
	 * @param texto localizacion del piso
	 * @param pisos la lista de pisos 
	 * @return la lista de pisos que tengan el como nombre el parametro texto
	 */
	public List<Piso> buscarPisos(String texto, List<Piso> pisos) {
		texto = texto.toLowerCase();
		ArrayList<Piso> pisosBuscados = new ArrayList<Piso>();
		for(int i = 0 ; i < pisos.size(); i++) {
			if(pisos.get(i).getLocalizacion().toLowerCase().contentEquals(texto)) {
				pisosBuscados.add(new Piso(pisos.get(i)));
			}
		}
		return pisosBuscados;	
	}
	/**
	 * Esta función obtendrá el piso que coindida con el nombre que se sacará del parametro text
	 * @param texto nombre del piso
	 * @param pisos la lista de pisos
	 * @return el piso con todos sus datos.
	 */
	public Piso obtenerPiso(String text, List<Piso> pisos) {
		Piso p = new Piso();
		String[] partes = text.split(":");
		String nombre = partes[1];
		nombre = nombre.toLowerCase();
		nombre = nombre.replaceAll("\n", "");
		for(int i = 0; i < pisos.size(); i++) {
			if(nombre.contentEquals(pisos.get(i).getNombre().toLowerCase())) {
				p = pisos.get(i);
			}
		}
		return p;
	}
	
	/**
	 * Esta función buscará en todos los posts aquellos que coincidan con el nombre del autor que pasamos por parametro (texto)
	 * @param texto el nombre del autor 
	 * @param posts la lista de posts
	 * @return la lista de post que tengan el usuario que hemos pasado como parametro texto
	 */
	public List<Post> buscarPosts(String texto, List<Post> posts) {
		texto = texto.toLowerCase();
		ArrayList<Post> postsBuscados = new ArrayList<Post>();
		for(int i = 0 ; i < posts.size(); i++) {
			if(posts.get(i).getAutor().toLowerCase().contentEquals(texto)) {
				postsBuscados.add(new Post(posts.get(i)));
			}
		}
		return postsBuscados;	
	}
	
	/**
	 * Esta función obtendrá el post que coindida con el titulo que se sacará del parametro text
	 * @param texto el titulo del post
	 * @param posts la lista de posts 
	 * @return el post con todos sus datos.
	 */
	public Post obtenerPost(String text, List<Post> posts) {
		Post p = new Post();
	
		String[] partes = text.split(":");
		String titulo = partes[1];
		titulo = titulo.replaceAll("\n", "");
		titulo = titulo.replaceAll(" ", "");
		for(int i = 0; i < posts.size(); i++) {
			if(titulo.toLowerCase().contentEquals(posts.get(i).getTitulo().toLowerCase().replaceAll(" ", ""))) {
				p = posts.get(i);
			}
		}
			
		return p;
	}
	
	
	
}
