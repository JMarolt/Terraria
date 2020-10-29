package Client;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Block.Block;

public class Slot {

	private Inventory in;
	private int ID;
	private Block block;
	private boolean isHotbar;
	private int x, y;
	private int slotLength;
	
	public Slot(Inventory in, int ID, Block block) {
		this.in = in;
		this.ID = ID;
		this.block = block;
		slotLength = in.getSlotLength();
		x = (ID % in.getWidth()) * slotLength + (10 * (ID % in.getWidth())) + 20;
		y = ID/in.getWidth() * slotLength + (10 * (ID/in.getWidth())) + 20;
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		//background
		g2d.setColor(new Color(25, 121, 169));
		if(in.isOpen()) {
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
		}else {
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		}
		g.fillRoundRect(x, y, slotLength, slotLength, 75, 75);
		if(block != null)
		block.draw(g);
	}
	
	public boolean isOccupied() {
		return block != null;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public boolean isHotbar() {
		return isHotbar;
	}

	public void setHotbar(boolean isHotbar) {
		this.isHotbar = isHotbar;
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

	public int getSlotLength() {
		return slotLength;
	}

	public void setSlotLength(int slotLength) {
		this.slotLength = slotLength;
	}
	
}
