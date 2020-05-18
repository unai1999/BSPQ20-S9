package es.deusto.spq.client;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

public class UtilsImagenesTest {

    @Before
    public void setUp() {

    }

    @Test
    public void imageIoWriteTest() {

        BufferedImage img = null;
        File f = new File("resources/casa.jpg");
        try {
            img = ImageIO.read(f);
        } catch (IOException e) {
        }
        UtilsImagenes.imageIoWrite("test", img);
        File f2 = new File("resources/images/test.jpg");
        f2.delete();
    }
}