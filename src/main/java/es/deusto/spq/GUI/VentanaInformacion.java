package es.deusto.spq.GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.LineBorder;

import es.deusto.spq.client.Controller;
import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Usuario;
import es.deusto.spq.server.DAOFactory;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;

public class VentanaInformacion {

	private JFrame jFInfo;
	private JTextField tFComent;
	private JTextArea tAComent, tADesc;
	private JScrollPane scroll;
	private final static String LINEA_NUEVA = "\n";


	
	public VentanaInformacion(Piso piso, Usuario user) {
		initialize(piso, user);
		jFInfo.setVisible(true);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Piso piso, Usuario usuario) {
		
		
		jFInfo = new JFrame();
		jFInfo.setTitle("Información");
		jFInfo.setBounds(100, 100, 500, 500);
		jFInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFInfo.setResizable(false);
		jFInfo.getContentPane();
		jFInfo.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipal = new JPanel();
		jFInfo.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotones = new JPanel();
		panelPrincipal.add(panelBotones, BorderLayout.NORTH);
		panelBotones.setLayout(new BorderLayout(0, 0));
		
		JButton btnContactar = new JButton("Contactar");
		btnContactar.setHorizontalAlignment(SwingConstants.LEFT);
		btnContactar.setFocusPainted(false);
		panelBotones.add(btnContactar, BorderLayout.EAST);
		
		btnContactar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jFInfo.dispose();
				// aqui implementaremos la funcionalidad para que se pueda contactar con el dueño de la casa
				
			}
		});
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setHorizontalAlignment(SwingConstants.RIGHT);
		btnAtras.setFocusPainted(false);
		panelBotones.add(btnAtras, BorderLayout.WEST);
		
		
		JPanel panelSec = new JPanel();
		panelPrincipal.add(panelSec, BorderLayout.CENTER);
		panelSec.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInfo = new JLabel("INFORMACIÓN");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelSec.add(lblInfo, BorderLayout.NORTH);
		
		JPanel panelInfo = new JPanel();
		panelSec.add(panelInfo, BorderLayout.CENTER);
		panelInfo.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 30, 322, 119);
		panelInfo.add(panel);
		panel.setLayout(null);
		
		JLabel lblDescTitulo = new JLabel("Descrición");
		lblDescTitulo.setBounds(10, 11, 70, 14);
		panel.add(lblDescTitulo);
		
		JLabel lblCosteTitulo = new JLabel("Coste:");
		lblCosteTitulo.setBounds(13, 70, 40, 14);
		panel.add(lblCosteTitulo);
		
		JLabel lblCoste = new JLabel();
		lblCoste.setText(piso.getCoste()+ "€");
		lblCoste.setBounds(63, 70, 49, 14);
		panel.add(lblCoste);
		
		JLabel lblHabTitulo = new JLabel("Nº de Habitaciones:");
		lblHabTitulo.setBounds(136, 70, 116, 14);
		panel.add(lblHabTitulo);
		
		JLabel lblHab = new JLabel();
		lblHab.setText(String.valueOf(piso.getnHab()));
		lblHab.setBounds(262, 70, 40, 14);
		panel.add(lblHab);
		
		JPanel panelDesc = new JPanel();
		panelDesc.setBounds(0, 25, 322, 34);
		panel.add(panelDesc);
		panelDesc.setLayout(new BorderLayout(0, 0));
		
		tADesc = new JTextArea();
		tADesc.setEditable(false);
		tADesc.setText(piso.getDesc());
		scroll = new JScrollPane(tADesc);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelDesc.add(scroll, BorderLayout.CENTER);
		
		JLabel lblLocTit = new JLabel("Localización:");
		lblLocTit.setBounds(10, 94, 86, 14);
		panel.add(lblLocTit);
		
		JLabel lblLoc = new JLabel();
		lblLoc.setText(piso.getLocalizacion());
		lblLoc.setBounds(95, 94, 64, 14);
		panel.add(lblLoc);
		
		JPanel panelFotos = new JPanel();
		panelFotos.setBounds(19, 265, 459, 131);
		panelInfo.add(panelFotos);
		panelFotos.setLayout(null);
		
		JLabel lblFoto1 = new JLabel();
		lblFoto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto1.setBounds(0, 0, 119, 131);
		panelFotos.add(lblFoto1);
		
		JLabel lblFoto2 = new JLabel();
		lblFoto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto2.setBounds(101, 0, 119, 131);
		panelFotos.add(lblFoto2);
		
		JLabel lblFoto3 = new JLabel();
		lblFoto3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto3.setBounds(209, 0, 119, 131);
		panelFotos.add(lblFoto3);
		
		JLabel lblFoto4 = new JLabel();
		lblFoto4.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto4.setBounds(338, 0, 119, 131);
		panelFotos.add(lblFoto4);
		
		if(piso.getImagenes() != null) {
		if(piso.getImagenes().size() == 1) {
			lblFoto1.setIcon(new ImageIcon(piso.getImagenes().get(0).getUrl()));
			lblFoto2.setText("Sin imagen");
			lblFoto3.setText("Sin imagen");
			lblFoto4.setText("Sin imagen");
		}
		else if(piso.getImagenes().size() == 2) {
			lblFoto1.setIcon(new ImageIcon(piso.getImagenes().get(0).getUrl()));
			lblFoto2.setIcon(new ImageIcon(piso.getImagenes().get(1).getUrl()));
			lblFoto3.setText("Sin imagen");
			lblFoto4.setText("Sin imagen");
			
		}else if(piso.getImagenes().size() == 3) {
			lblFoto2.setIcon(new ImageIcon(piso.getImagenes().get(1).getUrl()));
			lblFoto3.setIcon(new ImageIcon(piso.getImagenes().get(2).getUrl()));
			lblFoto4.setText("Sin imagen");
			
		}else {
			lblFoto2.setIcon(new ImageIcon(piso.getImagenes().get(1).getUrl()));
			lblFoto3.setIcon(new ImageIcon(piso.getImagenes().get(2).getUrl()));
			lblFoto4.setIcon(new ImageIcon(piso.getImagenes().get(3).getUrl()));
			
		}
		}else {
			lblFoto1.setText("Sin imagen");
			lblFoto2.setText("Sin imagen");
			lblFoto3.setText("Sin imagen");
			lblFoto4.setText("Sin imagen");
		}
		
		JPanel panelUs = new JPanel();
		panelUs.setBounds(342, 30, 136, 35);
		panelInfo.add(panelUs);
		
		JLabel lblUsTitulo = new JLabel("Usuario:");
		lblUsTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblUsTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		panelUs.add(lblUsTitulo);
		
		JLabel lblUs = new JLabel();
		lblUs.setText(usuario.getNickname());
		panelUs.add(lblUs);
		
		JPanel panelComentarios = new JPanel();
		panelComentarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelComentarios.setBounds(10, 160, 468, 94);
		panelInfo.add(panelComentarios);
		panelComentarios.setLayout(new BorderLayout(0, 0));
		
		tAComent = new JTextArea();
		tAComent.setEditable(false);
		scroll = new JScrollPane(tAComent);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelComentarios.add(scroll, BorderLayout.CENTER);
		
		JPanel subPComent = new JPanel();
		panelComentarios.add(subPComent, BorderLayout.NORTH);
		subPComent.setLayout(new BorderLayout(0, 0));
		
		JLabel lblComent = new JLabel("Comentarios:");
		lblComent.setHorizontalAlignment(SwingConstants.LEFT);
		subPComent.add(lblComent, BorderLayout.WEST);
		
		JPanel panelEsc = new JPanel();
		panelComentarios.add(panelEsc, BorderLayout.SOUTH);
		panelEsc.setLayout(new BorderLayout(0, 0));
		
		tFComent = new JTextField();
		panelEsc.add(tFComent);
		tFComent.setColumns(10);
		
		JLabel lblEsc = new JLabel("Escribe un comentario...");
		panelEsc.add(lblEsc, BorderLayout.NORTH);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.setBounds(215, 398, 89, 23);
		panelInfo.add(btnReservar);
		
		JButton btnMapa = new JButton("Ver mapa");
		btnMapa.setBounds(389, 398, 89, 23);
		panelInfo.add(btnMapa);
		
		JButton btnEstadisticas = new JButton("Ver estadisticas");
		btnEstadisticas.setBounds(29, 398, 128, 23);
		panelInfo.add(btnEstadisticas);
		
		btnEstadisticas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jFInfo.dispose();
				//System.out.println(piso.getVecesVisitado());
				new VentanaEstadisticasPiso(piso, usuario);
				
			}
		});
		
		btnMapa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jFInfo.dispose();
				new Mapa(piso, usuario);
				
			}
		});
		
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Piso> pisos = new ArrayList<Piso>();
				jFInfo.dispose();
				
				pisos = Controller.getInstance().getPisos();
				new VentanaListaPisos(pisos, pisos);
				
			}
		});
		
		btnReservar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jFInfo.dispose();
				// aqui implementaremos la funcionalidad para reservar
				new VentanaPago(piso);
				
			}
		});
		
		tFComent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String texto = tFComent.getText();
				tAComent.append(texto + LINEA_NUEVA); 
				tFComent.selectAll();
				tAComent.setCaretPosition(tAComent.getDocument().getLength());
				
			}
		});
		
		
	}
}
