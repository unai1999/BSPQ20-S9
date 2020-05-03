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

import es.deusto.spq.data.Factura;

import es.deusto.spq.data.Usuario;

public class VentanaFacturas extends JFrame{
    
    private static final long serialVersionUID = 1L;
	
	private int ancho = 620;
	private int alto = 480;
	
	
	private static JList<String> lista = new JList<String>();
	private static DefaultListModel<String> listaModelo = new DefaultListModel<String>();
	private static ArrayList<Factura> facturas = new ArrayList<>();
	
	public VentanaFacturas(Usuario user) {
		
	    //facturas = (ArrayList<MensajePrivado>) Controller.getInstance().getFacturas());
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
       
        
        if(!facturas.isEmpty()){
			for(Factura f : facturas) {
        	
				listaModelo.addElement(f.toString());
				
			}
		}
       
        
        lista.setModel(listaModelo);
		
        
        
        getContentPane().add(lista);
        
		setVisible(true);
		
		lista.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent evt) {
				
				 JList list = (JList)evt.getSource();
				if(evt.getClickCount() == 2) {
					int index = list.locationToIndex(evt.getPoint());
					//VentanaVerFactura vf = new VentanaVerFactura();
					//VentanaVerMensaje vm = new VentanaVerMensaje(user.getMensajes().get(index));
					System.out.println("Doble click");
				}
				
			}
			
			
		});
		
		
		btnNuevoMensaje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new VentanaNuevoMensaje();
				
			}
        });
    }
}