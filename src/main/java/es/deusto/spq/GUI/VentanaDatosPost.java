package es.deusto.spq.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Post;
import es.deusto.spq.data.Usuario;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * Clase que contiene la interfaz de los datos del post (datos del post y datos del piso)
 * @author eneko
 */
public class VentanaDatosPost {

	private JFrame frmDatos;
	private JScrollPane scroll;
	private JTextPane tACont, tADescP;
	private Post post;
	private Piso piso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Post post = new Post();
					Piso piso = new Piso();
					VentanaDatosPost window = new VentanaDatosPost(post, piso);
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
	public VentanaDatosPost(Post post, Piso piso) {
		initialize(post, piso);
	}

	/**
	 * Contructor de la ventana que recibe un post y un piso.
	 * @param post Objeto post que se pasa cuando se conecta la ventana
	 * @param piso Objeto piso que se pasa cuando se conecta la ventana
	 */
	private void initialize(Post post, Piso piso) {
		frmDatos = new JFrame();
		frmDatos.setResizable(false);
		frmDatos.setTitle("Datos");
		frmDatos.setBounds(100, 100, 566, 594);
		frmDatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDatos.setLocationRelativeTo(null);
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
		btnCerrar.setFocusPainted(false);
		btnCerrar.setBounds(10, 496, 89, 23);
		subPDatos.add(btnCerrar);
		
		JPanel panelDatosPiso = new JPanel();
		panelDatosPiso.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDatosPiso.setBounds(10, 306, 529, 160);
		subPDatos.add(panelDatosPiso);
		panelDatosPiso.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPisoTit = new JLabel("PISO");
		lblPisoTit.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
		lblPisoTit.setHorizontalAlignment(SwingConstants.CENTER);
		panelDatosPiso.add(lblPisoTit, BorderLayout.NORTH);
		
		JPanel subPDatosPiso = new JPanel();
		panelDatosPiso.add(subPDatosPiso, BorderLayout.CENTER);
		subPDatosPiso.setLayout(null);
		
		JPanel panelNombrePiso = new JPanel();
		panelNombrePiso.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNombrePiso.setBounds(10, 11, 132, 24);
		subPDatosPiso.add(panelNombrePiso);
		
		JLabel lblNombrePTit = new JLabel("Nombre:");
		panelNombrePiso.add(lblNombrePTit);
		
		JLabel lblNombreP = new JLabel(piso.getNombre());
		panelNombrePiso.add(lblNombreP);
		
		JPanel panelCosteP = new JPanel();
		panelCosteP.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCosteP.setBounds(10, 46, 132, 24);
		subPDatosPiso.add(panelCosteP);
		
		JLabel lblCosteTit = new JLabel("Coste:");
		panelCosteP.add(lblCosteTit);
		
		JLabel lblCoste = new JLabel(piso.getCoste()+"€");
		panelCosteP.add(lblCoste);
		
		JPanel panelLocP = new JPanel();
		panelLocP.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelLocP.setBounds(182, 11, 204, 24);
		subPDatosPiso.add(panelLocP);
		
		JLabel lblLocPTit = new JLabel("Localización:");
		panelLocP.add(lblLocPTit);
		
		JLabel lblLocP = new JLabel(piso.getLocalizacion());
		panelLocP.add(lblLocP);
		
		JPanel panelDescP = new JPanel();
		panelDescP.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDescP.setBounds(10, 81, 507, 52);
		subPDatosPiso.add(panelDescP);
		panelDescP.setLayout(new BorderLayout(0, 0));
		
		tADescP = new JTextPane();
		tADescP.setEditable(false);
		scroll = new JScrollPane(tADescP);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelDescP.add(scroll, BorderLayout.CENTER);
		
		JLabel lblDescPTit = new JLabel("Descripción");
		panelDescP.add(lblDescPTit, BorderLayout.NORTH);
		
		JPanel panelValP = new JPanel();
		panelValP.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelValP.setBounds(182, 46, 132, 24);
		subPDatosPiso.add(panelValP);
		
		JLabel lblValPTit = new JLabel("Valoración:");
		panelValP.add(lblValPTit);
		
		JLabel lblValP = new JLabel(piso.getValoracion()+"");
		panelValP.add(lblValP);
		
		JButton btnContactar = new JButton("Contactar");
		btnContactar.setFocusPainted(false);
		btnContactar.setBounds(432, 496, 107, 23);
		subPDatos.add(btnContactar);
		
		btnCerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmDatos.dispose();
				
			}
		});
		
		btnContactar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				new VentanaDatosUsPost(usuario);
				frmDatos.dispose();
			}
		});
		
		frmDatos.setVisible(true);
	}
}
