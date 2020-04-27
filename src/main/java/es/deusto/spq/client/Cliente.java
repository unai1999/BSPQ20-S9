//package es.deusto.spq.client;
//
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.List;
//
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Invocation;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.Status;
//import javax.ws.rs.core.GenericType;
//
//import es.deusto.spq.GUI.TextPrompt;
//import es.deusto.spq.GUI.VentanaListaPisos;
//import es.deusto.spq.GUI.VentanaListaPosts;
//import es.deusto.spq.data.Piso;
//import es.deusto.spq.data.Post;
//import es.deusto.spq.data.Usuario;
//import es.deusto.spq.server.*;
//import javax.swing.JTextArea;
//
//
//
//public class Cliente {
//
//    private Client client;
//	private WebTarget webTarget;
//
//    private JFrame frame;
//    private JPanel panel;
//    private JButton b;
//
//	private JTextField textFieldNick;
//	private JTextField textFieldNombre;
//	private JTextField textFieldApellido;
//	private JTextField textFieldEmail;
//	private JPasswordField textFieldPassword;
//	private JButton btnNewButton;
//
//    public Cliente(String hostname, String port) {    
//
//
//        DAOFactory.getInstance().createPisoDAO().crearAlgunosDatos();
//        DAOFactory.getInstance().createPostDAO().crearPosts();
//
//        client = ClientBuilder.newClient();
//        webTarget = client.target(String.format("http://%s:%s/rest", hostname, port));
//        
//        // Creating instance of JFrame
//        frame = new JFrame("Inicio");
//        // Setting the width and height of frame
//        frame.setSize(300, 300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        panel = new JPanel();  
//       
//        
//        frame.getContentPane().add(panel);
//        panel.setLayout(null);
//     
//       
//        // Creating login button
//        b = new JButton("Entrar");
//        b.setBounds(193, 222, 81, 28);
//
//        panel.add(b);
//        
//        textFieldNick = new JTextField();
//        textFieldNick.setBounds(75, 35, 137, 28);
//        new TextPrompt("Introduce tu nick", textFieldNick);
//        panel.add(textFieldNick);
//        textFieldNick.setColumns(10);
//        
//        textFieldNombre = new JTextField();
//        textFieldNombre.setBounds(75, 74, 137, 28);
//        new TextPrompt("Introduce tu nombre", textFieldNombre);
//        panel.add(textFieldNombre);
//        textFieldNombre.setColumns(10);
//        
//        textFieldApellido = new JTextField();
//        textFieldApellido.setBounds(75, 113, 137, 28);
//        new TextPrompt("Introduce tu apellido", textFieldApellido);
//        panel.add(textFieldApellido);
//        textFieldApellido.setColumns(10);
//        
//        textFieldEmail = new JTextField();
//        textFieldEmail.setBounds(75, 152, 137, 28);
//        new TextPrompt("Introduce tu email", textFieldEmail);
//        panel.add(textFieldEmail);
//        textFieldEmail.setColumns(10);
//        
//        textFieldPassword = new JPasswordField();
//        textFieldPassword.setBounds(75, 191, 137, 28);
//        new TextPrompt("Introduce tu contraseña", textFieldPassword);
//        panel.add(textFieldPassword);
//        
//        JTextArea textArea = new JTextArea("¡Bienvenido! Rellena los siguientes\n datos para continuar.");
//        textArea.setBounds(51, 2, 198, 32);
//        panel.add(textArea);
//        textArea.setEditable(false);
//        
//        btnNewButton = new JButton("Posts");
//        btnNewButton.setBounds(10, 225, 89, 23);
//        panel.add(btnNewButton);
//        
//        btnNewButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				List<Post> posts = new ArrayList<Post>();
//            	posts = getPost();
//            	new VentanaListaPosts(posts, posts, hostname, port);
//				
//			}
//		});
//        
//        b.addActionListener(new ActionListener() {
//			
//			@SuppressWarnings("deprecation")
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				if((textFieldNick.getText().length() > 0) && (textFieldNombre.getText().length() > 0) && (textFieldApellido.getText().length() > 0) && (textFieldEmail.getText().length() > 0) && (textFieldPassword.getText().length() > 0)) {
//					Usuario u1 = new Usuario(textFieldNick.getText(), textFieldNombre.getText(), textFieldApellido.getText(), textFieldEmail.getText(), textFieldPassword.getText());
//					List<Piso> pisos = new ArrayList<Piso>();
//	            	pisos = getPisos();
//	                new VentanaListaPisos(pisos, pisos, hostname, port, u1);
//	                frame.dispose();
//	                
//				}else {
//					frame.dispose();
//					new Cliente(hostname, port);
//				}
//	
//			}
//		});
//
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//
//       
//    }
//    public Piso getPiso(String id){
//        Piso piso = null;
//        WebTarget pisoWebTarget = webTarget.path("pisos/" + id);
//        GenericType<Piso> genericType = new GenericType<Piso>(){}; 
//        piso = pisoWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
//       
//        return piso;
//    }
//
//    public List<Piso> getPisos(){
//        List<Piso> pisos = new ArrayList<Piso>();
//        WebTarget pisosWebTarget = webTarget.path("pisos");
//        GenericType<List<Piso>> genericType = new GenericType<List<Piso>>(){}; 
//        pisos = pisosWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
//        for (Piso p : pisos){
//            System.out.println(p);
//        }
//        return pisos;
//    }
//    
//    public void getInfo(){
//        WebTarget donationsWebTarget = webTarget.path("pisos/1");
//		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
//        Response response = invocationBuilder.get();
//        System.out.println(response.getStatus());
//		if (response.getStatus() == Status.OK.getStatusCode()) {
//            JOptionPane.showMessageDialog(null, "OK");
//		} else {
//            JOptionPane.showMessageDialog(null, "ERROR");
//            
//		}
//    }
//    
//	public List<Post> getPost(){
//        List<Post> posts = new ArrayList<Post>();
//        WebTarget pisosWebTarget = webTarget.path("pisos/post");
//        GenericType<List<Post>> genericType = new GenericType<List<Post>>(){}; 
//        posts = pisosWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
//        for (Post p : posts){
//            System.out.println(p);
//        }
//        return posts;
//    }
//
//    public static void main(String[] args) {
//		String hostname = args[0];
//		String port = args[1];
//
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//               new Cliente(hostname,port);
//            }
//        });
//	}
//}