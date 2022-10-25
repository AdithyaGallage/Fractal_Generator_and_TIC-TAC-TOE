import javax.swing.*;

class Fractal {

    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    // Set the frame to draw Mandelbrot Set
    public static void setMandelbrotFrame(DrawMandelbrot m){
        JFrame frame = new JFrame("Mandelbrot Set");
		frame.add(m);
		frame.setSize(800, 800);
		frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Set the frame to draw julia Set
    public static void setJuliaFrame(DrawJulia j){
        JFrame frame = new JFrame("Julia Set");
		frame.add(j);
		frame.setSize(800, 800);
		frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Output instructions for invalid araguments
    public static void UsageString1(){
        System.out.println(ANSI_CYAN + "Usage: java Fractal Mandelbrot <region of interest>");
        System.out.println("Example: java Fractal Mandelbrot -0.5 0.5 -0.1 1");
        System.out.println("Mean: The region of interest for the image should be from -0.5<real<0.5 and -0.1<complex<1" + ANSI_RESET);
    }
    public static void UsageString2(){
        System.out.println(ANSI_CYAN + "Usage: java Fractal Mandelbrot <Region of interest> <Iterations>");
        System.out.println("Example: java Fractal Mandelbrot -0.5 0.5 -0.1 1 1000");
        System.out.println("Mean: The region of interest for the image should be from -0.5<real<0.5 and -0.1<complex<1 and for each point program will do 1000 iterations\n      before deciding that it is in the set" + ANSI_RESET);
    }
    public static void UsageString3(){
        System.out.println(ANSI_CYAN + "Usage: java Fractal Julia <Value of C>");
        System.out.println("Example: java Fractal Julia -0.5 0.156");
        System.out.println("Mean: Program would plot the Julia set for C = -0.5 + 0.156i" + ANSI_RESET);
    }
    public static void UsageString4(){
        System.out.println(ANSI_CYAN + "Usage: java Fractal Julia <Value of C> <Iterations>");
        System.out.println("Example: java Fractal Julia -0.5 0.156 1000");
        System.out.println("Mean: Program Would plot the Julia set for C = -0.5 + 0.156i with 1000 iterations for each point" + ANSI_RESET);
    }

    public static void UsageString5(){
        System.out.println(ANSI_CYAN + "Usage: java Fractal Mandelbrot <Iterations>");
        System.out.println("Example: java Fractal Mandelbrot 1000");
        System.out.println("Mean: For each point program will do 1000 iterations before deciding that it is in the set" + ANSI_RESET);
    }

    public static void UsageString6(){
        System.out.println(ANSI_CYAN + "Usage: java Fractal Mandelbrot <Iterations>");
        System.out.println("Example: java Fractal Julia 1000");
        System.out.println("Mean: For each point program will do 1000 iterations before deciding that it is in the set" + ANSI_RESET);
    }
    //Main Method
    public static void main(String[] args) {
        // Argument Handling
        try{
        int numberOfValidArguments = args.length-1;
        if(args[0].equals("Mandelbrot")){
            if(numberOfValidArguments == 0){
                DrawMandelbrot m = new DrawMandelbrot();
                m.setMandelbrotPixels();
                Fractal.setMandelbrotFrame(m);
            }
            else if(numberOfValidArguments == 1){
                try{
                    DrawMandelbrot m = new DrawMandelbrot(Integer.parseInt(args[1]));
                    m.setMandelbrotPixels();
                    Fractal.setMandelbrotFrame(m);
                }catch(IllegalArgumentException e){
                    System.out.println(ANSI_CYAN + "Wrong argument type: Number of iterations should consists with a Real number" + ANSI_RESET);
                    Fractal.UsageString5();
                }
            }
            else if(numberOfValidArguments == 4){
                try{
                    DrawMandelbrot m = new DrawMandelbrot(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]));
                    m.setMandelbrotPixels();
		            Fractal.setMandelbrotFrame(m);
                }catch(IllegalArgumentException e){
                    System.out.println(ANSI_CYAN + "Wrong argument type: Region of interest should consists of Real numbers" + ANSI_RESET);
                    Fractal.UsageString1();
                }
            }
            else if(numberOfValidArguments == 5){
                try{
                    DrawMandelbrot m = new DrawMandelbrot(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]), Integer.parseInt(args[5]));
                    m.setMandelbrotPixels();
		            Fractal.setMandelbrotFrame(m);
                }catch(IllegalArgumentException e){
                    System.out.println(ANSI_CYAN + "Wrong argument type: Region of interest and Number of iterations should consist of Real numbers" + ANSI_RESET);
                    Fractal.UsageString2();
                }
            }
            else{
                Fractal.UsageString1();
                System.out.println(ANSI_CYAN + "Or" + ANSI_RESET);
                Fractal.UsageString2();
                System.out.println(ANSI_CYAN + "Or" + ANSI_RESET);
                Fractal.UsageString5();
            }
        }
        else if(args[0].equals("Julia")){
            if(numberOfValidArguments == 0){
                DrawJulia j = new DrawJulia();
                j.setJuliaPixels();
                Fractal.setJuliaFrame(j);
            }
            else if(numberOfValidArguments == 1){
                try {
                    DrawJulia j = new DrawJulia(Integer.parseInt(args[1]));
                    j.setJuliaPixels();
                    Fractal.setJuliaFrame(j);
                } catch (IllegalArgumentException e) {
                    System.out.println(ANSI_CYAN + "Wrong argument type: Number of Iterations should consists with a real number" + ANSI_RESET);
                    UsageString6();
                }
            }
            else if(numberOfValidArguments == 2){
                try {
                    DrawJulia j = new DrawJulia(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                    j.setJuliaPixels();
		            Fractal.setJuliaFrame(j);
                } catch (IllegalArgumentException e) {
                    System.out.println(ANSI_CYAN + "Wrong argument type: Value of C should consists with real numbers" + ANSI_RESET);
                    Fractal.UsageString3();
                }
            }
            else if(numberOfValidArguments == 3){
                try{
                    DrawJulia j = new DrawJulia(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3]));
                    j.setJuliaPixels();
		            Fractal.setJuliaFrame(j);
                }catch(IllegalArgumentException e){
                    System.out.println(ANSI_CYAN + "Wrong argument type: Value of C and Number of Iterations should consist with real numbers" + ANSI_RESET);
                    Fractal.UsageString4();
                }
            }
            else{
                Fractal.UsageString3();
                System.out.println(ANSI_CYAN + "Or" + ANSI_RESET);
                Fractal.UsageString4();
                System.out.println(ANSI_CYAN + "Or" + ANSI_RESET);
                Fractal.UsageString6();
            }
        }   
        else{
            System.out.println(ANSI_CYAN + "Usage: java Fractal <Mandelbrot/Julia>" + ANSI_RESET);
        }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(ANSI_CYAN + "Usage: java Fractal <Mandelbrot/Julia>" + ANSI_RESET);
        }
    }
}