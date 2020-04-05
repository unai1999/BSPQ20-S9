package es.deusto.spq.GUI;




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
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import es.deusto.spq.data.Imagen;
import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Usuario;
import java.util.ArrayList;
import javax.swing.JLabel;




public class VentanaListaPisos extends JFrame {

    private static final long serialVersionUID = 1L;

    
    private JTextField textBuscarPiso;
	private JScrollPane scroll;
	private Client client;
	private static WebTarget webTarget;
	private static List<Imagen> listaImagenes;


	private Usuario u1;
	
    

    public VentanaListaPisos(List<Piso> pisos, List<Piso> pisos2) {
    	u1 = new Usuario("eneko98", "Eneko", "Valero", "enekovalero@gmail.com", "123456");
    	
    	client = ClientBuilder.newClient();
    	webTarget = client.target("http://localhost:8080/alquilerapp");
    	
    	
        setSize(620, 480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        
        textBuscarPiso = new JTextField();
        textBuscarPiso.setBounds(10, 11, 397, 20);
        new TextPrompt("Introduce cuidad para buscar piso", textBuscarPiso);
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
								new VentanaInformacion(pisos.get(i), u1);
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
								new VentanaInformacion(pisos.get(i), u1);
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
								new VentanaInformacion(pisos.get(i), u1);
								 dispose();
							}
						}
						
					}
				} catch (BadLocationException e1) {
					
				}
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
        
            @Override
            public void run() {
            	
//            	listaImagenes = new ArrayList<Imagen>();
//        		listaImagenes.add(new Imagen("1", "descarga.png"));
//        		listaImagenes.add(new Imagen("2", "descarga.png"));
//        		listaImagenes.add(new Imagen("3", "descarga.png"));
        		
            	List<Piso> pisos = new ArrayList<Piso>();
            	pisos = getPisos();
//            	Piso piso1 = new Piso();
//            	piso1.setNombre("aaaa");
//            	piso1.setId(1);
//            	piso1.setCoste(3.0);
//            	piso1.setDesc("Piso en barakaldo");
//            	piso1.setAlquilado(false);
//            	piso1.setnHab(4);
//            	piso1.setLocalizacion("bbb");
//            	piso1.setValoracion(3);
//            	piso1.setImagenes(listaImagenes);
//            	pisos.add(piso1);
//            	
//            	Piso piso2 = new Piso();
//            	piso2.setNombre("aaaa b");
//            	piso2.setId(2);
//            	piso2.setCoste(5.0);
//            	piso2.setDesc("Piso en Bilbao");
//            	piso2.setAlquilado(false);
//            	piso2.setnHab(5);
//            	piso2.setLocalizacion("cccc");
//            	piso2.setValoracion(4);
//            	piso2.setImagenes(listaImagenes);
//            	pisos.add(piso2);
      
                new VentanaListaPisos(pisos, pisos);
            }
        });
    }
    public static List<Piso> getPisos(){
        List<Piso> pisos = new ArrayList<Piso>();
        WebTarget pisosWebTarget = webTarget.path("pisos");
        GenericType<List<Piso>> genericType = new GenericType<List<Piso>>(){}; 
        pisos = pisosWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
        for (Piso p : pisos){
            System.out.println(p);
        }
        return pisos;
    }
//  public Piso getPiso(long id){
//  Piso piso = null;
//  WebTarget pisoWebTarget = webTarget.path("pisos/" + id);
//  GenericType<Piso> genericType = new GenericType<Piso>(){}; 
//  piso = pisoWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
//
//  return piso;
//}

}