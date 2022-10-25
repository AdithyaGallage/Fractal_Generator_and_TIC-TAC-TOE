import java.awt.Color;

class MandelbrotPoint {
    
    private int n; // divergence iteration
    private boolean mandelbrot; // identify point is a mandelbrot or not
    private int x; // position of the pixel in x-axis
    private int y; // position of the pixel in y-axis
    private double zX; // real part of the complex number which related to the pixel
    private double zY;  // imaginary part of the complex number which related to the pixel
    private Color c; // colour of the pixel
    static int iterations; // number of iterations

    // Setters
    public void setN(int n){ this.n = n; }
    public void setMandelbrot(boolean mandelbrot){ this.mandelbrot = mandelbrot; }
    public void setX(int x){ this.x = x; }
    public void setY(int y){ this.y = y; }
    public void setZX(double zX){ this.zX = zX; }
    public void setZY(double zY) { this.zY = zY; }
    public void setC(Color c){ this.c = c; }

    // Getters
    public int getN(){ return this.n; }
    public boolean getMandelbrot(){ return this.mandelbrot; }
    public int getX(){ return this.x; }
    public int getY(){ return this.y; }
    public double getZX(){ return this.zX; }
    public double getZY(){ return this.zY; }
    public Color getC(){ return this.c; }

    // Constructor
    MandelbrotPoint(int x, int y, double zX, double zY){
        this.x = x;
        this.y = y;
        this.zX = zX;
        this.zY = zY;
    }

    // This method use to calculate the value of n and identify the point is in mandelbrot set or not
    public void isMandelbrot(){
        // initialize Z0
        double zRe = 0;
        double zIm = 0;
        // iterate Z1 = Z0^2 + C for given number of iterations 
        for(int i = 0; i <= MandelbrotPoint.iterations; i++){
            // Calculate the square of magnitude of Z1 complex number
            double magnitude = Complex.magnitude(zRe, zIm);
            // Square the complex number Z0
            Complex z_square = Complex.squareComplex(zRe, zIm);
            // Add Z0 to C and get the value of Z1
            Complex z_next = Complex.addComplex(this.zX, this.zY, z_square.x, z_square.y);
            // Initialize Z0 for next iteration
            zRe = z_next.x;
            zIm = z_next.y;
            /* If the square of the magnitude is greater than 4
               n is set as i and identify that complex number in mandelbrot set*/  
            if(magnitude > 4){
                this.n = i;
                this.mandelbrot = false;
                return;
            }    
        }
        /* If the complex number is not in the mandelbrot set following two instructions are executed and identfy
           that complex number is not in the madelbrot set*/
        this.n = MandelbrotPoint.iterations;
        this.mandelbrot = true;
    }
    // This method use to set the colour of the pixels
    public void setRGB(){
        // If pixel is not in the madelbrot set colour set according to  the n
        if(!this.mandelbrot){
            this.c = Color.getHSBColor(n/256f, 1f, n/(n+8f));
        }
        // Otherwise colour set as black
        else{
            this.c = Color.BLACK;
        }
    }
}
