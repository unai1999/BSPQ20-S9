package es.deusto.spq.GUI;


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
import org.jxmapviewer.viewer.WaypointRenderer;
import org.jxmapviewer.painter.CompoundPainter;
import org.jxmapviewer.painter.Painter;

import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;

public class Mapa {
	
	public static JOpenCageLatLng obtenerCoordenadasMedianteLocalizacion(){
		JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder("aeb74f54239a447daa7f661fb5ee5a97");
		JOpenCageForwardRequest request = new JOpenCageForwardRequest("Plaza Emilio Campuzano, 48011 Bilbao, España");

		JOpenCageResponse response = jOpenCageGeocoder.forward(request);
		JOpenCageLatLng firstResultLatLng = response.getFirstPosition(); 
		
		return firstResultLatLng;
	}
	
	public static void main(String[] args) {
		JOpenCageLatLng coordenadas = obtenerCoordenadasMedianteLocalizacion();
		 double latitud = coordenadas.getLat();
		 double longitud = coordenadas.getLng();
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
	    JFrame frame = new JFrame("JXMapviewer2 Example 1");
	    frame.getContentPane().add(mapViewer);
	    frame.setSize(800, 600);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	    Set<Waypoint> waypoints = new HashSet<Waypoint>();
	    waypoints.add(new DefaultWaypoint(latitud, longitud));
	    
	    WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<Waypoint>();
        waypointPainter.setWaypoints(waypoints);
//        waypointPainter.setRenderer(new WaypointRenderer<Waypoint>() {
//			
//			@Override
//			public void paintWaypoint(Graphics2D g, JXMapViewer map, Waypoint waypoint) {
//				 g.setColor(Color.RED);
//				 g.drawLine(-5,-5,+5,+5); 
//				 g.drawLine(-5,+5,+5,-5); 
//				
//			}
//		});
//        mapViewer.setOverlayPainter(waypointPainter);
       	
        //List<GeoPosition> track = Arrays.asList(posicion);
        //RoutePainter routePainter = new RoutePainter(track);
        		
        List<Painter<JXMapViewer>> painters = new ArrayList<Painter<JXMapViewer>>();
        //painters.add(routePainter);
        painters.add(waypointPainter);
       
        CompoundPainter<JXMapViewer> painter = new CompoundPainter<JXMapViewer>(painters);
        mapViewer.setOverlayPainter(painter);
        
	    }
	

}

