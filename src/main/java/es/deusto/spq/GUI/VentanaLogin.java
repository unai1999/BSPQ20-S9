package es.deusto.spq.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import es.deusto.spq.client.Controller;
import es.deusto.spq.data.Idioma;
import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Usuario;
import es.deusto.spq.server.DAOFactory;
import es.deusto.spq.server.SendEmail;

public class VentanaLogin {

	private JFrame frame;
	private JTextField tFLogin;
	private JPasswordField tFCont;
	private JTextField tFCorreo;

	MetodosGUI mGUI = new MetodosGUI();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//System.out.println("Puerto: " + port);
					//System.out.println("Hostname: "+ hostname);
					VentanaLogin window = new VentanaLogin(new Idioma("Español"));
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
	public VentanaLogin(Idioma idioma) {
		initialize(idioma);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Idioma idioma) {
		
		//DAOFactory.getInstance().createPisoDAO().crearAlgunosDatos();
        //DAOFactory.getInstance().createPostDAO().crearPosts();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 637, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		JPanel panelPrincipal = new JPanel();
		frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
	
		
		JMenuBar mb = new JMenuBar();       
        JMenu m1 = new JMenu(idioma.getProperty("Idioma"));       
        mb.add(m1);       
        JMenuItem m11 = new JMenuItem(idioma.getProperty("Español"));       
        JMenuItem m22 = new JMenuItem(idioma.getProperty("Ingles"));       
        m1.add(m11);       
        m1.add(m22);        
		
        frame.getContentPane().add(mb, BorderLayout.NORTH);
        
        m11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new VentanaLogin(new Idioma("Español"));
				
			}
		});
        
        m22.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new VentanaLogin(new Idioma("Ingles"));
			}
		});
        
        
		JLabel lblLoginTit = new JLabel(idioma.getProperty("Usuario") + ":");
		lblLoginTit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLoginTit.setBounds(124, 136, 90, 30);
		panelPrincipal.add(lblLoginTit);
		
		tFLogin = new JTextField();
		tFLogin.setBounds(293, 141, 140, 20);
		panelPrincipal.add(tFLogin);
		tFLogin.setColumns(10);
		
		JLabel lblContrasenya = new JLabel(idioma.getProperty("Contrasenya") + ":");
		lblContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContrasenya.setBounds(123, 199, 90, 30);
		panelPrincipal.add(lblContrasenya);
		
		tFCont = new JPasswordField();
		tFCont.setColumns(10);
		tFCont.setBounds(293, 205, 140, 20);
		panelPrincipal.add(tFCont);
		
		JButton btnLogin = new JButton(idioma.getProperty("Login"));
		btnLogin.setFocusPainted(false);
		btnLogin.setBounds(356, 262, 89, 23);
		panelPrincipal.add(btnLogin);
		
		JButton btnRegistrarse = new JButton(idioma.getProperty("Registrarse"));
		btnRegistrarse.setFocusPainted(false);
		btnRegistrarse.setBounds(107, 262, 107, 23);
		panelPrincipal.add(btnRegistrarse);
		
		JLabel lblRecContr = new JLabel(idioma.getProperty("NoRecuerdasTuContrasenya"));
		lblRecContr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRecContr.setBounds(10, 353, 204, 20);
		panelPrincipal.add(lblRecContr);
		
		JLabel lblCorreoTit = new JLabel(idioma.getProperty("Introducetucorreo"));
		lblCorreoTit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCorreoTit.setBounds(10, 383, 122, 20);
		panelPrincipal.add(lblCorreoTit);
		
		tFCorreo = new JTextField();
		tFCorreo.setColumns(10);
		tFCorreo.setBounds(142, 381, 140, 20);
		panelPrincipal.add(tFCorreo);
		
		JButton btnEnviar = new JButton(idioma.getProperty("Enviar"));
		btnEnviar.setFocusPainted(false);
		btnEnviar.setBounds(309, 380, 89, 23);
		panelPrincipal.add(btnEnviar);

		frame.setVisible(true);
		MetodosGUI mgui = new MetodosGUI();
		btnEnviar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				
				if(mgui.validarEmail(tFCorreo.getText())){
					SendEmail se = new SendEmail();
					String generatedCode = se.enviarMail(tFCorreo.getText());
					String inputCode = JOptionPane.showInputDialog(frame, "Introduce el código recibido: ");

					if(generatedCode.equals(inputCode)){
						new VentanaResetPassword(tFCorreo.getText());
					}else{
						JOptionPane.showMessageDialog(null, "Wrong code", "oops", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Invalid email", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}

		
		});
		
		btnRegistrarse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new VentanaRegistro(idioma);
				
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodosGUI mGUI = new MetodosGUI();
				String password1 = new String(tFCont.getPassword());
				if(!mGUI.validarUsuario(tFLogin.getText())) {
					//mGUI.mensajeError(tFLogin, "Introduce un usuario valido");
				}
				
				if(!mGUI.validarContrasenya(password1)){
					mGUI.mensajeError(tFCont, "Introduce una contraseña valida (8 o más caracteres)");
				
				}else{
					Response r = Controller.getInstance().login(tFLogin.getText(), password1);
					System.out.println(r);
					if(r.getStatus() == Status.OK.getStatusCode()){
						JOptionPane.showMessageDialog(null, "Login", "Successful", JOptionPane.INFORMATION_MESSAGE);
						List<Piso> pisos = new ArrayList<Piso>();
						pisos = Controller.getInstance().getPisos();
						Usuario u1 = DAOFactory.getInstance().createUsuarioDAO().getUsuario(tFLogin.getText());

						Controller.getInstance().setUsuario(u1);


						new VentanaListaPisos(pisos, pisos);
						frame.dispose();
						
						pisos = Controller.getInstance().getPisos();
					}else{
						JOptionPane.showMessageDialog(null, "Login", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}				
				
			}
		});
	}
}
