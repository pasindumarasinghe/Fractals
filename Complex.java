/*
 * This class handles the complex numbers
 */
public class Complex {
	
	private final int WIDTH = 800;
	private final int HEIGHT = 800;
	private double real_min;
	private double real_max;
	private double imaginary_min;
	private double imaginary_max;
	
	
	private int x;//x and y are integers in the range [800,800]
	private int y;
	private double cx;
	private double cy;
	private double x_diff;
	private double y_diff;
	
	public Complex(int x, int y ,double real_min,double real_max,double imaginary_min,double imaginary_max) {
		this.x = x;
		this.y = y;
		this.real_min = real_min;
		this.real_max = real_max;
		this.imaginary_min = imaginary_min;
		this.imaginary_max = imaginary_max;
	}
	
	public double getX() {
		x_diff = real_max - real_min;
		cx = (x/((double)WIDTH))*x_diff;
		return real_min+cx;
		
	}
	
	public double getY() {
		y_diff = imaginary_max - imaginary_min;
		cy = (y/((double)HEIGHT))*y_diff;
		return imaginary_max-cy;
	}

}
