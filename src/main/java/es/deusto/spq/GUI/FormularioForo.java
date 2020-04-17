package es.deusto.spq.GUI;

import javax.swing.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import es.deusto.spq.data.Post;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioForo extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Client client;
    WebTarget webTarget;

    JPanel panel, pA, pB;
    JLabel lTitulo, lContenido;
    JTextField tTitulo;
    JTextArea tContenido;
    JButton bEnviar;

    public FormularioForo(final String hostname, final String port) {

        client = ClientBuilder.newClient();
        webTarget = client.target(String.format("http://%s:%s/rest", hostname, port));

        panel = new JPanel(new FlowLayout());
        panel.setLayout(null);
        lTitulo = new JLabel("Título");
        lContenido = new JLabel("Contenido");
        tTitulo = new JTextField();
        tContenido = new JTextArea();
        final JScrollPane sp = new JScrollPane(tContenido);
        bEnviar = new JButton("Enviar");

        lTitulo.setBounds(10, 10, 200, 25);
        tTitulo.setBounds(100, 10, 300, 25);
        lContenido.setBounds(10, 40, 80, 25);
        sp.setBounds(100, 40, 300, 300);
        bEnviar.setBounds(10, 80, 80, 25);

        bEnviar.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				publicarPost();
	
			}
		});

        panel.add(lTitulo);
        panel.add(tTitulo);
        panel.add(lContenido);
        panel.add(sp);
        panel.add(bEnviar);

        this.setPreferredSize(new Dimension(450, 400));
        this.setContentPane(panel);
        this.setTitle("Nuevo post");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void publicarPost() {

        final WebTarget publicarTarget = webTarget.path("pisos/foro/submit");
        final Post post = new Post(tTitulo.getText(), "Autor", tContenido.getText());
        final Entity<Post> entity = Entity.entity(post, MediaType.APPLICATION_JSON);
        final Response response = publicarTarget.request().post(entity);
        // Post p = response.readEntity(Post.class);
        if (response.getStatus() == Status.OK.getStatusCode()) {
            JOptionPane.showMessageDialog(null, "Post creado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();

    }

    public static void main(final String[] args) {
        final String hostname = args[0];
        final String port = args[1];

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               new FormularioForo(hostname,port);
            }
        });
    }

}