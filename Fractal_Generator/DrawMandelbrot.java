import java.awt.*;
import javax.swing.JPanel;

class DrawMandelbrot extends JPanel{
    
    // instantiate 640000 madelbrot points because the canves is 800 x 800
    MandelbrotPoint [] mandelbrotPointArray = new MandelbrotPoint[640000];
    // Limits of the canves
    double leftXLimit;
    double rightXLimit;
    double upperYLimit;
    double lowerYLimit;
    // Number of iterations to do for identify the pixel is in the mandelbrot set or not
    int iterations;
    
    // Default Constructor
    DrawMandelbrot(){
        this.leftXLimit = -1;
        this.rightXLimit = 1;
        this.upperYLimit = 1;
        this.lowerYLimit = -1;
        MandelbrotPoint.iterations = 1000;
    }

    // Other constructors
    DrawMandelbrot(double leftXLimit, double rightXLimit, double lowerYLimit, double upperYLimit){
        this.leftXLimit = leftXLimit;
        this.rightXLimit = rightXLimit;
        this.upperYLimit = upperYLimit;
        this.lowerYLimit = lowerYLimit;
        MandelbrotPoint.iterations = 1000;
    }

    DrawMandelbrot(double leftXLimit, double rightXLimit, double lowerYLimit, double upperYLimit, int iterations){
        this.leftXLimit = leftXLimit;
        this.rightXLimit = rightXLimit;
        this.upperYLimit = upperYLimit;
        this.lowerYLimit = lowerYLimit;
        MandelbrotPoint.iterations = iterations;
    }

    DrawMandelbrot(int iterations){
        this.leftXLimit = -1;
        this.rightXLimit = 1;
        this.upperYLimit = 1;
        this.lowerYLimit = -1;
        MandelbrotPoint.iterations = iterations;
    }

    // This method is used to set the information of pixels in a perticuler row
    /* pass the parameters row number as row, real part of the complex number of starting pixel in the left side as re,
       imaginary part of the complex number of starting pixel in the left side as im, step size of x-axis as step, limits of the canves as
       leftLimit and rightLimit and index of the pixel in mandelbrotPointArray as startingBlock */ 
    public void setMandelbrotPixelsInRow(int row, double re, double im, double step, double leftLimit, double rightLimit, int startingBlock){
        // Iterate for 800 times because 800 pixels in a row
        for(int c = 0; c < 800; c++){
            // Use to identify the middel of the x-axis
            if(re < (leftLimit + rightLimit)/2d){
                // Initialize a new pixel and set values
                this.mandelbrotPointArray[startingBlock + c] = new MandelbrotPoint(c, row, re, im);
                // Increse the value of re by step size(Move to next pixel in the row)
                re = re + step;
            }
            else{
                re = re + step;
                this.mandelbrotPointArray[startingBlock + c] = new MandelbrotPoint(c, row, re, im);
            }
        }
    }

    // This method is used to set the information of all the pixels in the canvas
    public void setMandelbrotPixels(){
        int start = 0; // Initialize starting index of the mandelbrotPoint Array
        // Set step sizes
        double stepHorozontal = (this.rightXLimit - this.leftXLimit)/800d;
        double stepVerticle  = (this.upperYLimit - this.lowerYLimit)/800d;
        // Starting by set the values of the pixels from the top row 
        double yCoOrdinate = this.upperYLimit;
        // Iterate 800 times because there are 800 pixel rows
        for(int r = 0; r < 800; r++){
            // For every iteration starting to set the pixels value, from pixel in the left coner of the row 
            double xCoOrdinate = this.leftXLimit;
            // Use to identify the middel of the y-axis
            if(yCoOrdinate > (this.upperYLimit+this.lowerYLimit)/2d){
                // Set value of the pixels in the perticuler row
                setMandelbrotPixelsInRow(r, xCoOrdinate, yCoOrdinate, stepHorozontal, leftXLimit, rightXLimit, start);
                // Decrease the step(Move to next row)
                yCoOrdinate = yCoOrdinate - stepVerticle;
            }
            else{
                yCoOrdinate = yCoOrdinate - stepVerticle;
                setMandelbrotPixelsInRow(r, xCoOrdinate, yCoOrdinate, stepHorozontal, leftXLimit, rightXLimit, start);
            }
            // After a ireration start is increase by 800 
            start = start + 800;
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // Iterate for every instance store in the mandelbrotPoint Array
        for(int i = 0; i < 640000; i++){
            // Set values of the data in the object
            mandelbrotPointArray[i].isMandelbrot();
            mandelbrotPointArray[i].setRGB();
            // Set colour of the pixel
            g2d.setColor(mandelbrotPointArray[i].getC());
            // Positioning the pixel in right place 
            g2d.fillRect(mandelbrotPointArray[i].getX(), mandelbrotPointArray[i].getY(), 1, 1);
        }
	}

}
