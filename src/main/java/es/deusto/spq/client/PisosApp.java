package es.deusto.spq.client;


import static javax.swing.JOptionPane.ERROR_MESSAGE;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
//import javax.ws.rs.ProcessingException;
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.GenericType;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.Status;
//import javax.ws.rs.core.Response.StatusType;

import es.deusto.spq.data.Piso;
import es.deusto.spq.GUI.TextPrompt;

import java.util.ArrayList;
import javax.swing.JLabel;



public class PisosApp extends JFrame {

    private static final long serialVersionUID = 1L;

    
    //private Client client;
    private JTextField textBuscarPiso;
    private int y;
	private TextPrompt placeholder;
    

    public PisosApp(ArrayList<Piso> pisos, ArrayList<Piso> pisosBuscados) {
//        client = ClientBuilder.newClient();
//
//        final WebTarget appTarget = client.target("http://localhost:8080/alquilerapp");
//        final WebTarget pisosTarget = appTarget.path("pisos");

        setSize(620, 480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        
        textBuscarPiso = new JTextField();
        textBuscarPiso.setBounds(10, 11, 397, 20);
        placeholder = new TextPrompt("Introduce cuidad para buscar piso", textBuscarPiso);
        getContentPane().add(textBuscarPiso);
        
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String cuidad = textBuscarPiso.getText();
        		ArrayList<Piso> pisosBuscados = new ArrayList<Piso>();
        		for(int i = 0 ; i < pisos.size(); i++) {
        			if(pisos.get(i).getLocalizacion().equals(cuidad)) {
        				pisosBuscados.add(new Piso(pisos.get(i)));
        			}
        		}
        		dispose();
        		new PisosApp(pisos, pisosBuscados);
        		
        	}
        });
        btnBuscar.setBounds(432, 10, 100, 23);
        getContentPane().add(btnBuscar);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(562, 10, 25, 25);
        getContentPane().add(lblNewLabel);
        lblNewLabel.setIcon(new ImageIcon("descarga.png"));
        
        JButton botonVolverAtras = new JButton("Inicio");
        botonVolverAtras.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		dispose();
        		new PisosApp(pisos, pisos);
        	}
        });
        botonVolverAtras.setBounds(480, 417, 120, 23);
        getContentPane().add(botonVolverAtras);
        
        y = 55;
        if(pisosBuscados.size() > 0) {
        for(int i = 0; i < pisosBuscados.size(); i++) {
        	JLabel label1 = new JLabel(pisosBuscados.get(i).getNombre().toUpperCase());
        	label1.setBounds(10, y, 100, 50);
            getContentPane().add(label1);
            Font font1 = new Font("Arial", Font.BOLD, 15);
            label1.setFont(font1);
            JLabel labelImagen = new JLabel();
            labelImagen.setBounds(200, y + 10, 400, 50);
            getContentPane().add(labelImagen);
            labelImagen.setIcon(new ImageIcon(pisosBuscados.get(i).getFoto()));
            y += 15;
            JLabel label2= new JLabel("Precio: " + pisosBuscados.get(i).getPrecio());
            label2.setBounds(10, y, 100, 50);
            Font font2 = new Font("Arial", Font.ITALIC, 10);
            label2.setFont(font2);
            y+= 15;
            getContentPane().add(label2);
            JLabel label3 = new JLabel("Valoración: " + pisosBuscados.get(i).getValoracion()+ "/5");
            label3.setBounds(10, y, 100, 50);
            label3.setFont(font2);
            getContentPane().add(label3);
            
            y +=40;
            label1.addMouseListener(new MouseAdapter() {
              @Override
         	    public void mousePressed(MouseEvent e) {
            	 System.out.println("aaa");
         		 dispose();
         		 // aqui deberia ir a la ventana con la info del piso
         	      
         	    }
            	
			});
        }
        }else {
        	JLabel labelNoPisos = new JLabel("No se encontraron pisos.");
        	labelNoPisos.setBounds(200, 50, 150, 50);
        	getContentPane().add(labelNoPisos);
        }
        
        lblNewLabel.addMouseListener (new MouseAdapter() {
        	 @Override
        	    public void mousePressed(MouseEvent e) {
        		 dispose();
        		 // aqui deberia redirigir a la ventana con el perfil
        	      
        	    }
		});
        
        
        setResizable(false);
        setVisible(true);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
        	private ArrayList<Piso> pisos = new ArrayList<Piso>();
            private ArrayList<String> comentarios = new ArrayList<String>();
        
            @Override
            public void run() {
            	comentarios.add("aa");
            	comentarios.add("bb");
            	pisos.add(new Piso(1, "aa b", 123.3f, "bb", comentarios, 3.2f, "descarga.png"));
            	pisos.add(new Piso(2, "cc", 100.3f, "dd", comentarios, 7.2f, "descarga.png"));
                new PisosApp(pisos, pisos);
            }
        });
    }
}