import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

/**
 * Filter the Rotates the Photo 90 degrees Clockwise
 * @author Jacob Voyles
 *
 */
public class RotateCounterClockwiseFilter implements Filter{
    public void filter(PixelImage theImage) {
        //define sin and cos
        double sin = Math.abs(Math.sin(Math.toRadians(-90)));
        double cos = Math.abs(Math.cos(Math.toRadians(-90)));

        //original height and width
        int w = theImage.getWidth();
        int h = theImage.getHeight();

        //calculate new height and width
        int neww = (int)Math.floor(w*cos+h*sin);
        int newh = (int) Math.floor(h * cos + w * sin);

        BufferedImage img = theImage.getImage(); //gets Buffered image version to rotate
        BufferedImage rotated = new BufferedImage(neww, newh, img.getType()); //rotated version
        Graphics2D graphic = rotated.createGraphics();
        graphic.translate((neww - w) / 2, (newh - h) / 2);
        graphic.rotate(Math.toRadians(-90), w/2, h/2);
        graphic.drawImage(img, null, 0, 0);
        graphic.dispose(); //done rotating

        //Reused code from PixelImage.java
        Raster r = rotated.getRaster(); //create raster to get Pixel data
        Pixel[][] data = new Pixel[r.getHeight()][r.getWidth()];
        int[] samples = new int[3];

        // Translates from java image data to Pixel data
        for (int row = 0; row < r.getHeight(); row++) {
            for (int col = 0; col < r.getWidth(); col++) {
                r.getPixel(col, row, samples);
                Pixel ourPixel = new Pixel(samples[0], samples[1], samples[2]);
                data[row][col] = ourPixel;
            }
        }
        theImage.updateImage(r.getHeight(),r.getWidth(),rotated); //readjusts Image values to display fully rotated image
        theImage.setData(data); //set final image
    }
}
