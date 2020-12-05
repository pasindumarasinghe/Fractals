

/*
 * E/17/207 - Marasinghe MAPG
 * CO225 - Project 1
 * Fractals
 */


public class Fractal{
	
	
	public static void main(String [] args) {
		
		final int HEIGHT = 800,WIDTH = 800;
		//Here, the command lines arguments are handled
		if(args[0].toLowerCase().equals("mandelbrot")) {
			Interface window = new Interface("Mandelbrot Set");
			Mandelbrot set = new Mandelbrot();
			
			//rendering the mandelbrot set
			for(int x=0 ; x < HEIGHT ; x++) {
				for(int y=0 ; y < WIDTH ; y++) {
					if(set.isMandelbrot(x,y)) {
						window.draw(x,y,0x00000000);
					}
					
					else {
						window.draw(x, y, 0xFFFFFFFF);
					}
				}
			}
			
			window.display();
			
	}
			
			
			
			
		else if(args[0].toLowerCase().equals("julia")) {
			System.out.println("Julia");
		}
			
		else { 
		System.out.println("Wrong Input");
		System.exit(0);
		}
		
	}
	
	
}
