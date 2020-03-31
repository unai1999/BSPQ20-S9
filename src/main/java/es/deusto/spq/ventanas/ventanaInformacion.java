package es.deusto.spq.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;

public class ventanaInformacion {

	//prueba (3)
	private JFrame frame;
	private JTextField tFComent;
	private JTextArea tAComent;
	private JScrollPane scroll;
	private final static String LINEA_NUEVA = "\n";


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaInformacion window = new ventanaInformacion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ventanaInformacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane();
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipal = new JPanel();
		frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotones = new JPanel();
		panelPrincipal.add(panelBotones, BorderLayout.NORTH);
		panelBotones.setLayout(new BorderLayout(0, 0));
		
		JButton btnContactar = new JButton("Contactar");
		btnContactar.setHorizontalAlignment(SwingConstants.LEFT);
		btnContactar.setFocusPainted(false);
		panelBotones.add(btnContactar, BorderLayout.EAST);
		
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
		
		JLabel lblDesc = new JLabel("Piso en las plamas...");
		lblDesc.setBounds(10, 26, 332, 34);
		panel.add(lblDesc);
		
		JLabel lblCosteTitulo = new JLabel("Coste:");
		lblCosteTitulo.setBounds(10, 81, 40, 14);
		panel.add(lblCosteTitulo);
		
		JLabel lblCoste = new JLabel("70€");
		lblCoste.setBounds(63, 81, 49, 14);
		panel.add(lblCoste);
		
		JLabel lblHabTitulo = new JLabel("Nº de Habitaciones:");
		lblHabTitulo.setBounds(146, 81, 116, 14);
		panel.add(lblHabTitulo);
		
		JLabel lblHab = new JLabel("4");
		lblHab.setBounds(272, 81, 40, 14);
		panel.add(lblHab);
		
		JPanel panelFotos = new JPanel();
		panelFotos.setBounds(19, 265, 459, 144);
		panelInfo.add(panelFotos);
		panelFotos.setLayout(null);
		
		JLabel lblFoto1 = new JLabel("Foto1");
		lblFoto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto1.setBounds(0, 0, 119, 145);
		panelFotos.add(lblFoto1);
		
		JLabel lblFoto2 = new JLabel("Foto2");
		lblFoto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto2.setBounds(101, 0, 119, 145);
		panelFotos.add(lblFoto2);
		
		JLabel lblFoto3 = new JLabel("Foto3");
		lblFoto3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto3.setBounds(209, 0, 119, 145);
		panelFotos.add(lblFoto3);
		
		JLabel lblFoto4 = new JLabel("Foto4");
		lblFoto4.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto4.setBounds(338, 0, 119, 145);
		panelFotos.add(lblFoto4);
		
		JPanel panelUs = new JPanel();
		panelUs.setBounds(342, 30, 136, 35);
		panelInfo.add(panelUs);
		
		JLabel lblUsTitulo = new JLabel("Usuario:");
		lblUsTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblUsTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		panelUs.add(lblUsTitulo);
		
		JLabel lblNewLabel = new JLabel("Eneko");
		panelUs.add(lblNewLabel);
		
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
		//panelComentarios.add(scrollPane);
		
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
