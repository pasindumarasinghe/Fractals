

/*=============================
 * E/17/207 - Marasinghe MAPG
 * CO225 - Project 1 - Fractals
 * Submitted Date : 2020-12-06
 * e17207@eng.pdn.ac.lk
 *=============================
 */

public class Fractal{
	//The size of the canvas is 800x800 pixels
	final static int HEIGHT = 800,WIDTH = 800;
	
	public static void main(String [] args) {
		/*
		 Here, the command line arguments are handled.The user should specify what set to print(Mandelbrot/Julia).
		 The user can enter atmost 5 arguments for the mandelbrot set and 3 arguments for the Julia set
		 
		 The Valid Argument combinations for the Mandelbrot Set
		 ------------------------------------------------------
		 *No arguments(Then the default values are taken into consideration).
		 *[Number of Iterations]
		 *[Minimum of the Real Axis] [Maximum of the Real Axis]
		 *[Minimum of the Real Axis] [Maximum of the Real Axis] [Number of Iterations]
		 
		 The Valid Argument combinations for the Julia Set
		 -------------------------------------------------
		 *No argument(The default values are taken into consideration)
		 *[Number of iterations]
		 *[Real Part of C] [Imaginary Part of C]
		 *[Real Part of C] [Imaginary Part of C] [Number of Iterations]
		 
		 */
		
		double real_min,real_max,imaginary_min,imaginary_max,c_real,c_imaginary;
		int iterations;
		
		//Here, the command lines arguments are handled
		if(args.length == 0) {
			System.out.println("Error");
			printUsage();
		}
		
//		----------------------------------------
//		 When the User wants the Mandelbrot Set
//		----------------------------------------
		if(args[0].toLowerCase().equals("mandelbrot")) {//Handeling the arguments for the Mandelbrot set
		//The user wants to draw a Mandelbrot Set
			if(args.length == 1) {//when the user does not specify anything
				renderMandelbrotSet(new Mandelbrot());
			}
			
			else if(args.length == 2) {//when the user specifies the number of iterations
				try {
					iterations = Integer.parseInt(args[1]);
					renderMandelbrotSet(new Mandelbrot(iterations));//Render the mandelbrot set
				}
				catch(Exception e) {//If an exception is found, An error message with the proper usage is peinted on the screen
					System.out.println("Invalid Input");
					printUsage();
				}
			}
			
			else if(args.length == 5) {//When the user specifies the region of interest
				try {
					real_min = Double.parseDouble(args[1]);
					real_max = Double.parseDouble(args[2]);
					imaginary_min = Double.parseDouble(args[3]);
					imaginary_max = Double.parseDouble(args[4]);
					
					renderMandelbrotSet(new Mandelbrot(real_min,real_max,imaginary_min,imaginary_max));//Render the Mandelbrot set
				}
				catch(Exception e) {
					System.out.println("Invalid Input");
					printUsage();
				}
				
			}
			
			else if(args.length == 6) {//when the user specifies the region of interest and the number of iterations
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
			
			
		
//		------------------------------------
//		 When the User wants the Julia Set
//		------------------------------------
		else if(args[0].toLowerCase().equals("julia")) {
			if(args.length == 1) {//When the user does not specify anything
				renderJuliaSet(new Julia());
			}
			
			else if(args.length == 2) {//When the user only specifies the number of Iterations
				try {
					iterations = Integer.parseInt(args[1]);
					renderJuliaSet(new Julia(iterations));
				}
				catch(Exception e) {
					System.out.println("Invalid Input");
					printUsage();
				}
			}
			
			else if(args.length == 3) {//when the user only specifies C
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
			
			else if(args.length == 4) {//When the user specifies C as well as the number of Iterations
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
			
			else {//If the user enters a invalid number of inputs, An error message along with the proper usage is printed
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
		
		/*
		 The canvas is of 800x800 pixels and it has 800 rows and 800 columns, one thread is used to calculate whether the pixels in 
		 the row are Mandelbrot Numbers. 8 threads are used to render the whole set using 1 thread for one row.
		*/
		
		//Creating thread objects and run them
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {drawMandelbrotSet(set,window,0,100);} 
			});
		t1.start();
		
		
		Thread t2 = new Thread(new Runnable() {			
			@Override
			public void run() {drawMandelbrotSet(set,window,100,200);} 
			});
		t2.start();
		
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {drawMandelbrotSet(set,window,200,300);} 
			});
		t3.start();
		
		
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {drawMandelbrotSet(set,window,300,400);} 
			});
		t4.start();
		
		Thread t5 = new Thread(new Runnable() {
			@Override
			public void run() {drawMandelbrotSet(set,window,400,500);} 
			});
		t5.start();
		
		
		Thread t6 = new Thread(new Runnable() {
			@Override
			public void run() {drawMandelbrotSet(set,window,500,600);} 
			});
		t6.start();
		
		Thread t7 = new Thread(new Runnable() {
			@Override
			public void run() {drawMandelbrotSet(set,window,600,700);} 
			});
		t7.start();
		
		Thread t8 = new Thread(new Runnable() {
			@Override
			public void run() {drawMandelbrotSet(set,window,700,800);} 
			});
		t8.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			t6.join();
			t7.join();
			t8.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		
		
		
		
		window.display();//display the rendered set
	}
	
