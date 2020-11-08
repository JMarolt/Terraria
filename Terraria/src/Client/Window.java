package Client;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import Block.Air;
import Renderer.Texture;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	private int width, height;
	private boolean fullscreen;
	public static MouseTracker ML = new MouseTracker();
	public static KeyboardListener KL = new KeyboardListener();
	
	public Window(int width, int height, boolean fullscreen) {
		this.width = width;
		this.height = height;
		this.fullscreen = fullscreen;
	}
	
	public Window(boolean fullscreen) {
		if(fullscreen) {
			this.width = Toolkit.getDefaultToolkit().getScreenSize().width;
			this.height = Toolkit.getDefaultToolkit().getScreenSize().height;
		}
	}
	
	public void init() {
		Texture.createTextures();
		this.setTitle("Terraria");
		this.setPreferredSize(new Dimension(width, height));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true);
		this.setUndecorated(fullscreen);
		this.addKeyListener(KL);
		this.addMouseListener(ML);
		this.addMouseMotionListener(ML);
		this.addMouseWheelListener(ML);
		this.add(Terraria.panel);
		this.pack();
		this.setVisible(true);
	}
	
	public void setCursor(Cursor cursor) {
		this.getContentPane().setCursor(cursor);
	}
	
	public void update() {
		Terraria.inv.setSlot(Terraria.inv.getSlot() + ML.getWheelRotations());
		Terraria.panel.repaint();
	}
	
}
