package es.deusto.spq.GUI;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import es.deusto.spq.data.Usuario;
import javax.swing.JButton;

public class VentanaDatosUsPost {

	private JFrame frmDatos;
	private Usuario usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario usuario = new Usuario(null);
					VentanaDatosUsPost window = new VentanaDatosUsPost(usuario);
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
	public VentanaDatosUsPost(Usuario usuario) {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Usuario usuario) {
		frmDatos = new JFrame();
		frmDatos.setResizable(false);
		frmDatos.setTitle("Datos");
		frmDatos.setBounds(100, 100, 476, 291);
		frmDatos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panelPrincipal = new JPanel();
		frmDatos.getContentPane().add(panelPrincipal, BorderLayout.NORTH);
		
		JLabel lblTit = new JLabel("Datos de Usuario");
		lblTit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelPrincipal.add(lblTit);
		
		JPanel subPanPrincipal = new JPanel();
		frmDatos.getContentPane().add(subPanPrincipal, BorderLayout.CENTER);
		subPanPrincipal.setLayout(null);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDatos.setBounds(10, 50, 436, 110);
		subPanPrincipal.add(panelDatos);
		panelDatos.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDatosTit = new JLabel("DATOS");
		lblDatosTit.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosTit.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
		panelDatos.add(lblDatosTit, BorderLayout.NORTH);
		
		JPanel subPanDatos = new JPanel();
		panelDatos.add(subPanDatos, BorderLayout.CENTER);
		subPanDatos.setLayout(null);
		
		JPanel panelNombre = new JPanel();
		panelNombre.setBounds(10, 11, 120, 28);
		subPanDatos.add(panelNombre);
		
		JLabel lblNombreTit = new JLabel("Nombre:");
		lblNombreTit.setHorizontalAlignment(SwingConstants.LEFT);
		panelNombre.add(lblNombreTit);
		
		JLabel lblNombre = new JLabel(usuario.getNombre());
		panelNombre.add(lblNombre);
		
		JPanel panelApellido = new JPanel();
		panelApellido.setBounds(10, 54, 129, 28);
		subPanDatos.add(panelApellido);
		
		JLabel lblApTit = new JLabel("Apellidos:");
		panelApellido.add(lblApTit);
		
		JLabel lblAp = new JLabel(usuario.getApellidos());
		panelApellido.add(lblAp);
		
		JPanel panelEmail = new JPanel();
		panelEmail.setBounds(280, 11, 144, 28);
		subPanDatos.add(panelEmail);
		
		JLabel lblEmailTit = new JLabel("Email:");
		panelEmail.add(lblEmailTit);
		
		JLabel lblEmail = new JLabel(usuario.getEmail());
		panelEmail.add(lblEmail);
		
		JPanel panelNick = new JPanel();
		panelNick.setBounds(276, 8, 170, 31);
		subPanPrincipal.add(panelNick);
		
		JLabel lblNickTit = new JLabel("Nickname:");
		panelNick.add(lblNickTit);
		
		JLabel lblNick = new JLabel(usuario.getNickname());
		panelNick.add(lblNick);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(20, 181, 89, 23);
		btnCerrar.setFocusPainted(false);
		subPanPrincipal.add(btnCerrar);
		
		btnCerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmDatos.dispose();
			}
		});
	}
}
