package es.deusto.spq.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import es.deusto.spq.data.Mensaje;
import es.deusto.spq.data.Usuario;

public class VentanaMensajes extends JFrame{
	
	private Client client;
	private static final long serialVersionUID = 1L;
	private MetodosGUI m = new MetodosGUI();
	
	private int ancho = 620;
	private int alto = 480;
	
	
	private static JList<String> lista = new JList<String>();
	private static DefaultListModel<String> listaModelo = new DefaultListModel<String>();
	private static ArrayList<Mensaje> mensajes = new ArrayList<>();
	
	public VentanaMensajes(String hostname, String port, Usuario user) {
		
//		client = ClientBuilder.newClient();
//		client.target(String.format("http://%s:%s/rest", hostname, port));
	    
		setSize(ancho, alto);
		setTitle("Lista de mensajes");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JButton btnNuevoMensaje = new JButton("Nuevo Mensaje");
        btnNuevoMensaje.setBounds(23, 11, 200, 20);
        getContentPane().add(btnNuevoMensaje);
		
        
        
		
        lista.setBounds(0,  100, 620, 353);    
       
        mensajes =  user.getMensajes();
        
        
        for(Mensaje m : mensajes) {
        	
        	listaModelo.addElement(" " + m.getId() + ":  " + m.getTitulo()+ "             ");
        	
        }
        
        lista.setModel(listaModelo);
		
        
        
        getContentPane().add(lista);
        
		setVisible(true);
		
		lista.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent evt) {
				
				 JList list = (JList)evt.getSource();
				if(evt.getClickCount() == 2) {
					int index = list.locationToIndex(evt.getPoint());
					
					VentanaVerMensaje vm = new VentanaVerMensaje(user.getMensajes().get(index));
					System.out.println("Doble click");
				}
				
			}
			
			
		});
		
		
		btnNuevoMensaje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new VentanaNuevoMensaje(hostname, port);
				
			}
		});
	}
	
//	public static void main(String[] args) {
//		
//		Usuario user = new Usuario("Hola", "1234");
//		
//		ArrayList<Mensaje> mensajes = new ArrayList<>();
//		Mensaje m = new Mensaje("1", "Correo", "Blablablabla");
//		Mensaje mw = new Mensaje("2", "Apuntes", "Ayudame porfavor");
//		mensajes.add(m);
//		mensajes.add(mw);
//		user.setMensajes(mensajes);
//		
//		VentanaMensajes vm = new VentanaMensajes(null, null, user);
//	}
	

}