package es.deusto.spq.GUI;

import javax.swing.*;

import javax.ws.rs.core.Response;

import javax.ws.rs.core.Response.Status;

import es.deusto.spq.client.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioForo extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JPanel panel, pA, pB;
    JLabel lTitulo, lContenido;
    JTextField tTitulo;
    JTextArea tContenido;
    JButton bEnviar;

    public FormularioForo() {


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

        
        Response response = Controller.getInstance().publicarPost(tTitulo.getText(), "Autor", tContenido.getText());
        // Post p = response.readEntity(Post.class);
        if (response.getStatus() == Status.OK.getStatusCode()) {
            JOptionPane.showMessageDialog(null, "Post creado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();

    }

    public static void main(String[] args) {
        

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               new FormularioForo();
            }
        });
    }

}