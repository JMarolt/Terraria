package Item;

import java.awt.Graphics;

import Renderer.Texture;
import World.Tile;

public class Item {

	private Texture texture;
	
	public Item(String fileName) {
		texture = new Texture(fileName);
	}
	
	public Item(int x, int y) {
		
	}
	
	public Item(Tile tile) {
		
	}
	
	public void render(Graphics g) {
		texture.draw(g);
	}
	
}
