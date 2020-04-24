package es.deusto.spq.GUI;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MetodosGUI {

	enum Resp {
        MISSMATCH,
        LENGTH,
        VALID
    }

	public boolean validarNombre(String nombre) {
		if(nombre.equals("")) {
			return false;
		}else {
			return true;
		}
	}
	public boolean validarUsuario(String usuario){
		  if (usuario.equals("") && usuario.length() >= 5 ) {
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
}
