package es.deusto.spq.GUI;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;


import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JLabelFoto extends JLabel implements MouseListener{
//Explorador de archivos, si le sirve a alguien que lo use. (34)
	
	private JLabel label;
	private static final long serialVersionUID = 1L;
	
	public JLabelFoto() {
		setSize(119,145);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Buscador de archivos para la foto de perfil.
		JFileChooser file = new JFileChooser();
		file.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image", "jpg", "gif", "png");
		file.addChoosableFileFilter(filter);
		int result = file.showSaveDialog(null);
		if(result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = file.getSelectedFile();
			String path = selectedFile.getAbsolutePath();
			label.setIcon(ResizeImage(path));
		}
		else if (result == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "No file selected");
		}
	}
		
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public ImageIcon ResizeImage(String path) {
		ImageIcon myImage = new ImageIcon(path);
		Image img = myImage.getImage();
		Image newImg = img.getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}
}
