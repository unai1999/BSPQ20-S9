package es.deusto.spq.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.ws.rs.client.Client;

import es.deusto.spq.data.Mensaje;
import es.deusto.spq.data.Usuario;

public class VentanaVerMensaje extends JFrame {
	private Client client;
	private static final long serialVersionUID = 1L;
	private MetodosGUI m = new MetodosGUI();
	
	private int ancho = 620;
	private int alto = 480;
	
	public VentanaVerMensaje(Mensaje m) {
		
		setSize(ancho, alto);
		setTitle("Lista de mensajes");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel cuerpo = new JLabel();
	    cuerpo.setText(m.getCuerpo());
	    cuerpo.setBounds(23,  -150, ancho , 500);
	    getContentPane().add(cuerpo);
	    
	    
		JLabel titulo = new JLabel();
		titulo.setText(m.getTitulo());
        titulo.setBounds(23, 20, 200, 20);
        getContentPane().add(titulo);
		
        
       
        
        
        setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		Mensaje m = new Mensaje("1", "Deberes", "Hola noseque toma");
		VentanaVerMensaje vm = new VentanaVerMensaje(m);
	}
	
}
