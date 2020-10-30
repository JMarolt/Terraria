package Block;

import Renderer.Texture;
import World.Tile;

public class Stone extends Block{
	
	public Stone(Tile tile) {
		super(tile);
		this.setTile(tile);
		this.setTexture(new Texture("src/renderer/stone.png", tile.getX(), tile.getY()));
	}
	
	public Stone(int x, int y) {
		this.setTexture(new Texture("src/renderer/stone.png", x, y));
	}
	
	public Stone() {
		this.setTexture(new Texture("src/renderer/stone.png"));
	}
	
}
