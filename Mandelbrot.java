/*
 * This is the Specification of the Mandelbrot Set
 */
public class Mandelbrot {
	private int iterations;//number of iterations
	
	//The region of interest
	private double real_min;
	private double real_max;
	private double imaginary_min;
	private double imaginary_max;
	
	
	
	public Mandelbrot() {//default constructor
		this.iterations = 1000;
		this.real_min = -1;
		this.real_max = 1;
		this.imaginary_min = -1;
		this.imaginary_max = 1;
	}
	
	public Mandelbrot(double real_min,double real_max,double imaginary_min,double imaginary_max) {
		//when the user enters 4 command line arguments
		this.real_min = real_min;
		this.real_max = real_max;
		this.imaginary_min = imaginary_min;
		this.imaginary_max = imaginary_max;
	}
	
	public Mandelbrot(double real_min,double real_max,double imaginary_min,double imaginary_max, int iterations) {
		this.real_min = real_min;
		this.real_max = real_max;
		this.imaginary_min = imaginary_min;
		this.imaginary_max = imaginary_max;
		this.iterations = iterations;
	}
	
	
	public boolean isMandelbrot() {
		
	}
	
	
	
	
	
}
