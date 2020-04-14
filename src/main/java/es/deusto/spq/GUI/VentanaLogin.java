package es.deusto.spq.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class VentanaLogin {

	private JFrame frame;
	private JTextField tFLogin;
	private JTextField tFCont;
	private JTextField tFCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin window = new VentanaLogin();
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
	public VentanaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 637, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelPrincipal = new JPanel();
		frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		
		JLabel lblLoginTit = new JLabel("Usuario:");
		lblLoginTit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLoginTit.setBounds(124, 136, 90, 30);
		panelPrincipal.add(lblLoginTit);
		
		tFLogin = new JTextField();
		tFLogin.setBounds(293, 141, 140, 20);
		panelPrincipal.add(tFLogin);
		tFLogin.setColumns(10);
		
		JLabel lblContrasenya = new JLabel("Contraseña:");
		lblContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContrasenya.setBounds(123, 199, 90, 30);
		panelPrincipal.add(lblContrasenya);
		
		tFCont = new JTextField();
		tFCont.setColumns(10);
		tFCont.setBounds(293, 205, 140, 20);
		panelPrincipal.add(tFCont);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFocusPainted(false);
		btnLogin.setBounds(356, 262, 89, 23);
		panelPrincipal.add(btnLogin);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFocusPainted(false);
		btnRegistrarse.setBounds(107, 262, 107, 23);
		panelPrincipal.add(btnRegistrarse);
		
		JLabel lblRecContr = new JLabel("¿No recuerdas tu contraseña?");
		lblRecContr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRecContr.setBounds(10, 353, 204, 20);
		panelPrincipal.add(lblRecContr);
		
		JLabel lblCorreoTit = new JLabel("Introduce tu correo:");
		lblCorreoTit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCorreoTit.setBounds(10, 383, 122, 20);
		panelPrincipal.add(lblCorreoTit);
		
		tFCorreo = new JTextField();
		tFCorreo.setColumns(10);
		tFCorreo.setBounds(142, 381, 140, 20);
		panelPrincipal.add(tFCorreo);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFocusPainted(false);
		btnEnviar.setBounds(309, 380, 89, 23);
		panelPrincipal.add(btnEnviar);
		
		btnRegistrarse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VentanaRegistro vReg = new VentanaRegistro();
				vReg.setVisible(true);
				
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
	}
}
