package Client;

import Renderer.Panel;

public class Terraria {
	
	private static Window window;
	public static Panel panel;
	private static boolean isRunning = true;
	
	public static int FPS = 60;
	
	public static void main(String[] args) {
		Terraria.init();
		while(isRunning) {
			update();
			try {
				Thread.sleep((long)(1000/FPS));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void init() {
		window = new Window(1920, 1080, true);
		panel = new Panel();
		window.add(panel);
		window.init();
	}
	
	private static void update() {
		window.update();
	}

}
