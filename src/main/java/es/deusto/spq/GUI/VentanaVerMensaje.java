package es.deusto.spq.GUI;


import javax.swing.JFrame;
import javax.swing.JLabel;


import es.deusto.spq.data.Mensaje;


public class VentanaVerMensaje extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private int ancho = 620;
	private int alto = 480;
	
	public VentanaVerMensaje(Mensaje m) {
		
		setSize(ancho, alto);
		setTitle("Lista de mensajes");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel cuerpo = new JLabel();
	    cuerpo.setText(m.getCuerpo());
	    cuerpo.setBounds(23,  -150, ancho , 500);
	    getContentPane().add(cuerpo);
	    
	    
		JLabel titulo = new JLabel();
		titulo.setText(m.getTitulo());
        titulo.setBounds(23, 20, 200, 20);
        
        
        getContentPane().add(titulo);
		
        
       
        
        
        setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		Mensaje m = new Mensaje("1", "Deberes", "Hola noseque toma");
		VentanaVerMensaje vm = new VentanaVerMensaje(m);
	}
	
}
