import java.awt.Color;

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
		this.real_min = -1.0;
		this.real_max = 1.0;
		this.imaginary_min = -1.0;
		this.imaginary_max = 1.0;
	}
	
	public Mandelbrot(double real_min,double real_max,double imaginary_min,double imaginary_max) {
		//when the user enters 4 command line arguments
		this.real_min = real_min;
		this.real_max = real_max;
		this.imaginary_min = imaginary_min;
		this.imaginary_max = imaginary_max;
		this.iterations = 1000;
	}
	
	public Mandelbrot(double real_min,double real_max,double imaginary_min,double imaginary_max, int iterations) {
		this.real_min = real_min;
		this.real_max = real_max;
		this.imaginary_min = imaginary_min;
		this.imaginary_max = imaginary_max;
		this.iterations = iterations;
	}
	
	
	public int getColour(int xvalue, int yvalue) {
		Complex mapped_point = new Complex(xvalue,yvalue,real_min,real_max,imaginary_min,imaginary_max);
		double cr = mapped_point.getX();
		double ci = mapped_point.getY();
		double a = 0,b = 0; //a = real part of z , b = imaginary part of z
		
		//Checking whether the complex number is a mandelbrot number or not.
		int i;
		for(i = 0 ; i < iterations ; i++) {
			
			double aa = a*a;
			double bb = b*b;
			double two_ab = 2*a*b;
			
			a = aa-bb + cr;
			b = two_ab + ci;
			
			if(a*a + b*b > 4) break;
		}
		
		/*If abs(Zn) exceeds 2 before the loop ends, i is less than the number of iterations
		 * if  abs(Zn) didnt exceed 2 by the end of the loop the number can be considered a Mandelbrot
		number.
		 */
		if(i == iterations) return 0x000000; //if the complex number is a mandelbrot number return black
		else return Color.HSBtoRGB((i/((float)iterations)*10), 1, 1);//else assign a color
		
	}
	
	
}
