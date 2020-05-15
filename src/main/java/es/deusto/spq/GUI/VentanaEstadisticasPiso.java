package es.deusto.spq.GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import es.deusto.spq.client.Controller;
import es.deusto.spq.data.Piso;

import javax.swing.JButton;

/**
 * Clase de la interfaz que muestra las estadisticas de un piso
 * @author unai
 */
public class VentanaEstadisticasPiso extends JFrame {
	
	/**
	 * Constructor de la ventana que muestra las estadisticas del piso.
	 * @param piso
	 */
	private static final long serialVersionUID = 1L;

	public VentanaEstadisticasPiso(Piso p) {
		Font fuente1 = new Font("Times New Roman", Font.PLAIN, 14);
		Font fuente2 = new Font("Times New Roman", Font.BOLD, 14);
		Font fuente3 = new Font("Arial", Font.BOLD, 17);
		
		
		setSize(480, 320);
		getContentPane().setLayout(null);
		
		JLabel labelTitulo = new JLabel("Estadisticas del piso: " + p.getNombre());
		labelTitulo.setBounds(125, 44, 287, 25);
		getContentPane().add(labelTitulo);
		labelTitulo.setFont(fuente3);
		
		JLabel labelVal = new JLabel("Valoración: ");
		labelVal.setBounds(10, 97, 94, 14);
		getContentPane().add(labelVal);
		labelVal.setFont(fuente1);
		
		JLabel labelVal2 = new JLabel();
		labelVal2.setText(p.getValoracion() + "/5");
		labelVal2.setBounds(81, 97, 83, 14);
		getContentPane().add(labelVal2);
		labelVal2.setFont(fuente2);
		
		JLabel labelLikes = new JLabel("Likes: ");
		labelLikes.setBounds(10, 138, 62, 14);
		getContentPane().add(labelLikes);
		labelLikes.setFont(fuente1);
		
		JLabel labelLikes2 = new JLabel();
		labelLikes2.setText(String.valueOf(p.getLikes()));
		labelLikes2.setBounds(48, 138, 82, 14);
		getContentPane().add(labelLikes2);
		labelLikes2.setFont(fuente2);
		
		JLabel labelComprado = new JLabel("Veces comprado: ");
		labelComprado.setBounds(10, 178, 123, 14);
		getContentPane().add(labelComprado);
		labelComprado.setFont(fuente1);
		
		JLabel labelComprado2 = new JLabel(String.valueOf(p.getVecesComprado()));
		labelComprado2.setBounds(114, 178, 82, 14);
		getContentPane().add(labelComprado2);
		labelComprado2.setFont(fuente2);
		
		JLabel labelVisitado = new JLabel("Veces visitado: ");
		labelVisitado.setBounds(10, 226, 123, 14);
		getContentPane().add(labelVisitado);
		labelVisitado.setFont(fuente1);
		
		JLabel labelVisitado2 = new JLabel(String.valueOf(p.getVecesVisitado()));
		labelVisitado2.setBounds(101, 226, 83, 14);
		getContentPane().add(labelVisitado2);
		labelVisitado2.setFont(fuente2);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(360, 250, 89, 23);
		getContentPane().add(btnAtras);
		
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaInformacion(p, Controller.getInstance().getUsuario());
				
			}
		});
		
		setVisible(true);
	}

}
