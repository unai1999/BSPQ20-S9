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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.swing.JTextField;
import es.deusto.spq.GUI.*;
import es.deusto.spq.client.Controller;
import es.deusto.spq.data.Usuario;
import javax.swing.JPasswordField;

public class VentanaRegistro {

	private JFrame frame;
	private JTextField tFUs;
	private JTextField tFEmail;
	private JPasswordField tFPass1;
	private JPasswordField tFPass2;
	private JTextField tFNombre;
	private JTextField tFApellido;

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
		lblEmail.setBounds(79, 300, 78, 22);
		panelPrincipal.add(lblEmail);
		
		JLabel lblContr = new JLabel("Contraseña:");
		lblContr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContr.setBounds(79, 346, 78, 22);
		panelPrincipal.add(lblContr);
		
		JLabel lblConfContr = new JLabel("Confirmar Contraseña:");
		lblConfContr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConfContr.setBounds(79, 390, 146, 22);
		panelPrincipal.add(lblConfContr);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setFocusPainted(false);
		btnAtras.setBounds(79, 453, 89, 23);
		panelPrincipal.add(btnAtras);
		
		JButton btnRegistrar = new JButton("Registrarse");
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setBounds(301, 453, 108, 23);
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
		tFEmail.setBounds(246, 302, 133, 20);
		panelPrincipal.add(tFEmail);
		
		tFPass1 = new JPasswordField();
		tFPass1.setColumns(10);
		tFPass1.setBounds(246, 348, 133, 20);
		panelPrincipal.add(tFPass1);
		
		tFPass2 = new JPasswordField();
		tFPass2.setColumns(10);
		tFPass2.setBounds(246, 392, 133, 20);
		panelPrincipal.add(tFPass2);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(79, 210, 78, 22);
		panelPrincipal.add(lblNombre);
		
		tFNombre = new JTextField();
		tFNombre.setColumns(10);
		tFNombre.setBounds(246, 212, 133, 20);
		panelPrincipal.add(tFNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellido.setBounds(79, 253, 78, 22);
		panelPrincipal.add(lblApellido);
		
		tFApellido = new JTextField();
		tFApellido.setColumns(10);
		tFApellido.setBounds(246, 255, 133, 20);
		panelPrincipal.add(tFApellido);
		
		btnRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodosGUI mGUI = new MetodosGUI();
				String password1 = new String(tFPass1.getPassword());
				String password2 = new String(tFPass2.getPassword());
				if(!mGUI.validarNombre(tFNombre.getText())) {
					mGUI.mensajeError(tFNombre, "Escribe un nombre");
				}
				else if(!mGUI.validarNombre(tFApellido.getText())) {
					mGUI.mensajeError(tFApellido, "Escribe un apellido");
				}
				else if(mGUI.validarUsuario(tFUs.getText())) {
					mGUI.mensajeError(tFUs, "Introduce un usuario (debe contener 5 o más caracteres)");
				}
				else if(!mGUI.validarContrasenya(password1)) {
					mGUI.mensajeError(tFPass1, "Introduce una contraseña valida (8 o más caracteres)");
				}
				else if(!mGUI.validarConfContrasenya(password1, password2)) {
					mGUI.mensajeError(tFPass2, "Las Contraseñas no coinciden");
				}
				else if(!mGUI.validarEmail(tFEmail.getText())) {
					mGUI.mensajeError(tFEmail, "Escribe un Email valido");
				}else {
					Usuario usuario = new Usuario(tFUs.getText(), tFNombre.getText(), tFApellido.getText(), tFEmail.getText(), password1);
					Response response = Controller.getInstance().registrarUsuario(usuario);
				        if (response.getStatus() == Status.OK.getStatusCode()) {
				            JOptionPane.showMessageDialog(null, "Usuario creado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				        } else {
				            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
				        }
				}
			}
		});
	}
	
	
	public void setVisible(boolean b) {
		frame.setVisible(true);
	}
}
