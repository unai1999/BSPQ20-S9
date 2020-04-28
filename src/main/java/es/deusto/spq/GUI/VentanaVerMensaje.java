package es.deusto.spq.GUI;


import javax.swing.JFrame;
import javax.swing.JLabel;


import es.deusto.spq.data.MensajePrivado;


public class VentanaVerMensaje extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private int ancho = 620;
	private int alto = 480;
	
	public VentanaVerMensaje(MensajePrivado m) {
		
		setSize(ancho, alto);
		setTitle("Lista de mensajes");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel cuerpo = new JLabel();
	    cuerpo.setText(m.getContenido());
	    cuerpo.setBounds(23,  -150, ancho , 500);
	    getContentPane().add(cuerpo);
	    
	    
		JLabel titulo = new JLabel();
		titulo.setText(m.getOrigen());
        titulo.setBounds(23, 20, 200, 20);
        
        
        getContentPane().add(titulo);
		
        
       
        
        
        setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		
		
	}
	
}
