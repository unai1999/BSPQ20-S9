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

import es.deusto.spq.client.Controller;
import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Post;
import es.deusto.spq.server.DAOFactory;

import javax.swing.JLabel;
/**
 * Clase de la interfaz de la lista de pisos.
 * @author unai
 */

public class VentanaListaPisos extends JFrame {

    private static final long serialVersionUID = 1L;

    
    private JTextField textBuscarPiso;
	private JScrollPane scroll;
	private MetodosGUI m = new MetodosGUI();

	/**
	 * Constructor de la ventana de la lista de pisos.
	 * @param pisos
	 * @param pisos2
	 */
	public VentanaListaPisos(List<Piso> pisos, List<Piso> pisos2) {
    	
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
        labelFotoMensaje.setIcon(new ImageIcon("resources/mensaje.png"));
        
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
		
		JButton btnFormulario = new JButton("Formulario");
		btnFormulario.setBounds(40, 387, 120, 23);
		getContentPane().add(btnFormulario);
		
		
        
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
						DAOFactory.getInstance().createPisoDAO().actualizarVisitasPiso(m.obtenerPiso(text, pisos).getNombre());
						new VentanaInformacion(m.obtenerPiso(text, pisos),Controller.getInstance().getUsuario());
						
					}else if(text.contains("Precio")) {
						line = line - 1;
						start = textoPisos.getLineStartOffset( line );
						end = textoPisos.getLineEndOffset( line );
						text = textoPisos.getDocument().getText(start, end - start);
						dispose();
						DAOFactory.getInstance().createPisoDAO().actualizarVisitasPiso(m.obtenerPiso(text, pisos).getNombre());
						new VentanaInformacion(m.obtenerPiso(text, pisos), Controller.getInstance().getUsuario());
					}else if(text.contains("Valora")) {
						line = line - 2;
						start = textoPisos.getLineStartOffset( line );
						end = textoPisos.getLineEndOffset( line );
						text = textoPisos.getDocument().getText(start, end - start);
						dispose();
						DAOFactory.getInstance().createPisoDAO().actualizarVisitasPiso(m.obtenerPiso(text, pisos).getNombre());
						new VentanaInformacion(m.obtenerPiso(text, pisos), Controller.getInstance().getUsuario());
					}
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				;
				
       	    }
			}
			});
        btnFormulario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaFormularioPisos();
				
			}
		});
        botonListaPosts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				List<Post> posts = new ArrayList<Post>();
				posts = Controller.getInstance().getPost();
				new VentanaListaPosts(posts, posts);
				
			}
		});
        labelFotoUsuario.addMouseListener (new MouseAdapter() {
        	 @Override
        	    public void mousePressed(MouseEvent e) {
        		 dispose();
        		 new VentanaInfoUsuario(Controller.getInstance().getUsuario());
        	      
        	    }
		});
        
        labelFotoMensaje.addMouseListener(new MouseAdapter() {
        	
        	public void mousePressed(MouseEvent e) {
        		
        		new VentanaMensajes(Controller.getInstance().getUsuario());
        		
        	}
        	
		});
        
        botonVolverAtras.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		dispose();
        		new VentanaLogin();
        	}
        });
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		new VentanaListaPisos(pisos, m.buscarPisos(textBuscarPiso.getText(), pisos));
        		
        	}
        });
        botonInicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                new VentanaListaPisos(pisos, pisos);
                dispose();
			}
		});
        botonComparar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaComparar(pisos.get(0), pisos.get(1));
				dispose();
				
			}
		});
        
        setResizable(false);
        setVisible(true);
        
    }
}