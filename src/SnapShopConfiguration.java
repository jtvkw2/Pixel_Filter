/**
 * A class to configure the SnapShop application
 * 
 * @author Richard Dunn
 * @version March 2002
 */

public class SnapShopConfiguration
{
    /**
     * Method to configure the SnapShop.  Call methods like addFilter
     * and setDefaultFilename here.
     * @param theShop The application to configure
     */

    public static void configure(SnapShop theShop)
    {
        theShop.setDefaultFilename("");
        theShop.addFlipHorizontalFilter(new FlipHorizontalFilter());
        theShop.addFlipVerticalFilter(new FlipVerticalFilter());
        theShop.addGrayScale1Filter(new GrayScale1Filter());
        theShop.addGrayScale2Filter(new GrayScale2Filter());
        theShop.addGaussianFilter(new GaussianFilter());
        theShop.addLaplacianFilter(new LaplacianFilter());
        theShop.addUnsharpMaskingFilter(new UnsharpMasking());
        theShop.addEdgyFilter(new EdgyFilter());
        theShop.addRotateClockwiseFilter(new RotateClockwiseFigure());
        theShop.addRotateCounterClockwiseFilter(new RotateCounterClockwiseFilter());
    }

}

