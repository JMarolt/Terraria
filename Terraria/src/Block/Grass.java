package Block;

import Renderer.Texture;
import World.Tile;

public class Grass extends Block{

	public Grass(Tile tile) {
		super(tile);
		this.setTile(tile);
		this.setTexture(new Texture("src/renderer/grassblock.png", tile.getX(), tile.getY()));
	}

}
