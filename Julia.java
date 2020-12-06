import java.awt.Color;

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
	
	
	public Julia(double c_real , double c_imaginary) {
		this.c_real = c_real;
		this.c_imaginary = c_imaginary;
	}
	
	
	//when the user enters 2 command line arguments
	public Julia(double c_real , double c_imaginary, int iterations) {
		this.c_real = c_real;
		this.c_imaginary = c_imaginary;
		this.iterations = iterations;
	}
	
	
	public int getColour(int xvalue, int yvalue) {
		Complex mapped_point = new Complex(xvalue,yvalue,real_min,real_max,imaginary_min,imaginary_max);
		double a = mapped_point.getX();
		double b = mapped_point.getY();
		
		
		int i;
		for(i = 0 ; i < iterations ; i++) {
			double aa = a*a;
			double bb = b*b;
			double two_ab = 2*a*b;
			
			a = aa-bb + c_real;
			b = two_ab + c_imaginary;
			
			if(a*a + b*b > 4) break;
		}
		
		/*If abs(Zn) exceeds 2 before the loop ends, i is less than the number of iterations
		 * if  abs(Zn) didnt exceed 2 by the end of the loop the number can be considered a Julia
		number.
		 */
		if(i == iterations) return 0x000000; //if the complex number is a Julia number return black
		else return Color.HSBtoRGB((i/((float)iterations)*10), 1, 1); 
		
	}



}


