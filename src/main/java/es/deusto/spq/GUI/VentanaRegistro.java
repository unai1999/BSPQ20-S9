package es.deusto.spq.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class VentanaRegistro {

	private JFrame frame;
	private JTextField tFUs;
	private JTextField tFEmail;
	private JTextField tFPass1;
	private JTextField tFPass2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro window = new VentanaRegistro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelPrincipal = new JPanel();
		frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		
		JLabel lblUsTit = new JLabel("Usuario:");
		lblUsTit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsTit.setBounds(79, 161, 78, 22);
		panelPrincipal.add(lblUsTit);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(80, 220, 78, 22);
		panelPrincipal.add(lblEmail);
		
		JLabel lblContr = new JLabel("Contraseña:");
		lblContr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContr.setBounds(75, 282, 78, 22);
		panelPrincipal.add(lblContr);
		
		JLabel lblConfContr = new JLabel("Confirmar Contraseña:");
		lblConfContr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConfContr.setBounds(77, 339, 146, 22);
		panelPrincipal.add(lblConfContr);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setFocusPainted(false);
		btnAtras.setBounds(80, 434, 89, 23);
		panelPrincipal.add(btnAtras);
		
		JButton btnRegistrar = new JButton("Registrarse");
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setBounds(304, 434, 108, 23);
		panelPrincipal.add(btnRegistrar);
		
		JLabel lblTit = new JLabel("REGISTRO");
		lblTit.setHorizontalAlignment(SwingConstants.CENTER);
		lblTit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTit.setBounds(176, 52, 125, 41);
		panelPrincipal.add(lblTit);
		
		tFUs = new JTextField();
		tFUs.setBounds(246, 163, 133, 20);
		panelPrincipal.add(tFUs);
		tFUs.setColumns(10);
		
		tFEmail = new JTextField();
		tFEmail.setColumns(10);
		tFEmail.setBounds(246, 222, 133, 20);
		panelPrincipal.add(tFEmail);
		
		tFPass1 = new JTextField();
		tFPass1.setColumns(10);
		tFPass1.setBounds(246, 284, 133, 20);
		panelPrincipal.add(tFPass1);
		
		tFPass2 = new JTextField();
		tFPass2.setColumns(10);
		tFPass2.setBounds(246, 341, 133, 20);
		panelPrincipal.add(tFPass2);
		
		btnRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				validarUsuario(tFUs, "Debes introducir un usuario");
				validarContrasenya(tFPass1, "Introduce una contraseña valida (8 o más caracteres)");
				validarConfContrasenya(tFPass1, tFPass2, "Las contraseñas no coinciden");
				validarEmail(tFEmail, "Introduce un email valido");
				
			}
		});
	}
	
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
	private boolean validarConfContrasenya(JTextField tFPass1, JTextField tFPass2, String mensaje) {
		if(tFPass1.getText().equals(tFPass2.getText())) {
			return true;
		}else{
			mensajeError(tFPass2, mensaje);
		}
		return false;
	}

	private void validarEmail(JTextField tFemail, String mensaje) {
		String regex = "^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$";
		if (Pattern.matches(regex, tFemail.getText())) {
		}else{
			mensajeError(tFemail, mensaje);
		}
	}

	private boolean mensajeError(JTextField tF, String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje); 
		tF.requestFocus();
		return false;
	}

	public void setVisible(boolean b) {
		frame.setVisible(true);
	}
}
