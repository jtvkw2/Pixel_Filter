/**
 * Filter that flips the image vertically.
 * @author Jacob Voyles
 * @version Jan 2021
 */
public class FlipVerticalFilter implements Filter{

    /**
     * Flip the image vertically ( over the horizontal axis)
     *
     * @param theImage The image to modify
     */
    public void filter(PixelImage theImage) {
        // get the data from the image
        Pixel[][] data = theImage.getData();

        for (int col = 0; col < theImage.getWidth(); col++) {
            for (int row = 0; row < theImage.getHeight() / 2; row++) {
                // given a column: i, its pair is column: width() - i - 1
                // e.g. with a width of 10
                // column 0 is paired with column 9
                // column 1 is paired with column 8 etc.
                Pixel temp = data[row][col];
                data[row][col] = data[theImage.getHeight() - row - 1][col];
                data[theImage.getHeight() - row - 1][col] = temp;
            }
        }

        // update the image with the moved pixels
        theImage.setData(data);
    }
}
