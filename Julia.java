import java.awt.Color;

/*
 * This is the specification of the Julia Set
 */
public class Julia {
	private int iterations;//number of iterations
	
	//the region of interest
	private final double real_min = -1;//minimum of the real axis
	private final double real_max = 1;//maximum of the real axis
	private final double imaginary_min = -1;//minimum of the imaginary axis
	private final double imaginary_max = 1;//maximum of the imaginary axis
	
	//real and imaginary parts of C
	private double c_real; //Real Part of C
	private double c_imaginary; //Imaginary Part of C

	//default constructor
	public Julia() {
		//constructing the object with the default values
		this.c_real = -0.4;
		this.c_imaginary = 0.6;
		this.iterations = 1000;
	}
	
	public Julia(int iterations) {//when the user has only specified the number of iterations
		this.c_real = -0.4;
		this.c_imaginary = 0.6;
		this.iterations = iterations;
	}
	
	
	public Julia(double c_real , double c_imaginary) {//when the user has only specified C
		this.c_real = c_real;
		this.c_imaginary = c_imaginary;
		this.iterations = 1000;
	}
	
	
	//when the user enters 2 command line arguments
	public Julia(double c_real , double c_imaginary, int iterations) {//When the user has specified both C and the Number of Iterations
		this.c_real = c_real;
		this.c_imaginary = c_imaginary;
		this.iterations = iterations;
	}
	
	
	public int getColour(int xvalue, int yvalue) {
		/*This method returns an integer corresponding to the number of iterations took place. If the number of iterations which were 
		  taken place in the method is equal to the number of iterations specified, that means Zn converges.So, the number is a Julia
		  number.Therefore the method outputs black. Otherwise, a colour is returned according to the number of iterations it took ABS(Z)
		  to exceeded 2.
		 */
		
		//Mapping the point in the canvas to the complex plane specified by the User(Region of Interest)
		Complex mapped_point = new Complex(xvalue,yvalue,real_min,real_max,imaginary_min,imaginary_max);
		double a = mapped_point.getX();
		double b = mapped_point.getY();
		/*
		Checking whether the mapped complex number is a Julia Number or not.Z[n+1] is calculated for the specified number of iterations
		and check whether Z is less than 2.Then it can be decided whether the number is a Julia number or not.
		
		*/
		
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
		//return a colour When the hugh,saturation and brightness is given
		
	}

}


