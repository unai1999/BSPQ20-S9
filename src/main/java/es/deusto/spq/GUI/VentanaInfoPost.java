package es.deusto.spq.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import es.deusto.spq.client.Controller;
import es.deusto.spq.data.ComentarioPost;
import es.deusto.spq.data.Post;
import es.deusto.spq.server.DAOFactory;

/**
 * Esta ventana contiene los detalles correspondientes de un Post concreto
 * @author jonuraga
 *
 */
public class VentanaInfoPost {
	
	private JFrame jFPost;
	private JTextArea taContenido;
	private JTextField tfNewComent;
	private JTextArea taComents;
	private JScrollPane scroll;
	private final static String LINEA_NUEVA = "\n";
	
	/**
	 * Constructor de la ventana que llama al método que inicializa todas sus variables y hace visible la ventana
	 * @param post Post del que se quiere visualizar la información
	 */
	public VentanaInfoPost(Post post) {
		initialize(post);
		jFPost.setVisible(true);
	}

	/**
	 * Método que inicializa las variables de la ventana
	 * @param post Post del que se quiere visualizar la información
	 */
	private void initialize(Post post) {
		
		
		jFPost = new JFrame();
		jFPost.setTitle("Información de Post");
		jFPost.setBounds(100, 100, 500, 500);
		jFPost.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFPost.setResizable(true);
		jFPost.getContentPane().setLayout(new BorderLayout(0, 0));
		jFPost.setLocationRelativeTo(null);
		JPanel globalPanel = new JPanel();
		jFPost.getContentPane().add(globalPanel, BorderLayout.CENTER);
		globalPanel.setLayout( new BorderLayout(0, 0));
		
		
		// PANEL DE BOTONES
		JPanel buttonsPanel = new JPanel();
		globalPanel.add(buttonsPanel, BorderLayout.NORTH);
		buttonsPanel.setLayout( new BorderLayout(0, 0));
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setHorizontalAlignment(SwingConstants.LEFT);
		btnAtras.setFocusPainted(false);
		buttonsPanel.add(btnAtras, BorderLayout.WEST);
		
		
		//PANEL DE INFORMACIÓN
		JPanel infoPanel = new JPanel();
		globalPanel.add(infoPanel, BorderLayout.CENTER);
		infoPanel.setLayout(null);
		
		//PANEL CON TITULO, FECHA Y CONTENIDO
		JPanel panel = new JPanel();
		panel.setBounds(10, 30, 300, 137);
		infoPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblTituloTit = new JLabel("Título: ");
		lblTituloTit.setBounds(10, 11, 70, 14);
		panel.add(lblTituloTit);
		
		JLabel lblTitulo = new JLabel();
		lblTitulo.setText(post.getTitulo());
		lblTitulo.setBounds(90, 11, 204, 14);
		panel.add(lblTitulo);
		
		JLabel lblFechaTit = new JLabel("Fecha: ");
		lblFechaTit.setBounds(10, 37, 61, 16);
		panel.add(lblFechaTit);
		
		JLabel lblFecha = new JLabel();
		lblFecha.setText(post.getFecha());
		lblFecha.setBounds(90, 37, 204, 16);
		panel.add(lblFecha);
		
		JPanel panelContenido = new JPanel();
		panelContenido.setBounds(10, 82, 284, 49);
		panel.add(panelContenido);
		panelContenido.setLayout( new BorderLayout(0, 0));
		
		JLabel lblContenido = new JLabel("Contenido");
		lblContenido.setBounds(10, 65, 84, 16);
		panel.add(lblContenido);
		
		taContenido = new JTextArea();
		taContenido.setEditable(false);
		taContenido.setText(post.getContenido());
		scroll = new JScrollPane(taContenido);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelContenido.add(scroll, BorderLayout.CENTER);
		
		
		// PANEL DE AUTOR
		JPanel panelAutor = new JPanel();
		panelAutor.setBounds(322, 30, 172, 59);
		infoPanel.add(panelAutor);
		
		JLabel lblAutorTit = new JLabel("Autor: ");
		lblAutorTit.setVerticalAlignment(SwingConstants.TOP);
		lblAutorTit.setHorizontalAlignment(SwingConstants.LEFT);
		panelAutor.add(lblAutorTit);
		
		JLabel lblAutor = new JLabel();
		lblAutor.setText(post.getAutor());
		panelAutor.add(lblAutor);

		
		// PANEL DE LIKES
		JPanel likesPanel = new JPanel();
		likesPanel.setBounds(322, 101, 172, 66);
		infoPanel.add(likesPanel);
		
		JLabel lblLikesTit = new JLabel("Likes: ");
		lblLikesTit.setVerticalAlignment(SwingConstants.TOP);
		lblLikesTit.setHorizontalAlignment(SwingConstants.LEFT);
		likesPanel.add(lblLikesTit);
		
		JLabel lblLikes = new JLabel();
		lblLikes.setText(Integer.toString(post.getLikes()));
		likesPanel.add(lblLikes);
		
		
		// PANEL DE COMENTARIOS
		JPanel comentsPanel = new JPanel();
		comentsPanel.setBorder( new LineBorder( new Color(0, 0, 0)));
		comentsPanel.setBounds(10, 170, 484, 225);
		infoPanel.add(comentsPanel);
		comentsPanel.setLayout( new BorderLayout(0, 0));
		
		taComents = new JTextArea();
		taComents.setEditable(false);
		scroll = new JScrollPane(taComents);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		comentsPanel.add(scroll);
		
		JPanel subComentsPanel = new JPanel();
		comentsPanel.add(subComentsPanel, BorderLayout.NORTH);
		subComentsPanel.setLayout( new BorderLayout(0, 0));
		
		JLabel lblComent = new JLabel("Comentarios");
		lblComent.setHorizontalAlignment(SwingConstants.LEFT);
		subComentsPanel.add(lblComent, BorderLayout.WEST);
		
		JPanel newComentPanel = new JPanel();
		comentsPanel.add(newComentPanel, BorderLayout.SOUTH);
		newComentPanel.setLayout( new BorderLayout(0, 0));
		
		tfNewComent = new JTextField();
		List<ComentarioPost> comentarios = DAOFactory.getInstance().createComentarioPostDAO().getComentarios(post);
		if(comentarios != null) {
			for(ComentarioPost s : comentarios) {
				taComents.append(s.getTexto() + LINEA_NUEVA);
				tfNewComent.selectAll();
				taComents.setCaretPosition(taComents.getDocument().getLength());	
			}
		}
		newComentPanel.add(tfNewComent);
		tfNewComent.setColumns(10);
		
		JLabel lblNewComent = new JLabel("Escribe un comentario");
		newComentPanel.add(lblNewComent, BorderLayout.NORTH);
		
		tfNewComent.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String texto = tfNewComent.getText();
				taComents.append(texto + LINEA_NUEVA);
				tfNewComent.selectAll();
				taComents.setCaretPosition(taComents.getDocument().getLength());
				DAOFactory.getInstance().createComentarioPostDAO().guardarComentario(new ComentarioPost(post, texto));
			}
		});
		
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Post> posts = new ArrayList<Post>();
				posts = Controller.getInstance().getPost();
				new VentanaListaPosts(posts, posts);
				jFPost.dispose();
				
			}
		});
		
		
	}
}
