import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Filter that outlines the edges.
 * @author Jacob Voyles
 * @version Jan 2021
 *
 */
public class GrayScale2Filter implements Filter{

    /**
     * Takes theImage and modifies the rgb to a grayscale
     * @param  theImage The image to modify
     */
    public void filter(PixelImage theImage) {
        Pixel[][] data = theImage.getData();
        BufferedImage img = theImage.getImage();

        //for each row, swap its contents from left to right
        for (int row = 0; row < theImage.getWidth(); row++) {
            for (int col = 0; col < theImage.getHeight(); col++) {
                Color c = new Color(img.getRGB(row, col));
                int sum = (11 * c.getRed() + 16 * c.getGreen() + 5 * c.getBlue()) / 32;
                int gray[] = new int[]{sum, sum, sum};
                data[col][row].rgb = gray;

            }
        }
        theImage.setData(data); //Apply new color to screen
    }
}
