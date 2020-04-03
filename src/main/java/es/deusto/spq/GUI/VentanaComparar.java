package es.deusto.spq.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JSeparator;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import es.deusto.spq.data.Imagen;
import es.deusto.spq.data.Piso;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class VentanaComparar {

	private JFrame jFComp;
	private JScrollPane scroll;
	private JTextArea tADesc1, tADesc2;
	private Piso piso1, piso2;
	private List<Imagen> listaImagenes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaComparar window = new VentanaComparar();
					window.jFComp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaComparar() {
		listaImagenes = new ArrayList<Imagen>();
		listaImagenes.add(new Imagen("1", "descarga.png"));
		piso1 = new Piso();
		piso1.setNombre("aaaa");
    	piso1.setId(1);
    	piso1.setCoste(3.0);
    	piso1.setDesc("Piso en barakaldo");
    	piso1.setnHab(4);
    	piso1.setImagenes(listaImagenes);
    	piso1.setLocalizacion("bbb");
		piso2 = new Piso();
		piso2.setNombre("bbbb");
    	piso2.setId(1);
    	piso2.setCoste(3.0);
    	piso2.setDesc("Piso en cruces");
    	piso2.setnHab(2);
    	piso2.setImagenes(listaImagenes);
    	piso2.setLocalizacion("ccc");
		initialize(piso1, piso2);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Piso piso1, Piso piso2) {
		jFComp = new JFrame();
		jFComp.setTitle("Comparación");
		jFComp.setBounds(100, 100, 600, 465);
		jFComp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFComp.setResizable(false);
		JPanel panelPrincipal = new JPanel();
		jFComp.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		
		JPanel pPComp1 = new JPanel();
		pPComp1.setBorder(new LineBorder(new Color(0, 0, 0)));
		pPComp1.setBounds(36, 67, 222, 338);
		panelPrincipal.add(pPComp1);
		pPComp1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblpiso1 = new JLabel("Piso1");
		lblpiso1.setHorizontalAlignment(SwingConstants.CENTER);
		pPComp1.add(lblpiso1, BorderLayout.NORTH);
		
		JPanel pComp1 = new JPanel();
		pPComp1.add(pComp1, BorderLayout.CENTER);
		pComp1.setLayout(null);
		
		JLabel lblFoto1 = new JLabel();
		lblFoto1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		lblFoto1.setIcon(new ImageIcon(piso1.getImagenes().get(0).getUrl()));
		lblFoto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto1.setBounds(62, 11, 95, 95);
		pComp1.add(lblFoto1);
		
		JPanel pInfo1 = new JPanel();
		pInfo1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pInfo1.setBounds(10, 117, 202, 156);
		pComp1.add(pInfo1);
		pInfo1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInfoTit1 = new JLabel("Información");
		lblInfoTit1.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo1.add(lblInfoTit1, BorderLayout.NORTH);
		
		JPanel subPInfo1 = new JPanel();
		pInfo1.add(subPInfo1, BorderLayout.CENTER);
		subPInfo1.setLayout(null);
		
		JLabel lblDesc1 = new JLabel("Descripción:");
		lblDesc1.setBounds(10, 11, 86, 14);
		subPInfo1.add(lblDesc1);
		
		JLabel lblPrecioTit1 = new JLabel("Precio:");
		lblPrecioTit1.setBounds(10, 70, 49, 14);
		subPInfo1.add(lblPrecioTit1);
		
		JLabel lblPrecio1 = new JLabel(piso1.getCoste() + "€");
		lblPrecio1.setBounds(79, 70, 49, 14);
		subPInfo1.add(lblPrecio1);
		
		JLabel lblNHabTit1 = new JLabel("Nº Habitaciones:");
		lblNHabTit1.setBounds(10, 87, 97, 22);
		subPInfo1.add(lblNHabTit1);
		
		JLabel lblHab1 = new JLabel(piso1.getnHab() + "");
		lblHab1.setBounds(120, 87, 35, 14);
		subPInfo1.add(lblHab1);
		
		JLabel lblLocTit1 = new JLabel("Localización:");
		lblLocTit1.setBounds(10, 112, 86, 14);
		subPInfo1.add(lblLocTit1);
		
		JLabel lblLoc1 = new JLabel(piso1.getLocalizacion());
		lblLoc1.setBounds(100, 112, 69, 14);
		subPInfo1.add(lblLoc1);
		
		JPanel panelDesc1 = new JPanel();
		panelDesc1.setBounds(0, 26, 200, 36);
		subPInfo1.add(panelDesc1);
		panelDesc1.setLayout(new BorderLayout(0, 0));
		
		tADesc1 = new JTextArea(piso1.getDesc());
		tADesc1.setEditable(false);
		scroll = new JScrollPane(tADesc1);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelDesc1.add(scroll, BorderLayout.CENTER);
		
		JPanel pPComp2 = new JPanel();
		pPComp2.setBorder(new LineBorder(new Color(0, 0, 0)));
		pPComp2.setBounds(333, 67, 222, 338);
		panelPrincipal.add(pPComp2);
		pPComp2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPiso2 = new JLabel("Piso2");
		lblPiso2.setHorizontalAlignment(SwingConstants.CENTER);
		pPComp2.add(lblPiso2, BorderLayout.NORTH);
		
		JPanel pComp2 = new JPanel();
		pPComp2.add(pComp2, BorderLayout.CENTER);
		pComp2.setLayout(null);
		
		JLabel lblFoto2 = new JLabel();
		lblFoto2.setIcon(new ImageIcon(piso2.getImagenes().get(0).getUrl()));
		lblFoto2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		lblFoto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto2.setBounds(64, 11, 95, 95);
		pComp2.add(lblFoto2);
		
		JPanel pInfo2 = new JPanel();
		pInfo2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pInfo2.setBounds(10, 117, 202, 156);
		pComp2.add(pInfo2);
		pInfo2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInfoTit2 = new JLabel("Información");
		lblInfoTit2.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo2.add(lblInfoTit2, BorderLayout.NORTH);
		
		JPanel subPInfo2 = new JPanel();
		pInfo2.add(subPInfo2, BorderLayout.CENTER);
		subPInfo2.setLayout(null);
		
		JLabel lblDesc2 = new JLabel("Descripción:");
		lblDesc2.setBounds(10, 11, 86, 14);
		subPInfo2.add(lblDesc2);
		
		JLabel lblPrecioTit2 = new JLabel("Precio:");
		lblPrecioTit2.setBounds(10, 72, 49, 14);
		subPInfo2.add(lblPrecioTit2);
		
		JLabel lblPrecio2 = new JLabel("20€");
		lblPrecio2.setBounds(83, 72, 49, 14);
		subPInfo2.add(lblPrecio2);
		
		JLabel lblNHabTit2 = new JLabel("Nº Habitaciones:");
		lblNHabTit2.setBounds(10, 87, 97, 24);
		subPInfo2.add(lblNHabTit2);
		
		JLabel lblHab2 = new JLabel(piso2.getnHab() +"");
		lblHab2.setBounds(120, 87, 35, 14);
		subPInfo2.add(lblHab2);
		
		JLabel lblLocTit2 = new JLabel("Localización:");
		lblLocTit2.setBounds(10, 112, 86, 14);
		subPInfo2.add(lblLocTit2);
		
		JLabel lblLoc2 = new JLabel(piso2.getLocalizacion());
		lblLoc2.setBounds(100, 112, 69, 14);
		subPInfo2.add(lblLoc2);
		
		JPanel panelDesc2 = new JPanel();
		panelDesc2.setBounds(0, 25, 200, 36);
		subPInfo2.add(panelDesc2);
		panelDesc2.setLayout(new BorderLayout(0, 0));
		
		tADesc2 = new JTextArea(piso2.getDesc());
		tADesc2.setEditable(false);
		scroll = new JScrollPane(tADesc2);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelDesc2.add(scroll, BorderLayout.CENTER);
		
		JLabel lblComp = new JLabel("COMPARACIÓN");
		lblComp.setHorizontalAlignment(SwingConstants.CENTER);
		lblComp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblComp.setBounds(221, 14, 141, 41);
		panelPrincipal.add(lblComp);
	}
}
