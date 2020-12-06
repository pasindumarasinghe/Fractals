import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

//This is the Interface that Displays the Set
@SuppressWarnings("serial")
public class Interface extends JComponent{
	private final int HEIGHT = 800;//The height of the plane is 800 pixels
	private final int WIDTH = 800;//The width of the plane is 800 pixels
	
	private BufferedImage bi;
	private JFrame frame;
	
	//Building the Interface
	public Interface(String name){
		
		//Creating the frame
		frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack(); 
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		
		//this bufferedImage is used to colour the canvas
		bi = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	
	}
	
	@Override
	public void addNotify() {
		//set the size of the component
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
	}
	
	@Override
	public void paint(Graphics g) {
		//Drawing in the bufferedImage
		g.drawImage(bi,0,0,null);
	}
	
	public void draw(int x,int y ,int color) {//this methods is used to colour a specified point in the panel
		bi.setRGB(x,y,color);
	}
	
	public void display() {
		//setting the visibility of the frame
		frame.setVisible(true);
	}

}