	public static void renderJuliaSet(Julia set) {
		//rendering the mandelbrot set
		Interface window = new Interface("Julia Set");
		
		//These threads have the same funtionality as for the Mandelbrot set
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {drawJuliaSet(set,window,0,100);} 
			});
		t1.start();
		
		
		Thread t2 = new Thread(new Runnable() {			
			@Override
			public void run() {drawJuliaSet(set,window,100,200);} 
			});
		t2.start();
		
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {drawJuliaSet(set,window,200,300);} 
			});
		t3.start();
		
		
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {drawJuliaSet(set,window,300,400);} 
			});
		t4.start();
		
		Thread t5 = new Thread(new Runnable() {
			@Override
			public void run() {drawJuliaSet(set,window,400,500);} 
			});
		t5.start();
		
		
		Thread t6 = new Thread(new Runnable() {
			@Override
			public void run() {drawJuliaSet(set,window,500,600);} 
			});
		t6.start();
		
		Thread t7 = new Thread(new Runnable() {
			@Override
			public void run() {drawJuliaSet(set,window,600,700);} 
			});
		t7.start();
		
		Thread t8 = new Thread(new Runnable() {
			@Override
			public void run() {drawJuliaSet(set,window,700,800);} 
			});
		t8.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			t6.join();
			t7.join();
			t8.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		
		window.display();//display the rendered set
	}
	
	public static void printUsage() {//printing the proper usage of the arguments & the combinations of arguments
		System.out.println(""
				+ "Usage : \n"
				+ "java Fractal [Mandelbrot/Julia]\n"
				+ "java Fractal [Mandelbrot] [Number of Iterations]\n"
				+ "java Fractal [Mandelbrot] [Region of Interest]\n"
				+ "java Fractal [Mandelbrot] [Region of Interest] [Number of Iterations]\n"
				+ "java Fractal [Julia] [Number of Iterations]\n"
				+ "java Fractal [Julia] [Real Part of C] [Imaginary Part of C]\n"
				+ "java Fractal [Julia] [Real Part of C] [Imaginary Part of C] [Number of Iterations]");
		System.exit(0);
	}
	
	
	public static void drawMandelbrotSet(Mandelbrot set, Interface window , int start, int end) {
		//drawing a part of the Mandelbrot set for points within a specified range
		for(int x=start ; x < end ; x++) {
			for(int y=0 ; y < WIDTH ; y++) {
				window.draw(x,y,set.getColour(x, y));
			}
		}
		
	}
	
	
	public static void drawJuliaSet(Julia set, Interface window , int start, int end) {
		//drawing a part of the Julia set for points within a specified range
		for(int x=start ; x < end ; x++) {
			for(int y=0 ; y < WIDTH ; y++) {
				window.draw(x,y,set.getColour(x, y));
			}
		}
		
	}
	
	
}
