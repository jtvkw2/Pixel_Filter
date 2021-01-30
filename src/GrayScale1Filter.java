import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Filter Grays the Image.
 * @author Jacob Voyles
 * @version Jan 2021
 *
 */
public class GrayScale1Filter implements Filter {

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
                Color c = new Color(img.getRGB(row,col));
                int red = (int)(c.getRed() * 0.3);
                int green =  (int)(c.getGreen() * 0.59);
                int blue = (int)(c.getBlue() * 0.11);
                int sum = (red+green+blue);
                data[col][row].rgb = new int[]{sum, sum, sum};;

            }
        }
        theImage.setData(data); //Apply new color to screen
    }

}
