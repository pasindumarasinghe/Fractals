import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

//This is the Interface that Displays the Set
@SuppressWarnings("serial")
public class Interface extends JComponent{
	private final int HEIGHT = 800;
	private final int WIDTH = 800;
	
	private BufferedImage bi;
	private JFrame frame;
	
	//Building the Interface
	public Interface(String name){
		
		
		frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack(); 
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		
		bi = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	
	}
	
	@Override
	public void addNotify() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(bi,0,0,null);
	}
	
	public void draw(int x,int y ,int color) {//this methods is used to colour a specified point in the panel
		bi.setRGB(x,y,color);
	}
	
	public void display() {
		frame.setVisible(true);
	}

}
