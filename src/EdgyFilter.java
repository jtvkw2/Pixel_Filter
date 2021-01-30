/**
 * Filter that outlines the edges.
 * @author Jacob Voyles
 * @version Jan 2021
 *
 */
public class EdgyFilter implements Filter{
    private Blur blur = new Blur(); //Create a new Blur

    /**
     * Runs filter array on the Blur Class to get new pixel data to set
     * @param  theImage The image to modify
     */
    public void filter(PixelImage theImage) {
        //Array to define Edgy Filter
        int[] filter = {-1, -1, -1,
                        -1,  9, -1,
                        -1, -1, -1};
        Pixel[][] finalBlur = blur.filterBlur(theImage, filter);
        theImage.setData(finalBlur); //Apply new blur to screen
    }
}
