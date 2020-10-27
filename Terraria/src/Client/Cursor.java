package Client;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Renderer.Texture;

public class Cursor {

	private int x, y;
	private String file = "src/Renderer/cursor.png";
	private Texture texture;
	private Rectangle hotspot;
	
	public Cursor(int x, int y) {
		this.x = x;
		this.y = y;
		texture = new Texture(file);
		hotspot = new Rectangle(x, y, 1, 1);
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(texture.getImage(),x, y, null);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		this.hotspot.x = x;
		this.hotspot.y = y;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Rectangle getHotspot() {
		return hotspot;
	}

	public void setHotspot(Rectangle hotspot) {
		this.hotspot = hotspot;
	}
	
}
