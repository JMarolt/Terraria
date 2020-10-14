package World;

import Block.Block;

public class Tile {

	private int x, y;
	private Block block, background;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
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
	
}
