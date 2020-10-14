package Renderer;

import java.awt.Graphics;

import javax.swing.JPanel;

import Client.Terraria;
import World.World;

public class Panel extends JPanel{

	private static final long serialVersionUID = 1L;
	boolean created = false;

	public Panel() {}
	
	//Main draw method
	public void paintComponent(Graphics g) {
		if(Terraria.world != null) {
			Terraria.world.render(g);
		}
	}

}
