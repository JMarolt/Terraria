package World;

import java.awt.Graphics;
import java.util.HashMap;

import Block.Stone;
import Renderer.Texture;

public class World {

	private int tilesWidth, tilesHeight;
	private Tile[][] tiles;
	private boolean isRunning = false;
	private HashMap<String, Texture> textures = new HashMap<String, Texture>();
	
	public World(int tilesWidth, int tilesHeight) {
		this.tilesWidth = tilesWidth;
		this.tilesHeight = tilesHeight;
		tiles = new Tile[this.tilesWidth][this.tilesHeight];
		createWorld();
	}
	
	private void createWorld() {
		for(int i = 0; i < tilesWidth; i++) {
			for(int k = 0; k < tilesHeight; k++) {
				tiles[i][k] = new Tile(i * 16, k * 16);
				tiles[i][k].setBlock(new Stone(tiles[i][k]));
			}
		}
	}
	
	private void createTextures() {
		//textures.put("Stone", new Texture());
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < tilesWidth; i++) {
			for(int k = 0; k < tilesHeight; k++) {
				tiles[i][k].getBlock().draw(g);
				//isRunning = true;
			}
		}
	}

	public int getTilesWidth() {
		return tilesWidth;
	}

	public void setTilesWidth(int tilesWidth) {
		this.tilesWidth = tilesWidth;
	}

	public int getTilesHeight() {
		return tilesHeight;
	}

	public void setTilesHeight(int tilesHeight) {
		this.tilesHeight = tilesHeight;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
}
