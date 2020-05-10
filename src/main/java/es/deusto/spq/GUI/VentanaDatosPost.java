package es.deusto.spq.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import es.deusto.spq.data.Post;

import java.awt.Color;
import javax.swing.JButton;

public class VentanaDatosPost {

	private JFrame frmDatos;
	private JScrollPane scroll;
	private JTextPane tACont;
	private Post post;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDatosPost window = new VentanaDatosPost();
					window.frmDatos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaDatosPost() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDatos = new JFrame();
		frmDatos.setResizable(false);
		frmDatos.setTitle("Datos");
		frmDatos.setBounds(100, 100, 566, 345);
		frmDatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTitDatos = new JLabel("Datos del Post");
		lblTitDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitDatos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmDatos.getContentPane().add(lblTitDatos, BorderLayout.NORTH);
		
		JPanel subPDatos = new JPanel();
		frmDatos.getContentPane().add(subPDatos, BorderLayout.CENTER);
		subPDatos.setLayout(null);
		
		JPanel panelAutor = new JPanel();
		panelAutor.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelAutor.setBounds(379, 73, 160, 26);
		subPDatos.add(panelAutor);
		
		JLabel lblTitAutor = new JLabel("Autor:");
		panelAutor.add(lblTitAutor);
		lblTitAutor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblAutor = new JLabel(post.getAutor());
		panelAutor.add(lblAutor);
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.setBounds(10, 73, 266, 26);
		subPDatos.add(panelTitulo);
		
		JLabel lblTitTitulo = new JLabel("Titulo:");
		panelTitulo.add(lblTitTitulo);
		lblTitTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblTitulo = new JLabel(post.getTitulo());
		panelTitulo.add(lblTitulo);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelFecha = new JPanel();
		panelFecha.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFecha.setBounds(349, 11, 190, 26);
		subPDatos.add(panelFecha);
		
		JLabel lblFechaTit = new JLabel("Fecha:");
		lblFechaTit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelFecha.add(lblFechaTit);
		
		JLabel lblNewLabel = new JLabel(post.getFecha());
		panelFecha.add(lblNewLabel);
		
		JPanel panelContenido = new JPanel();
		panelContenido.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelContenido.setBounds(10, 110, 529, 128);
		subPDatos.add(panelContenido);
		panelContenido.setLayout(new BorderLayout(0, 0));
		
		tACont = new JTextPane();
		tACont.setEditable(false);
		scroll = new JScrollPane(tACont);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelContenido.add(scroll, BorderLayout.CENTER);
		
		JPanel panelLikes = new JPanel();
		panelLikes.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelLikes.setBounds(399, 249, 140, 26);
		subPDatos.add(panelLikes);
		
		JLabel lblLikesTit = new JLabel("Likes:");
		lblLikesTit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelLikes.add(lblLikesTit);
		
		JLabel lblLikes = new JLabel(post.getLikes()+"");
		panelLikes.add(lblLikes);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCerrar.setBounds(20, 249, 89, 23);
		subPDatos.add(btnCerrar);
		
		btnCerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmDatos.dispose();
				
			}
		});
	}
	
}
