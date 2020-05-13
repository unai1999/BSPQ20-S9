package es.deusto.spq.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import es.deusto.spq.data.Factura;
import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Usuario;

import javax.swing.border.BevelBorder;
import javax.swing.JTabbedPane;

/**
 * Clase de la interfaz de los datos de la factura.
 * @author eneko
 */
public class VentanaDatosFactura {

	private JFrame frmDatos;
	private Factura factura;
	private Usuario usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario us = new Usuario("");
					Piso p = new Piso();
					Factura f = new Factura(new Long(100), "", p, us, us);
					VentanaDatosFactura window = new VentanaDatosFactura(f);
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
	public VentanaDatosFactura(Factura factura) {
		initialize(factura);
	}

	/**
	 * Constructor de la ventana de la factura.
	 * @param factura
	 */
	private void initialize(Factura factura) {
		this.factura = factura;
		frmDatos = new JFrame();
		frmDatos.setTitle("Datos");
		frmDatos.setResizable(false);
		frmDatos.setBounds(100, 100, 525, 311);
		frmDatos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmDatos.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblTit = new JLabel("Datos de Factura");
		lblTit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblTit);
		
		JPanel panelPrincipal = new JPanel();
		frmDatos.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		
		JPanel panelFecha = new JPanel();
		panelFecha.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelFecha.setBounds(10, 39, 168, 31);
		panelPrincipal.add(panelFecha);
		panelFecha.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFechaTit = new JLabel("Fecha");
		lblFechaTit.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaTit.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
		panelFecha.add(lblFechaTit, BorderLayout.NORTH);
		
		JLabel lblFecha = new JLabel(factura.getFecha());
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		panelFecha.add(lblFecha, BorderLayout.CENTER);
		
		JPanel panelNFactura = new JPanel();
		panelNFactura.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelNFactura.setBounds(332, 39, 168, 31);
		panelPrincipal.add(panelNFactura);
		panelNFactura.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNFacturaTit = new JLabel("Nº Factura");
		lblNFacturaTit.setHorizontalAlignment(SwingConstants.CENTER);
		lblNFacturaTit.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
		panelNFactura.add(lblNFacturaTit, BorderLayout.NORTH);
		
		JLabel lblNFactura = new JLabel();
		lblNFactura.setText(factura.getId()+ ""); 
		lblNFactura.setHorizontalAlignment(SwingConstants.CENTER);
		panelNFactura.add(lblNFactura, BorderLayout.CENTER);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelDatos.setBounds(10, 93, 490, 64);
		panelPrincipal.add(panelDatos);
		panelDatos.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDatosTit = new JLabel("DATOS");
		lblDatosTit.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosTit.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
		panelDatos.add(lblDatosTit, BorderLayout.NORTH);
		
		JPanel subPanelDatos = new JPanel();
		panelDatos.add(subPanelDatos, BorderLayout.CENTER);
		subPanelDatos.setLayout(null);
		
		JPanel panelCl = new JPanel();
		panelCl.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCl.setBounds(10, 11, 133, 24);
		subPanelDatos.add(panelCl);
		
		JLabel lblClienteTit = new JLabel("Cliente:");
		lblClienteTit.setHorizontalAlignment(SwingConstants.CENTER);
		panelCl.add(lblClienteTit);
		
		JLabel lblCliente = new JLabel();
		lblCliente.setText(factura.getCliente().getNombre());
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		panelCl.add(lblCliente);
		
		JPanel PanelAr = new JPanel();
		PanelAr.setBorder(new LineBorder(new Color(0, 0, 0)));
		PanelAr.setBounds(333, 11, 145, 24);
		subPanelDatos.add(PanelAr);
		
		JLabel lblArrendador = new JLabel("Arrendador:");
		lblArrendador.setHorizontalAlignment(SwingConstants.CENTER);
		PanelAr.add(lblArrendador);
		
		JLabel lblAr = new JLabel();
		lblAr.setText(factura.getArrendador().getNombre());
		lblAr.setHorizontalAlignment(SwingConstants.CENTER);
		PanelAr.add(lblAr);
		
		JPanel panelLoc = new JPanel();
		panelLoc.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelLoc.setBounds(153, 11, 170, 24);
		subPanelDatos.add(panelLoc);
		
		JLabel lblLocTit = new JLabel("Localización:");
		lblLocTit.setHorizontalAlignment(SwingConstants.CENTER);
		panelLoc.add(lblLocTit);
		
		JLabel lblLoc = new JLabel(factura.getPiso().getLocalizacion());
		lblLoc.setHorizontalAlignment(SwingConstants.CENTER);
		panelLoc.add(lblLoc);
		
		JPanel panelImp = new JPanel();
		panelImp.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelImp.setBounds(383, 168, 117, 64);
		panelPrincipal.add(panelImp);
		panelImp.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImpTit = new JLabel("Importe");
		lblImpTit.setHorizontalAlignment(SwingConstants.CENTER);
		lblImpTit.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
		panelImp.add(lblImpTit, BorderLayout.NORTH);
		
		JPanel subPanelImp = new JPanel();
		panelImp.add(subPanelImp, BorderLayout.CENTER);
		subPanelImp.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImp = new JLabel();
		lblImp.setText(factura.getImporte()+"");
		lblImp.setHorizontalAlignment(SwingConstants.CENTER);
		subPanelImp.add(lblImp, BorderLayout.CENTER);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(10, 209, 89, 23);
		btnCerrar.setFocusPainted(false);
		panelPrincipal.add(btnCerrar);
		
		btnCerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmDatos.dispose();
				
			}
		});
	}
}
