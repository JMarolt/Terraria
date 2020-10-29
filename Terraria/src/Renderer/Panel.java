package Renderer;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import Client.Cursor;
import Client.Terraria;
import Client.Window;

public class Panel extends JPanel{

	private static final long serialVersionUID = 1L;
	public static boolean texturesLoaded = false;
	private Cursor cursor;

	public Panel() {
		cursor = new Cursor(Window.ML.x, Window.ML.y);
	}
	
	public void update() {
		cursor.setX(Window.ML.x);
		cursor.setY(Window.ML.y);
	}
	
	//Main draw method
	public void paintComponent(Graphics g) {
		//Texture.loadTextures(g);
//		if(Terraria.world != null && texturesLoaded) {
//			Terraria.world.render(g);
//		}
		try {
			Thread.sleep((long)(1000/60));
			g.setColor(Color.black);
			g.fillRect(0, 0, 1920, 1200);
			if(Terraria.world != null) {
				Terraria.world.render(g);
				if(!Terraria.world.isRunning())
				Terraria.world.setRunning(true);
				Terraria.inv.render(g);
			}
			drawCursor(g);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void drawCursor(Graphics g) {
		cursor.draw(g);
	}

}
