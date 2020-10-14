package Block;

import Renderer.Texture;
import World.Tile;

public class Stone extends Block{
	
	public Stone(Tile tile) {
		super(tile);
		this.setTile(tile);
		this.setTexture(new Texture("src/renderer/ballzlogo.jpg", tile.getX(), tile.getY(), 16, 16));
	}
	
}
