package es.deusto.spq.client;

import javax.imageio.ImageIO;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UtilsImagenes {

    public static void imageIoWrite(final String imagename) {
        final BufferedImage bImage = null;
        try {

            final String path = "resources/images/" + imagename;
            // File initialImage = new File(path);
            // bImage = ImageIO.read(initialImage);

            ImageIO.write(bImage, "jpg", new File(path));

        } catch (final IOException e) {
            System.out.println("Exception occured :" + e.getMessage());
        }
        System.out.println("Images were written succesfully.");
    }

    public static void main(final String[] args) {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JButton loadButton = new JButton("Display Image");
        loadButton.addActionListener(ev -> {
            final JFileChooser fc = new JFileChooser(System.getProperty("user.home"));
            fc.addChoosableFileFilter(
                    new FileNameExtensionFilter("Image files", new String[] { "png", "jpg", "jpeg", "gif" }));
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    final BufferedImage image = ImageIO.read(fc.getSelectedFile());
                    if (image != null) {
                        final JPanel panel = new JPanel();
            panel.add(new JLabel(fc.getSelectedFile().toString()),
                BorderLayout.NORTH);
            panel.add(new JLabel(new ImageIcon(image)));
            JOptionPane.showMessageDialog(frame, panel);
          }
        } catch (final Exception ex) {
          ex.printStackTrace();
        }
      }
    });

    frame.add(loadButton);
    frame.pack();
    frame.setLocationByPlatform(true);
    frame.setVisible(true);
  }
    
}