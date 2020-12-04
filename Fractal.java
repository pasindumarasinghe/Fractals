/*
 * E/17/207 - Marasinghe MAPG
 * CO225 - Project 1
 * Fractals
 */
public class Fractal {
	public static void main(String [] args) {
		if(args[0].toLowerCase().equals("mandelbrot")) {
			Mandelbrot set = new Mandelbrot();
		}
		else if(args[0].toLowerCase().equals("julia")) {
			Julia set = new Julia();
		}
		else System.out.println("Wrong Input");
	}
}
