package es.deusto.spq.client;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Hello world!
 *
 */
public class App {
    private static void createAndShowGUI() {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = frame.getContentPane();

        JLabel lDir = new JLabel("Centro Urbano-Hirigunea, Leioa",SwingConstants.CENTER);
        JTextArea lDesc = new JTextArea("Descripcion");

        lDesc.setLineWrap(true);
        lDesc.setWrapStyleWord(true);
        lDesc.setOpaque(false);
        lDesc.setEditable(false);

        JLabel lCoste = new JLabel("1.000€ / mes");
        JLabel lTam = new JLabel("160m^2");
        JLabel lHabs = new JLabel("4 hab");

        BufferedImage image = null;
        try {                
            image = ImageIO.read(new File("resources/casa.jpg"));
         } catch (IOException ex) {
              // handle exception...
         }
         
         
        JLabel picLabel = new JLabel(new ImageIcon(image));
        picLabel.setPreferredSize(new Dimension(250,250));

        JPanel pMain = new JPanel();
        BoxLayout boxlayout = new BoxLayout(pMain, BoxLayout.Y_AXIS); 
        pMain.setLayout(boxlayout);

        JPanel pMiddle = new JPanel();
        pMiddle.setLayout(new FlowLayout());

        JPanel pContent = new JPanel();
        pContent.setLayout(new GridLayout(0,1));
        
        pMain.add(lDir);
        
        pContent.add(lCoste);
        pContent.add(lTam);
        pContent.add(lHabs);
        
        pMiddle.add(pContent);
        pMiddle.add(picLabel);

        pMain.add(pMiddle);

        pMain.add(new JLabel("Comentarios"));

        cp.add(pMain);

        	
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setPreferredSize(new Dimension(screenSize.width/2,screenSize.height/2));
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);	
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
