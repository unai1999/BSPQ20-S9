package es.deusto.spq.GUI;


import static javax.swing.JOptionPane.ERROR_MESSAGE;

import java.util.List;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.jdo.PersistenceManagerFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
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
import javax.ws.rs.core.MediaType;

import es.deusto.spq.data.Imagen;
import es.deusto.spq.data.Piso;
import es.deusto.spq.server.PisoDAO;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.DropMode;



public class VentanaListaPisos extends JFrame {

    private static final long serialVersionUID = 1L;

    
    private JTextField textBuscarPiso;
	private TextPrompt placeholder;
	private JScrollPane scroll;
	private Client client;
	private WebTarget webTarget;
	
    

    public VentanaListaPisos(ArrayList<Piso> pisos, ArrayList<Piso> pisosBuscados) {
    	
    	client = ClientBuilder.newClient();
    	webTarget = client.target("http://localhost:8080/alquilerapp");
    	
    	
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
        		new VentanaListaPisos(pisos, pisosBuscados);
        		
        	}
        });
        btnBuscar.setBounds(432, 10, 100, 23);
        getContentPane().add(btnBuscar);
        
        JLabel labelFotoUsuario = new JLabel("");
        labelFotoUsuario.setBounds(562, 10, 25, 25);
        getContentPane().add(labelFotoUsuario);
        labelFotoUsuario.setIcon(new ImageIcon("descarga.png"));
        
        JPanel panelListaPisos= new JPanel();
        panelListaPisos.setBounds(10, 46, 594, 509);
        getContentPane().add(panelListaPisos);
        JTextArea textoPisos = new JTextArea();
        textoPisos.setColumns(50);
        textoPisos.setEditable(false);
        Font font1 = new Font("Arial", Font.ITALIC, 12);
        textoPisos.setFont(font1);
        textoPisos.setBounds(10, 30, 490, 425);
        scroll = new JScrollPane(textoPisos);
        scroll.setBounds(10, 55, 490, 425);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelListaPisos.add(scroll);
        
        JButton botonVolverAtras = new JButton("Inicio");
        botonVolverAtras.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		dispose();
        		new VentanaListaPisos(pisos, pisos);
        	}
        });
        botonVolverAtras.setBounds(480, 417, 120, 23);
        getContentPane().add(botonVolverAtras);
        
        if(pisosBuscados.size() > 0) {
        for(int i = 0; i < pisosBuscados.size(); i++) {
        	textoPisos.append("Nombre del piso:" + pisosBuscados.get(i).getNombre().toUpperCase() + "\n" + "Precio: " + pisosBuscados.get(i).getCoste()+ "\n"+ "Valoración: " + pisosBuscados.get(i).getValoracion()+ "/5"+ "\n\n");
         
        }
        }else {
        	scroll.setVisible(false);
        	panelListaPisos.setVisible(false);
        	JLabel labelNoPisos = new JLabel("No se encontraron pisos.");
        	labelNoPisos.setBounds(200, 50, 150, 50);
        	getContentPane().add(labelNoPisos);
        }
        textoPisos.addMouseListener(new MouseAdapter() {
            @Override
       	    public void mousePressed(MouseEvent e) {
          	 try {
					int line = textoPisos.getLineOfOffset( textoPisos.getCaretPosition() );
					int start = textoPisos.getLineStartOffset( line );
					int end = textoPisos.getLineEndOffset( line );
					String text = textoPisos.getDocument().getText(start, end - start);
					
					if(text.contains("piso")) {
						String[] partes = text.split(":");
						String nombre = partes[1];
						nombre = nombre.toLowerCase();
						nombre = nombre.replaceAll("\n", "");
						for(int i = 0; i < pisos.size(); i++) {
							if(nombre.contentEquals(pisos.get(i).getNombre())) {
								//Piso piso = getPiso(pisos.get(i).getId());
								//System.out.println(piso.getNombre());
								//new VentanaInformacion(piso);
								dispose();
							}
						}
						
					}else if(text.contains("Precio")) {
						line = line - 1;
						start = textoPisos.getLineStartOffset( line );
						end = textoPisos.getLineEndOffset( line );
						text = textoPisos.getDocument().getText(start, end - start);
						String[] partes = text.split(":");
						String nombre = partes[1];
						nombre = nombre.toLowerCase();
						nombre = nombre.replaceAll("\n", "");
						for(int i = 0; i < pisos.size(); i++) {
							if(nombre.contentEquals(pisos.get(i).getNombre())) {
								//Piso piso = getPiso(pisos.get(i).getId());
								//System.out.println(piso.getNombre());
								//new VentanaInformacion(piso);
								 dispose();
							}
						}
					}else if(text.contains("Valora")) {
						line = line - 2; 
						start = textoPisos.getLineStartOffset( line );
						end = textoPisos.getLineEndOffset( line );
						text = textoPisos.getDocument().getText(start, end - start);
						String[] partes = text.split(":");
						String nombre = partes[1];
						nombre = nombre.toLowerCase();
						nombre = nombre.replaceAll("\n", "");
						for(int i = 0; i < pisos.size(); i++) {
							if(nombre.contentEquals(pisos.get(i).getNombre())) {
								//Piso piso = getPiso(pisos.get(i).getId());
								//System.out.println(piso.getNombre());
								//new VentanaInformacion(piso);
								 dispose();
								
							}
						}
						
					}
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
       	    }
          	
			});
        
        
        labelFotoUsuario.addMouseListener (new MouseAdapter() {
        	 @Override
        	    public void mousePressed(MouseEvent e) {
        		 dispose();
        		 // aqui deberia redirigir a la ventana con el perfil
        	      
        	    }
		});
        
        
        setResizable(false);
        setVisible(true);
        
    }
    public Piso getPiso(long id){
        Piso piso = null;
        WebTarget pisoWebTarget = webTarget.path("pisos/" + id);
        GenericType<Piso> genericType = new GenericType<Piso>(){}; 
        piso = pisoWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
      
        return piso;
    }
    
    public List<Piso> getPisos(){
        List<Piso> pisos = new ArrayList<Piso>();
        WebTarget pisosWebTarget = webTarget.path("pisos");
        GenericType<List<Piso>> genericType = new GenericType<List<Piso>>(){}; 
        pisos = pisosWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
        for (Piso p : pisos){
            System.out.println(p);
        }
        return pisos;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
        
            @Override
            public void run() {
            	ArrayList<Piso> pisos = new ArrayList<Piso>();
            	Piso piso1 = new Piso();
            	piso1.setNombre("aaaa");
            	piso1.setId(1);
            	piso1.setCoste(3.0);
            	piso1.setAlquilado(false);
            	piso1.setLocalizacion("bbb");
            	piso1.setValoracion(3);
            	pisos.add(piso1);
            	
            	Piso piso2 = new Piso();
            	piso2.setNombre("aaaa b");
            	piso2.setId(2);
            	piso2.setCoste(5.0);
            	piso2.setAlquilado(false);
            	piso2.setLocalizacion("cccc");
            	piso2.setValoracion(4);
            	pisos.add(piso2);
            	
            	
                new VentanaListaPisos(pisos, pisos);
            }
        });
    }
   
}