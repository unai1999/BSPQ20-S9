package es.deusto.spq.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.GenericType;

import es.deusto.spq.data.Piso;
import es.deusto.spq.server.*;



public class Cliente implements ActionListener{

    private Client client;
	private WebTarget webTarget;

    JFrame frame;
    JPanel panel;
    JButton b;
    JTextField tf;

    private Thread thread;
	private final AtomicBoolean running = new AtomicBoolean(false);

    public Cliente(String hostname, String port) {    


        DAOFactory.getInstance().createPisoDAO().crearAlgunosDatos();

        client = ClientBuilder.newClient();
        webTarget = client.target(String.format("http://%s:%s/rest", hostname, port));
        
        // Creating instance of JFrame
        frame = new JFrame("My First Swing Example");
        // Setting the width and height of frame
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();  
       
        
        frame.add(panel);
        
        tf = new JTextField();  
        panel.add(tf);

       
        // Creating login button
        b = new JButton("Button");
        this.b.addActionListener(this);

        panel.add(b);

        frame.setSize(new Dimension(400,200));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

       
    }

    public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();
		if (target == this.b) {
            System.out.println("BUTTON PRESSED");
			this.getPisos();
		}

		
    }
    public Piso getPiso(String id){
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
    
    public void getInfo(){
        WebTarget donationsWebTarget = webTarget.path("pisos/1");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        System.out.println(response.getStatus());
		if (response.getStatus() == Status.OK.getStatusCode()) {
            JOptionPane.showMessageDialog(null, "OK");
		} else {
            JOptionPane.showMessageDialog(null, "ERROR");
            
		}
    }

    public static void main(String[] args) {
		String hostname = args[0];
		String port = args[1];

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               Cliente c = new Cliente(hostname,port);
            }
        });
	}

   

}