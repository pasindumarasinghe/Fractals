

/*
 * E/17/207 - Marasinghe MAPG
 * CO225 - Project 1
 * Fractals
 */


public class Fractal{
	
	final static int HEIGHT = 800,WIDTH = 800;
	
	public static void main(String [] args) {
		double real_min,real_max,imaginary_min,imaginary_max,c_real,c_imaginary;
		int iterations;
		
		//Here, the command lines arguments are handled
		if(args.length == 0) {
			System.out.println("Error");
			printUsage();
		}
		
		
		if(args[0].toLowerCase().equals("mandelbrot")) {
		//The user wants to draw a Mandelbrot Set
			if(args.length == 1) {
				renderMandelbrotSet(new Mandelbrot());
			}
			else if(args.length == 5) {
				try {
					real_min = Double.parseDouble(args[1]);
					real_max = Double.parseDouble(args[2]);
					imaginary_min = Double.parseDouble(args[3]);
					imaginary_max = Double.parseDouble(args[4]);
					
					renderMandelbrotSet(new Mandelbrot(real_min,real_max,imaginary_min,imaginary_max));
				}
				catch(Exception e) {
					System.out.println("Invalid Input");
					printUsage();
				}
				
			}
			
			else if(args.length == 6) {
				try {
					real_min = Double.parseDouble(args[1]);
					real_max = Double.parseDouble(args[2]);
					imaginary_min = Double.parseDouble(args[3]);
					imaginary_max = Double.parseDouble(args[4]);
					iterations = Integer.parseInt(args[5]);
					renderMandelbrotSet(new Mandelbrot(real_min,real_max,imaginary_min,imaginary_max,iterations));
				}
				catch(Exception e) {
					System.out.println("Invalid Input");
					printUsage();
				}
			}
			
			else {
				System.out.println("Wrong Number of Inputs");
				printUsage();
			}
			
		}
			
			
			
			
		else if(args[0].toLowerCase().equals("julia")) {
			if(args.length == 1) {
				renderJuliaSet(new Julia());
			}
			
			if(args.length == 3) {
				try {
					c_real = Double.parseDouble(args[1]);
					c_imaginary = Double.parseDouble(args[2]);
					renderJuliaSet(new Julia(c_real,c_imaginary));
				}
				catch(Exception e) {
					System.out.println("Invalid Input");
					printUsage();
				}
			}
			
			else if(args.length == 4) {
				try {
					c_real = Double.parseDouble(args[1]);
					c_imaginary = Double.parseDouble(args[2]);
					iterations = Integer.parseInt(args[3]);
					renderJuliaSet(new Julia(c_real,c_imaginary,iterations));
				}
				catch(Exception e) {
					System.out.println("Invalid Input");
					printUsage();
				}
			}
			
			else {
				System.out.println("Wrong Number of Inputs");
				printUsage();
			}
			
			
			
		}
			
		else { 
			//Stating that the input is incorrect and Print out the usage
			System.out.println("Wrong Input");
			printUsage();
		}
		
	}
	
	
	public static void renderMandelbrotSet(Mandelbrot set) {
		//rendering the mandelbrot set
		Interface window = new Interface("Mandelbrot Set");
		for(int x=0 ; x < HEIGHT ; x++) {
			for(int y=0 ; y < WIDTH ; y++) {
				window.draw(x,y,set.getColour(x, y));
			}
		}
		window.display();//display the rendered set
	}
	
	public static void renderJuliaSet(Julia set) {
		//rendering the mandelbrot set
		Interface window = new Interface("Julia Set");
		for(int x=0 ; x < HEIGHT ; x++) {
			for(int y=0 ; y < WIDTH ; y++) {
				window.draw(x,y,set.getColour(x, y));
			}
		}
		window.display();//display the rendered set
	}
	
	public static void printUsage() {
		System.out.println(""
				+ "Usage : \n"
				+ "java Fractal [Mandelbrot/Julia]\n"
				+ "java Fractal [Mandelbrot] [Region of Interest]\n"
				+ "java Fractal [Mandelbrot] [Region of Interest] [Number of Iterations]\n"
				+ "java Fractal [Julia] [Real Part of C] [Imaginary Part of C]\n"
				+ "java Fractal [Julia] [Real Part of C] [Imaginary Part of C] [Number of Iterations]");
		System.exit(0);
	}
	
	
}
