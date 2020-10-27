package World;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import Block.Air;
import Block.Block;
import Block.Diamond;
import Block.Dirt;
import Block.Stone;
import Client.Cursor;
import Client.Window;
import Renderer.Texture;

public class World {

	private int tilesWidth, tilesHeight;
	public Tile[][] tiles;
	private boolean isRunning = false;
	private HashMap<Integer, Texture> textures = Texture.textures;
	private int mouseX;
	private int mouseY;
	private Cursor cursor;
	private Tile prevTile;
	
	public World(int tilesWidth, int tilesHeight) { 
		this.tilesWidth = tilesWidth;
		this.tilesHeight = tilesHeight;
		tiles = new Tile[this.tilesWidth][this.tilesHeight];
		createWorld();
	}
	
	public void update() {
		mouseX = Window.ML.x;
		mouseY = Window.ML.y;
		cursor.setX(mouseX);
		cursor.setY(mouseY);
//		for(int i = 0; i < tilesWidth; i++) {
//			for(int k = 0; k < tilesHeight; k++) {
//				if(cursor.getHotspot().intersects(tiles[i][k].getCollision())) {
//					tiles[i][k].getBlock().getTexture().setOpacity(0.2f);
//				}
//			}
//		}
	}
	
	private void createWorld() {
		int random = 0;
		for(int i = 0; i < tilesWidth; i++) {
			for(int k = 0; k < tilesHeight; k++) {
				random = (int)(Math.random()*10);
				tiles[i][k] = new Tile(i * 16, k * 16);
				if(k < 4) {
					tiles[i][k].setBlock(new Dirt(tiles[i][k]));
				}else if(random == 0){
					tiles[i][k].setBlock(new Diamond(tiles[i][k]));
				}else {
					tiles[i][k].setBlock(new Stone(tiles[i][k]));
				}
			}
		}
		cursor = new Cursor(mouseX, mouseY);
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < tilesWidth; i++) {
			for(int k = 0; k < tilesHeight; k++) {
				if(tiles[i][k] != null) {
					tiles[i][k].getBlock().draw(g);
				}
			}
		}
		cursor.draw(g);
//		Texture cursorTexture = new Texture("src/Renderer/cursor.png", mouseX, mouseY);
//		cursorTexture.draw(g);
	}
	
	private void noise() {
		
	}
	
	public void mineBlock(int x, int y, Block block) {
		tiles[x/16][y/16].setBlock(block);
	}
	
	public void placeBlock(int x, int y, Block block) {
		if(tiles[x/16][y/16].getBlock().isAir()) {
			tiles[x/16][y/16].setBlock(block);
		}
	}
	
	public void jump() {
		for(int i = 0; i < tiles.length; i++) {
			for(int k = 0; k < tiles[0].length; k++) {
				System.out.println(tiles[i][k].getY());
				tiles[i][k].setY(tiles[i][k].getY() - 1);
				System.out.println("texture: " + tiles[i][k].getBlock().getTexture().getY());
			}
		}
	}
	
	private Tile getTile(int x, int y) {
		for(int i = 0; i < tiles.length; i++) {
			for(int k = 0; k < tiles[0].length; k++) {
				if(x == tiles[i][k].getX() && y == tiles[i][k].getY()) {
					return tiles[i][k];
				}
			}
		}
		return null;
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
