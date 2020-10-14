package Block;

import java.awt.Graphics;

import Renderer.Texture;
import World.Tile;

public class Block {

	private Tile tile;
	private Texture texture;
	private float hardness;
	private float lightness;
	private float opacity;
	private boolean isMinable;
	
	public Block(Tile tile) {
		this.tile = tile;
	}
	
	public void draw(Graphics g) {
		this.texture.draw(g);
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public float getHardness() {
		return hardness;
	}

	public void setHardness(float hardness) {
		this.hardness = hardness;
	}

	public float getLightness() {
		return lightness;
	}

	public void setLightness(float lightness) {
		this.lightness = lightness;
	}

	public float getOpacity() {
		return opacity;
	}

	public void setOpacity(float opacity) {
		this.opacity = opacity;
	}

	public boolean isMinable() {
		return isMinable;
	}

	public void setMinable(boolean isMinable) {
		this.isMinable = isMinable;
	}
	
}
