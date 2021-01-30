/**
 * Filter that adds Gaussian Blur
 * @author Jacob Voyles
 * @version Jan 2021
 *
 */
public class GaussianFilter implements Filter {
    private Blur blur = new Blur(); //Create a new Blur

    /**
     * Runs filter array on the Blur Class to get new pixel data to set
     * @param  theImage The image to modify
     */
    public void filter(PixelImage theImage) {
        //Array to define Edgy Filter
        int[] filter = {1,2,1,
                        2,4,2,
                        1,2,1};
        Pixel[][] finalBlur = blur.filterBlur(theImage, filter);
        theImage.setData(finalBlur); //Apply new blur to screen
    }
}
