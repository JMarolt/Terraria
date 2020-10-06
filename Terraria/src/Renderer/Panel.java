package Renderer;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel{

	private static final long serialVersionUID = 1L;
	int x = 0;
	int y = 0;
	Texture tex = new Texture("src/Renderer/ballzlogo.jpg", x, y, 100, 100);
	int i = 0;
	
	//Main draw method
	public void paintComponent(Graphics g) {
		tex.draw(g);
		if(i < 1000) {
			tex.rotate(Math.PI/30.0, 1000, x, y);
			i++;
		}
		g.setColor(Color.black);
		g.drawLine(0, 0, 1000, 1000);
		x++;
		y++;
		tex.setX(x);
		tex.setY(y);
		System.out.println(x);
	}

}
