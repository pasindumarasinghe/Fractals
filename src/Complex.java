/*
 * This class handles the complex numbers
 */
public class Complex {
	
	private final int WIDTH = 800;//The width of the Canvas
	private final int HEIGHT = 800;//The height of the Canvas
	private double real_min;//Minimum value of the Real axis in the Complex Plane
	private double real_max;//Maximum value of the Real axis in the Complex Plane
	private double imaginary_min;//Minimum value of the Imaginary axis in the Complex Plane
	private double imaginary_max;//Maximum value of the Imaginary axis in the Complex Plane
	
	
	private int x;//x and y are integers in the range [800,800]
	private int y;
	private double cx;//The real distance to the mapped number on the complex plane from the top left corner (real_min,imaginary_max)
	private double cy;////The imaginary distance to the mapped number on the complex plane from the top left corner (real_min,imaginary_max)
	private double x_diff;//range of the real axis in the region of interest
	private double y_diff;//range of the imaginary axis in the region of interest
	
	public Complex(int x, int y ,double real_min,double real_max,double imaginary_min,double imaginary_max) {
		//The constructor for the number that is to be mapped to the complex plane
		this.x = x;
		this.y = y;
		this.real_min = real_min;
		this.real_max = real_max;
		this.imaginary_min = imaginary_min;
		this.imaginary_max = imaginary_max;
	}
	
	public double getX() {
		//This method returns the real part of the mapped complex number
		x_diff = real_max - real_min;
		cx = (x/((double)WIDTH))*x_diff;
		return real_min+cx;
		
	}
	
	public double getY() {
		//this method returns the imaginary part of the mapped complex number
		y_diff = imaginary_max - imaginary_min;
		cy = (y/((double)HEIGHT))*y_diff;
		return imaginary_max-cy;
	}
	
	/*

	Mapping From Canvas to the Complex Plane
	----------------------------------------
	*Consider the canvas to be a 2D plane having 800 points in the X-axis and 800 points in the Y-axis.
	*The origin is considered to be the top left point.
	*Divide the range of the real axis to 800 segments and get the distance to the i_th segment from the origin which corresponds to the
	 i_th segment in the Canvas.Then, real_min+[x distance to the i_th segment] gives the real part of the mapped complex number.
	*Divide the range of the imaginary axis to 800 segments and get the distance to the i_th segment from the origin which corresponds to 
	the i_th segment in the Canvas.Then, imaginary_max-[y distance to the i_th segment] gives the imaginary part of the mapped complex
	number.
	*/

}
