package Block;

import Renderer.Texture;
import World.Tile;

public class Dirt extends Block{

	public Dirt(Tile tile) {
		super(tile);
		this.setTile(tile);
		this.setTexture(new Texture("src/renderer/dirt.png", tile.getX(), tile.getY()));
	}

}
