package Client;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends JFrame{

	private static final long serialVersionUID = 1L;

	private int width, height;
	private boolean fullscreen;
	
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
		this.setTitle("Terraria");
		this.setPreferredSize(new Dimension(width, height));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true);
		this.setUndecorated(fullscreen);
		this.add(Terraria.panel);
		this.pack();
		this.setVisible(true);
	}
	
	public void update() {
		this.repaint();
		Terraria.panel.repaint();
	}
	
}
