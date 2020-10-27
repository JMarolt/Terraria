package Block;

import Renderer.Texture;
import World.Tile;

public class Diamond extends Block{

	public Diamond(Tile tile) {
		super(tile);
		this.setTile(tile);
		this.setTexture(new Texture("src/renderer/diamondtest.png", tile.getX(), tile.getY()));
	}

}
