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
		this.iterations = 1000;
	}
	
	public Mandelbrot(double real_min,double real_max,double imaginary_min,double imaginary_max, int iterations) {
		this.real_min = real_min;
		this.real_max = real_max;
		this.imaginary_min = imaginary_min;
		this.imaginary_max = imaginary_max;
		this.iterations = iterations;
	}
	
	
	public boolean isMandelbrot(int xvalue, int yvalue) {
		Complex mapped_point = new Complex(xvalue,yvalue,real_min,real_max,imaginary_min,imaginary_max);
		double cr = mapped_point.getX();
		double ci = mapped_point.getY();
		double znr = 0,zni = 0;
		double zNr,zNi;
		
		//Checking whether the complex number is a mandelbrot number or not.
		int i;
		for(i = 0 ; i < iterations ; i++) {
			zNr = (znr*znr) - (zni*zni) + cr;
			zNi = 2*znr*zni + ci;
			
			znr = zNr;
			zni = zNi;
			
			//checking whether the abs(Zn) > 2
			if((znr*znr+zni*zni) > 4) break;
		}
		
		/*If abs(Zn) exceeds 2 before the loop ends, i is less than the number of iterations
		 * if  abs(Zn) didnt exceed 2 by the end of the loop the number can be considered a Mandelbrot
		number.
		 */
		if(i == iterations) return true;
		else return false;
		
	}
	
	
}
