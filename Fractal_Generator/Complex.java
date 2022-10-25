class Complex {
    
    double x; // Real part
    double y; // Imaginary part

    // Constructor
    Complex(double x, double y){
        this.x = x;
        this.y = y;
    }

    Complex() {} // Default constructor

    // Method to add two complex numbers and get the result
    public static Complex addComplex(double x1, double y1, double x2, double y2){
        Complex z = new Complex(x1+x2, y1+y2);
        return z;
    }

    // Method to square a complex number and get the result
    public static Complex squareComplex(double x, double y){
        Complex z = new Complex((x*x)-(y*y), 2*x*y);
        return z;
    }

    // Method to get the square value of magnitude of a complex number
    public static double magnitude(double x, double y){ return (x*x)+(y*y); }

}
