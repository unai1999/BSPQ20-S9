package es.deusto.spq.server;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class MapsTest {

    public static void openWebMsap(String direction) {
        String search = direction.replaceAll(" ", "+");
        try {

            URI uri = new URI("https://www.google.com/maps/search/?api=1&query=" + search);

            java.awt.Desktop.getDesktop().browse(uri);
            System.out.println("Web page opened in browser");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        openWebMsap("Calle urquijo 8");
    }
}