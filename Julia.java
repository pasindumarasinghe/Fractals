/*
 * This is the specification of the Julia Set
 */
public class Julia {
	private int iterations;//number of iterations
	
	//the region of interest
	private final double real_min = -1;
	private final double real_max = 1;
	private final double imaginary_min = -1;
	private final double imaginary_max = 1;
	
	//real and imaginary parts of C
	private double c_real;
	private double c_imaginary;

	//default constructor
	public Julia() {
		this.c_real = -0.4;
		this.c_imaginary = 0.6;
		this.iterations = 1000;
	}
	
	//when the user enters 2 command line arguments
	public Julia(double c_real , double c_imaginary, int iterations) {
		this.c_real = c_real;
		this.c_imaginary = c_imaginary;
		this.iterations = iterations;
	}



}


