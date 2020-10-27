package Block;

import Renderer.Texture;
import World.Tile;

public class Air extends Block {

	public Air(Tile tile) {
		super(tile);
		this.setTile(tile);
		this.setTexture(new Texture("src/renderer/air.png", tile.getX(), tile.getY()));
		this.setMinable(false);
		this.setAir(true);
	}
	
}
