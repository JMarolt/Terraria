package Client;

import java.awt.Color;
import java.awt.Graphics;

import Block.Block;
import Item.Item;

public class Inventory {

	public Slot[][] slots;
	private Slot currentSlot;
	private boolean isOpen;
	private int width, height;
	private int slotLength = 72;
	
	//Player player
	public Inventory(int width, int height) {
		this.width = width;
		this.height = height;
		init();
	}
	
	public void init() {
		slots = new Slot[width][height];
		for(int i = 0; i < slots.length; i++) {
			for(int k = 0; k < slots[i].length; k++) {
				slots[i][k] = new Slot(this, i + (k * 9), null);
				if(i == 0) {
					slots[i][k].setHotbar(true);
				}else {
					continue;
				}
			}
		}
	}
	
	public int firstOpenSlot() {
		for(int i = 0; i < slots.length; i++) {
			for(int k = 0; k < slots[i].length; k++) {
				if(!slots[i][k].isOccupied()) {
					return slots[i][k].getID();
				}
			}
		}
		return -1;
	}
	
	private boolean isInInventory(Block block) {
		for(int i = 0; i < slots.length; i++) {
			for(int k = 0; k < slots[i].length; k++) {
				if(block.equals(slots[i][k].getBlock())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int getXFromID() {
		return (firstOpenSlot() % getWidth()) * slotLength + (10 * (firstOpenSlot() % getWidth())) + (slotLength - 16)/2 + 20;
	}
	
	public int getYFromID() {
		return firstOpenSlot()/getWidth() * slotLength + (10 * (firstOpenSlot()/getWidth())) + (slotLength - 16)/2 + 20;
	}
	
	public void pickUpItem(Block block, int amount) {
		System.out.println(firstOpenSlot());
		if(isInInventory(block)) {
			getSlot(block).setObjectAmount(getSlot(block).getObjectAmount() + amount);
		}else {
			getSlot(firstOpenSlot()).setBlock(block, amount);
		}
	}
	
	public void render(Graphics g) {
		if(isOpen) {
			g.setColor(Color.black);
			g.fillRect(0, 0, 1920, 1200);
			for(int i = 0; i < width; i++) {
				for(int k = 0; k < height; k++) {
					slots[i][k].render(g);
				}
			}
		}else {
			for(int i = 0; i < slots.length; i++) {
				slots[i][0].render(g);
			}
		}
	}
	
	private Slot getSlot(int ID) {
		for(int i = 0; i < slots.length; i++) {
			for(int k = 0; k < slots[i].length; k++) {
				if(slots[i][k].getID() == ID) {
					return slots[i][k];
				}
			}
		}
		return null;
	}
	
	private Slot getSlot(Block block) {
		for(int i = 0; i < slots.length; i++) {
			for(int k = 0; k < slots[i].length; k++) {
				if(slots[i][k].getBlock().equals(block)) {
					return slots[i][k];
				}
			}
		}
		return null;
	}
	
	public String toString() {
		return currentSlot.toString();
	}
	
	public void open() {
		isOpen = true;
	}
	
	public void close() {
		isOpen = false;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getSlotLength() {
		return slotLength;
	}

	public void setSlotLength(int slotLength) {
		this.slotLength = slotLength;
	}
	
}
