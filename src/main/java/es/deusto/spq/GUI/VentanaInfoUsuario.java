package es.deusto.spq.GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import es.deusto.spq.client.Controller;
import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Usuario;
import es.deusto.spq.server.DAOFactory;

import javax.swing.JButton;

/**
 * Clase de la interfaz de la información de un usuario.
 * @author unai
 */

public class VentanaInfoUsuario extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldNick;
	private JTextField textFieldPass;
	
	/**
	 * Constructor de la ventana que muestra la información de un usuario.
	 * @param u1 el usuario del cual se va a mostrar la informacion
	 */
	public VentanaInfoUsuario(Usuario u1) {
	
        
		setSize(480, 400);
		setTitle("Perfil de usuario");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		
		Font fuente = new Font("Arial", Font.BOLD, 17);
		Font fuente1 = new Font("Arial", Font.BOLD, 13);
		
		JLabel labelTitulo = new JLabel("Perfil de Usuario");
		labelTitulo.setBounds(170, 35, 130, 30);
		labelTitulo.setFont(fuente);
		getContentPane().add(labelTitulo);
		
		JLabel labelNombre = new JLabel("Nombre: ");
		labelNombre.setBounds(40, 90, 80, 23);
		labelNombre.setFont(fuente1);
		getContentPane().add(labelNombre);
		
		JLabel labelApellido = new JLabel("Apellido: ");
		labelApellido.setBounds(40, 135, 80, 23);
		labelApellido.setFont(fuente1);
		getContentPane().add(labelApellido);
		
		JLabel labelEmail = new JLabel("Email: ");
		labelEmail.setBounds(40, 180, 80, 23);
		labelEmail.setFont(fuente1);
		getContentPane().add(labelEmail);
		
		JLabel labelNick = new JLabel("Nick: ");
		labelNick.setBounds(40, 225, 80, 23);
		labelNick.setFont(fuente1);
		getContentPane().add(labelNick);
		
		JLabel labelPass = new JLabel("Contraseña: ");
		labelPass.setBounds(40, 270, 80, 23);
		labelPass.setFont(fuente1);
		getContentPane().add(labelPass);
		
		textFieldNombre = new JTextField(u1.getNombre());
		textFieldNombre.setBounds(169, 90, 250, 23);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		textFieldNombre.setEditable(false);
		textFieldNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		textFieldApellido = new JTextField(u1.getApellidos());
		textFieldApellido.setBounds(169, 135, 250, 23);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		textFieldApellido.setEditable(false);
		textFieldApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		textFieldEmail = new JTextField(u1.getEmail());
		textFieldEmail.setBounds(169, 180, 250, 23);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		textFieldEmail.setEditable(false);
		textFieldEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		textFieldNick = new JTextField(u1.getNickname());
		textFieldNick.setBounds(169, 225, 250, 23);
		getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		textFieldNick.setEditable(false);
		textFieldNick.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		textFieldPass = new JTextField(u1.getPw1());
		textFieldPass.setBounds(169, 270, 250, 23);
		getContentPane().add(textFieldPass);
		textFieldPass.setColumns(10);
		textFieldPass.setEditable(false);
		textFieldPass.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JButton botonEditarDatos = new JButton("Editar datos de la cuenta");
		botonEditarDatos.setBounds(143, 337, 180, 23);
		getContentPane().add(botonEditarDatos);
		
		JButton botonGuardar = new JButton("Guardar datos");
		botonGuardar.setBounds(325, 337, 140, 23);
		getContentPane().add(botonGuardar);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.setBounds(10, 337, 110, 23);
		getContentPane().add(botonAtras);
		botonGuardar.setVisible(false);
		
		setVisible(true);
		
		botonEditarDatos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldNombre.setEditable(true);
				textFieldApellido.setEditable(true);
				textFieldEmail.setEditable(true);
				botonEditarDatos.setVisible(false);
				botonGuardar.setVisible(true);
				
			}
		});
		botonGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				//guardar datos en la base de datos
				DAOFactory.getInstance().createUsuarioDAO().actaulizarDatosUsuario(textFieldNick.getText(), textFieldNombre.getText(), textFieldApellido.getText(), textFieldEmail.getText(), textFieldPass.getText());
				Usuario user = DAOFactory.getInstance().createUsuarioDAO().getUsuario(textFieldNick.getText());
				new VentanaInfoUsuario(user);
			}
		});
	    botonAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				List<Piso> pisos = new ArrayList<Piso>();
				pisos = Controller.getInstance().getPisos();
				dispose();
				new VentanaListaPisos(pisos, pisos);
				
			}
		});
	        
	}
	
}
