import java.awt.*;
import javax.swing.JPanel;

class DrawJulia extends JPanel{
    
    // instantiate 640000 julia points because the canves is 800 x 800
    JuliaPoint [] juliaPointArray = new JuliaPoint[640000];
    // Number of iterations to do for identify the pixel is in the julia set or not
    int iterations;
    
    // Default Constructor
    DrawJulia(){
        JuliaPoint.iterations = 1000;
        JuliaPoint.c_zX = -0.4d;
        JuliaPoint.c_zY = 0.6d;
    }

    // Other Constructors
    DrawJulia(double cZx, double cZy){
        JuliaPoint.iterations = 1000;
        JuliaPoint.c_zX = cZx;
        JuliaPoint.c_zY = cZy;
    }

    DrawJulia(double cZx, double cZy, int iterations){
        JuliaPoint.iterations = iterations;
        JuliaPoint.c_zX = cZx;
        JuliaPoint.c_zY = cZy;
    }

    DrawJulia(int iterations){
        JuliaPoint.iterations = iterations;
        JuliaPoint.c_zX = -0.4d;
        JuliaPoint.c_zY = 0.6d;
    }

    // This method is used to set the information of pixels in a perticuler row
    /* pass the parameters row number as row, real part of the complex number of starting pixel in the left side as re,
       imaginary part of the complex number of starting pixel in the left side as im, step size of x-axis as ste and 
       index of the pixel in mandelbrotPointArray as startingBlock */ 
    public void setJuliaPixelsInRow(int row, double re, double im, double step, int startingBlock){
         // Iterate for 800 times because 800 pixels in a row
        for(int c = 0; c < 800; c++){
            // Use to identify the middel of the x-axis
            if(re < 0){
                // Initialize a new pixel and set values
                this.juliaPointArray[startingBlock + c] = new JuliaPoint(c, row, re, im);
                // Increse the value of re by step size(Move to next pixel in the row)
                re = re + step;
            }
            else{
                re = re + step;
                this.juliaPointArray[startingBlock + c] = new JuliaPoint(c, row, re, im);
            }
        }
    }

    // This method is used to set the information of all the pixels in the canvas
    public void setJuliaPixels(){
        int start = 0; // Initialize starting index of the mandelbrotPoint Array
        // Set step sizes
        double stepHorozontal = 2d/800d;
        double stepVerticle  = 2d/800d;
        // Starting by set the values of the pixels from the top row 
        double yCoOrdinate = 1;
        // Iterate 800 times because there are 800 pixel rows
        for(int r = 0; r < 800; r++){
            // For every iteration starting to set the pixels value, from pixel in the left coner of the row
            double xCoOrdinate = -1;
            if(yCoOrdinate > 0){
                // Set value of the pixels in the perticuler row
                setJuliaPixelsInRow(r, xCoOrdinate, yCoOrdinate, stepHorozontal, start);
                // Decrease the step(Move to next row)
                yCoOrdinate = yCoOrdinate - stepVerticle;
            }
            else{
                yCoOrdinate = yCoOrdinate - stepVerticle;
                setJuliaPixelsInRow(r, xCoOrdinate, yCoOrdinate, stepHorozontal, start);
            }
            // After a ireration start is increase by 800 
            start = start + 800;
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // Iterate for every instance store in the juliaPoint Array
        for(int i = 0; i < 640000; i++){
            // Set values of the data in the object
            this.juliaPointArray[i].isJulia();
            this.juliaPointArray[i].setRGB();
            // Set colour of the pixel
            g2d.setColor( this.juliaPointArray[i].getC());
            // Positioning the pixel in right place
            g2d.fillRect( this.juliaPointArray[i].getX(),  this.juliaPointArray[i].getY(), 1, 1);
        }
	}

}
