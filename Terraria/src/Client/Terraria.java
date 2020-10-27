package Client;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import Block.Air;
import Block.Stone;
import Renderer.Panel;
import World.World;

public class Terraria{
	
	private static Window window;
	public static Panel panel;
	private static boolean isRunning = true;
	
	public static World world;
	
	public static int FPS = 60;
	
	public static void main(String[] args) {
		Terraria.init();
		while(isRunning) {
			update();
			if(world.isRunning()) {
				try {
					world.update();
					Thread.sleep((long)(1000/FPS));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void init() {
		window = new Window(1920, 1000, true);
		panel = new Panel();
		window.init();
		world = new World(120, 75);
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		    cursorImg, new Point(0, 0), "blank cursor");
		window.getContentPane().setCursor(blankCursor);
	}
	
	private static void update() {
		window.update();
		Window.ML.update();
		checkInput();
	}
	
	private static void checkInput() {
		if(Window.ML.mousePressed) {
			switch(Window.ML.mouseButton) {
				case MouseEvent.BUTTON1:
					Terraria.world.mineBlock(Window.ML.x, Window.ML.y, new Air(Terraria.world.tiles[Window.ML.x/16][Window.ML.y/16]));
					break;
				case MouseEvent.BUTTON3:
					Terraria.world.placeBlock(Window.ML.x, Window.ML.y, new Stone(Terraria.world.tiles[Window.ML.x/16][Window.ML.y/16]));
					break;
			}
		}
		if(Window.KL.anyKeyPressed()) {
			switch(Window.KL.getKey()) {
				case KeyEvent.VK_8:
					System.exit(0);
					break;
				case KeyEvent.VK_SPACE:
					Terraria.world.jump();
					break;
			}
		}
	}

}
