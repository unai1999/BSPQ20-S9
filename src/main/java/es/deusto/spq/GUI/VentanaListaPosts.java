package es.deusto.spq.GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import es.deusto.spq.data.Post;

public class VentanaListaPosts extends JFrame{
	

	private JScrollPane scroll;
	private JTextField textBuscarPost;
	private static final long serialVersionUID = 1L;
	private MetodosGUI m = new MetodosGUI();
	
	public VentanaListaPosts(List<Post> posts, List<Post> posts2) {
	    
		setSize(620, 480);
		setTitle("Lista de posts");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		
		textBuscarPost = new JTextField();
		textBuscarPost.setBounds(23, 11, 397, 20);
        new TextPrompt("Introduce usuario para buscar sus posts", textBuscarPost);
        getContentPane().add(textBuscarPost);
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(467, 11, 100, 24);
        getContentPane().add(btnBuscar);
		
		JPanel panelListaPost= new JPanel();
		panelListaPost.setBounds(10, 46, 594, 350);
        getContentPane().add(panelListaPost);
        
        JTextArea textoPost = new JTextArea();
        textoPost.setColumns(50);
        textoPost.setRows(20);
        textoPost.setEditable(false);
        
        Font font1 = new Font("Arial", Font.ITALIC, 12);
        textoPost.setFont(font1);
        textoPost.setBounds(10, 46, 594, 229);
        scroll = new JScrollPane(textoPost);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelListaPost.add(scroll);
		
		
		if(posts2.size() > 0) {
			textoPost.setText("Titulo: " + posts2.get(0).getTitulo().toUpperCase() + "\n" + "Descripción: " + posts2.get(0).getContenido() +"\n" + "Autor: " + posts2.get(0).getAutor() + "\n" + "Likes: " + posts2.get(0).getLikes() +"\n\n");
			for(int i = 1; i < posts2.size(); i++) {
				textoPost.append("Titulo: " + posts2.get(i).getTitulo().toUpperCase() + "\n" + "Descripción: " + posts2.get(i).getContenido() +"\n" + "Autor: " + posts2.get(i).getAutor() + "\n" + "Likes: " + posts2.get(i).getLikes() +"\n\n");
			}
		}else {
        	scroll.setVisible(false);
        	panelListaPost.setVisible(false);
        	JLabel labelNoPost = new JLabel("No se encontró ningun post.");
        	labelNoPost.setBounds(200, 50, 200, 50);
        	getContentPane().add(labelNoPost);
        }
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
        		new VentanaListaPosts(posts, m.buscarPosts(textBuscarPost, posts));
				
			}
		});
		textoPost.addMouseListener(new MouseAdapter() {
			
			@Override
       	    public void mousePressed(MouseEvent e) {
				if(e.getClickCount() == 2) {
					try {
						int line = textoPost.getLineOfOffset( textoPost.getCaretPosition());
						int start = textoPost.getLineStartOffset( line );
						int end = textoPost.getLineEndOffset( line );
						String text = textoPost.getDocument().getText(start, end - start).toLowerCase();
						if(text.contains("titulo")) {
							System.out.println(m.obtenerPost(text, posts).getTitulo());
						}else if(text.contains("descripción")) {
							line = line - 1;
							start = textoPost.getLineStartOffset( line );
							end = textoPost.getLineEndOffset( line );
							text = textoPost.getDocument().getText(start, end - start).toLowerCase();
							System.out.println(m.obtenerPost(text, posts).getTitulo());
							
						}else if(text.contains("autor")) {
							line = line - 2;
							start = textoPost.getLineStartOffset( line );
							end = textoPost.getLineEndOffset( line );
							text = textoPost.getDocument().getText(start, end - start).toLowerCase();
							System.out.println(m.obtenerPost(text, posts).getTitulo());
							
						}else if(text.contains("likes")) {
							line = line - 3;
							start = textoPost.getLineStartOffset( line );
							end = textoPost.getLineEndOffset( line );
							text = textoPost.getDocument().getText(start, end - start).toLowerCase();
							System.out.println(m.obtenerPost(text, posts).getTitulo());
							
						}
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				}
				
			}
			
		});
		setVisible(true);
		
	}
	

}
