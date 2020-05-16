package es.deusto.spq.GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;

import es.deusto.spq.client.Controller;
import es.deusto.spq.data.Piso;

import org.jxmapviewer.painter.CompoundPainter;
import org.jxmapviewer.painter.Painter;
import javax.swing.JButton;

/**
 * Clase de la interfaz que muestra un mapa de la localizacón de un piso.
 * @author unai
 */
public class Mapa {
	
	/**
	 * Constructor de la ventana del mapa de un piso.
	 * @param piso
	 */
	public Mapa(Piso p) {
		
		double latitud = p.getLat();
		double longitud = p.getLon();
		System.out.println(latitud);
		System.out.println(longitud);
		
		JXMapViewer mapViewer = new JXMapViewer();
	    TileFactoryInfo info = new OSMTileFactoryInfo();
	    DefaultTileFactory tileFactory = new DefaultTileFactory(info);
	    mapViewer.setTileFactory(tileFactory);

	    // para cargar el mapa a la vez
	    tileFactory.setThreadPoolSize(8);

	    // Set the focus
	    GeoPosition posicion = new GeoPosition(latitud, longitud);

	    mapViewer.setZoom(2);
	    mapViewer.setAddressLocation(posicion);

	        
	    MouseInputListener mia = new PanMouseInputListener(mapViewer);
	    mapViewer.addMouseListener(mia);
	    mapViewer.addMouseMotionListener(mia);

	    mapViewer.addMouseListener(new CenterMapListener(mapViewer));

	    mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));

	    mapViewer.addKeyListener(new PanKeyListener(mapViewer));
	    JFrame frame = new JFrame("Mapa");
	    frame.getContentPane().add(mapViewer);
	    frame.setSize(800, 600);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	    Set<Waypoint> waypoints = new HashSet<Waypoint>();
	    waypoints.add(new DefaultWaypoint(latitud, longitud));
	    
	    WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<Waypoint>();
        waypointPainter.setWaypoints(waypoints);

        List<Painter<JXMapViewer>> painters = new ArrayList<Painter<JXMapViewer>>();
        painters.add(waypointPainter);
       
        CompoundPainter<JXMapViewer> painter = new CompoundPainter<JXMapViewer>(painters);
        mapViewer.setOverlayPainter(painter);
        
        JButton btnAtras = new JButton("Atras");
        mapViewer.add(btnAtras);
        
        btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new VentanaInformacion(p, Controller.getInstance().getUsuario());
				
			}
		});
        
	    }
	

}

