package es.deusto.spq.GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Post;

public class MetodosGUI {

	public boolean validarNombre(String nombre) {
		if(nombre.equals("")) {
			return false;
		}else {
			return true;
		}
	}
	public boolean validarUsuario(String usuario){
		
		 if (usuario.equals("") || usuario.length() <= 5 ){
			  return false;
		  }else {
			  return true;
		  }  
	}
		
	public boolean validarContrasenya(String pass1){
		  if (pass1.equals("") || pass1.length() < 8) {
			  return false;
		  }else {
			  return true;
		  }  
	}
	public boolean validarConfContrasenya(String pass1, String pass2) {
		if(pass1.equals(pass2)) {
			return true;
		}else{
			return false;
		}
		
	}

	public boolean validarEmail(String email) {
		String regex = "^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$";
		if (Pattern.matches(regex, email)) {
			return true;
		}else{
			return false;
		}
	}

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
	
	public List<Piso> buscarPisos(JTextField texto, List<Piso> pisos) {
		String ciudad = texto.getText().toLowerCase();
		ArrayList<Piso> pisosBuscados = new ArrayList<Piso>();
		for(int i = 0 ; i < pisos.size(); i++) {
			if(pisos.get(i).getLocalizacion().toLowerCase().contentEquals(ciudad)) {
				pisosBuscados.add(new Piso(pisos.get(i)));
			}
		}
		return pisosBuscados;	
	}
	
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
	
	public List<Post> buscarPosts(JTextField texto, List<Post> posts) {
		String usuario = texto.getText().toLowerCase();
		ArrayList<Post> postsBuscados = new ArrayList<Post>();
		for(int i = 0 ; i < posts.size(); i++) {
			if(posts.get(i).getAutor().toLowerCase().contentEquals(usuario)) {
				postsBuscados.add(new Post(posts.get(i)));
			}
		}
		return postsBuscados;	
	}
	
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
	
	public List<Piso> getPisos(WebTarget webTarget){
        List<Piso> pisos = new ArrayList<Piso>();
        WebTarget pisosWebTarget = webTarget.path("pisos");
        GenericType<List<Piso>> genericType = new GenericType<List<Piso>>(){}; 
        pisos = pisosWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
        for (Piso p : pisos){
            System.out.println(p);
        }
        return pisos;
    }
}
