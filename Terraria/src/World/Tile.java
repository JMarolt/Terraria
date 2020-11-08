package World;

import java.awt.Rectangle;

import Block.Block;

public class Tile {

	private int x, y;
	private Block block, background;
	private Rectangle collision;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		this.setCollision(new Rectangle(x, y, 16, 16));
	}

	public boolean isOccupied() {
		return !this.block.isAir();
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		if(this.block != null)
			this.getBlock().getTexture().setY(this.getBlock().getTexture().getY() + y);
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
		
	}

	public Block getBackground() {
		return background;
	}

	public void setBackground(Block background) {
		this.background = background;
	}

	public Rectangle getCollision() {
		return collision;
	}

	public void setCollision(Rectangle collision) {
		this.collision = collision;
	}
	
}
