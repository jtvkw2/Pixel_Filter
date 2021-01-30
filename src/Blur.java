/**
 * Class used by Blurring Filters
 * @author Jacob Voyles
 * @version Jan 2021
 */
public class Blur{

    /**
     * Takes an array of 9 and uses it apply a filter
     *
     * @param theImage The image to modify
     */
    public Pixel[][] filterBlur(PixelImage theImage, int[] filter) {
        Pixel[][] data = theImage.getData(); //original
        Pixel[][] blur = theImage.getData(); //new blur

        for( int row = 1; row < theImage.getHeight()-1; row++){
            for(int col = 1; col < theImage.getWidth()-1; col++) {
                //Finds the surrounding pixels
                int[] t1 = data[row - 1][col - 1].rgb;
                int[] t2 = data[row - 1][col].rgb;
                int[] t3 = data[row - 1][col + 1].rgb;
                int[] m1 = data[row][col - 1].rgb;
                int[] m2 = data[row][col].rgb;
                int[] m3 = data[row][col + 1].rgb;
                int[] l1 = data[row + 1][col - 1].rgb;
                int[] l2 = data[row + 1][col].rgb;
                int[] l3 = data[row + 1][col + 1].rgb;

                int divisor = 0;
                for (int i = 0; i < filter.length; i++) {
                    divisor += filter[i];
                }
                if (divisor == 0) {
                    divisor = 1;
                }
                /*
                 Applies filter values to pixel color to calculate red green and blue
                 */
                int red = (filter[0] * t1[0] + filter[1] * t2[0] + filter[2] * t3[0] +
                        filter[3] * m1[0] + filter[4] * m2[0] + filter[5] * m3[0] +
                        filter[6] * l1[0] + filter[7] * l2[0] + filter[8] * l3[0]) / divisor;
                int blue = (filter[0] * t1[1] + filter[1] * t2[1] + filter[2] * t3[1] +
                        filter[3] * m1[1] + filter[4] * m2[1] + filter[5] * m3[1] +
                        filter[6] * l1[1] + filter[7] * l2[1] + filter[8] * l3[1]) / divisor;
                int green = (filter[0] * t1[2] + filter[1] * t2[2] + filter[2] * t3[2] +
                        filter[3] * m1[2] + filter[4] * m2[2] + filter[5] * m3[2] +
                        filter[6] * l1[2] + filter[7] * l2[2] + filter[8] * l3[2]) / divisor;

                /*
                  Checks to see if any values are outside the color range
                  If so it corrects it.
                 */
                if (red > 255)
                    red = 255;
                if(red<0)
                    red = 0;
                if(blue > 255)
                    blue = 255;
                if(blue < 0)
                    blue = 0;
                if(green > 255)
                    green = 255;
                if(green < 0)
                    green = 0;

                blur[row][col].rgb = new int[]{red, blue, green};

            }
        }
        return blur; //returns blurred Pixel array
    }
}
