package es.deusto.spq.GUI;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MetodosGUI {

	public boolean validarUsuario(JTextField tFUs, String mensaje){
		  if (tFUs.getText().equals("")) {
			  return mensajeError(tFUs, mensaje);
		  }else {
			  return true;
		  }  
	}
		
	public boolean validarContrasenya(JTextField tFPass1, String mensaje){
		  if (tFPass1.getText().equals("") || tFPass1.getText().length() < 8) {
			  return mensajeError( tFPass1, mensaje );
		  }else {
			  return true; 
		  }  
	}
	public boolean validarConfContrasenya(JTextField tFPass1, JTextField tFPass2, String mensaje) {
		if(tFPass1.getText().equals(tFPass2.getText())) {
			return true;
		}else{
			mensajeError(tFPass2, mensaje);
		}
		return false;
	}

	public void validarEmail(JTextField tFemail, String mensaje) {
		String regex = "^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$";
		if (Pattern.matches(regex, tFemail.getText())) {
		}else{
			mensajeError(tFemail, mensaje);
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
	
	

}
