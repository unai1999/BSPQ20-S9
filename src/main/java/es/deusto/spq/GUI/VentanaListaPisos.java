package es.deusto.spq.GUI;


import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Post;
import es.deusto.spq.data.Usuario;
import javax.swing.JLabel;


public class VentanaListaPisos extends JFrame {

    private static final long serialVersionUID = 1L;

    
    private JTextField textBuscarPiso;
	private JScrollPane scroll;
	private MetodosGUI m = new MetodosGUI();
	private Client client;
	
	public VentanaListaPisos(List<Piso> pisos, List<Piso> pisos2, String hostname, String port, Usuario u1) {
    	
		client = ClientBuilder.newClient();
		
        setSize(620, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        
        textBuscarPiso = new JTextField();
        textBuscarPiso.setBounds(10, 11, 360, 20);
        new TextPrompt("Introduce cuidad para buscar piso", textBuscarPiso);
        getContentPane().add(textBuscarPiso);
        
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(410, 10, 100, 23);
        getContentPane().add(btnBuscar);
        
        JLabel labelFotoMensaje = new JLabel("");
        labelFotoMensaje.setBounds(520, 10, 25, 25);
        getContentPane().add(labelFotoMensaje);
        labelFotoMensaje.setIcon(new ImageIcon("resources/descarga.png"));
        
        JLabel labelFotoUsuario = new JLabel("");
        labelFotoUsuario.setBounds(562, 10, 25, 25);
        getContentPane().add(labelFotoUsuario);
        labelFotoUsuario.setIcon(new ImageIcon("resources/descarga.png"));
        
        JButton botonVolverAtras = new JButton("Salir");
        botonVolverAtras.setBounds(480, 417, 120, 23);
        getContentPane().add(botonVolverAtras);
        
        JButton botonComparar = new JButton("Comparar Pisos");
        botonComparar.setBounds(259, 417, 140, 23);
		getContentPane().add(botonComparar);
		
		JButton botonInicio = new JButton("Inicio");
		botonInicio.setBounds(40, 417, 120, 23);
		getContentPane().add(botonInicio);
        
        JPanel panelListaPisos= new JPanel();
        panelListaPisos.setBounds(10, 46, 594, 330);
        getContentPane().add(panelListaPisos);
        JTextArea textoPisos = new JTextArea();
        textoPisos.setColumns(50);
        textoPisos.setRows(20);
        textoPisos.setEditable(false);
        Font font1 = new Font("Arial", Font.ITALIC, 12);
        textoPisos.setFont(font1);
        textoPisos.setBounds(10, 46, 594, 229);
        scroll = new JScrollPane(textoPisos);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelListaPisos.add(scroll);
		
		JButton botonListaPosts = new JButton("Lista posts");
		botonListaPosts.setBounds(259, 390, 140, 23);
		getContentPane().add(botonListaPosts);
		
        
        if(pisos2.size() > 0) {
        for(int i = 0; i < pisos2.size(); i++) {
        	textoPisos.append("Nombre del piso:" + pisos2.get(i).getNombre().toUpperCase() + "\n" + "Precio: " + pisos2.get(i).getCoste()+ "\n"+ "Valoración: " + pisos2.get(i).getValoracion()+ "/5"+ "\n\n");
         
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
			if(e.getClickCount() == 2) {
				try {
					int line = textoPisos.getLineOfOffset( textoPisos.getCaretPosition());
					int start = textoPisos.getLineStartOffset( line );
					int end = textoPisos.getLineEndOffset( line );
					String text = textoPisos.getDocument().getText(start, end - start);
					
					if(text.contains("piso")) {
						dispose();
						new VentanaInformacion(m.obtenerPiso(text, pisos), u1, hostname, port);
						
					}else if(text.contains("Precio")) {
						line = line - 1;
						start = textoPisos.getLineStartOffset( line );
						end = textoPisos.getLineEndOffset( line );
						text = textoPisos.getDocument().getText(start, end - start);
						dispose();
						new VentanaInformacion(m.obtenerPiso(text, pisos), u1, hostname, port);
					}else if(text.contains("Valora")) {
						line = line - 2;
						start = textoPisos.getLineStartOffset( line );
						end = textoPisos.getLineEndOffset( line );
						text = textoPisos.getDocument().getText(start, end - start);
						dispose();
						new VentanaInformacion(m.obtenerPiso(text, pisos), u1, hostname, port);
					}
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				;
				
       	    }
			}
			});
        
        botonListaPosts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				List<Post> posts = new ArrayList<Post>();
				posts = m.getPost(client.target(String.format("http://%s:%s/rest", hostname, port)));
				new VentanaListaPosts(posts, posts, hostname, port);
				
			}
		});
        labelFotoUsuario.addMouseListener (new MouseAdapter() {
        	 @Override
        	    public void mousePressed(MouseEvent e) {
        		 dispose();
        		 new VentanaInfoUsuario(hostname, port, u1);
        	      
        	    }
		});
        
        labelFotoMensaje.addMouseListener(new MouseAdapter() {
        	
        	public void mousePressed(MouseEvent e) {
        		
        		new VentanaMensajes(hostname, port, u1);
        		
        	}
        	
		});
        
        botonVolverAtras.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		dispose();
        		new Cliente(hostname, port);
        	}
        });
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		new VentanaListaPisos(pisos, m.buscarPisos(textBuscarPiso, pisos), hostname, port, u1);
        		
        	}
        });
        botonInicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                new VentanaListaPisos(pisos, pisos, hostname, port, u1);
                dispose();
			}
		});
        botonComparar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaComparar(pisos.get(0), pisos.get(1), hostname, port, u1);
				dispose();
				
			}
		});
        
        setResizable(false);
        setVisible(true);
        
    }
}