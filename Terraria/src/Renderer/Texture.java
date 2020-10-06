package Renderer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Client.Terraria;

public class Texture {

	private String fileName;
	private BufferedImage image;
	private int width, height;
	private double radians;
	private int x, y;
	private AffineTransform at;
	private double defaultWidth, defaultHeight;
	
	public Texture(String fileName, int x, int y, int width, int height) {
		this.fileName = fileName;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.image = createImage(this.fileName);
		this.image = resize(this.image, width, height);
		at = AffineTransform.getTranslateInstance(x, y);
	}
	
	public Texture(String fileName, int x, int y) {
		this.fileName = fileName;
		this.x = x;
		this.y = y;
		this.image = createImage(this.fileName);
		at = AffineTransform.getTranslateInstance(x, y);
	}
	
	private BufferedImage createImage(String fileName) {
		try {
			this.image = ImageIO.read(new File(fileName));
			defaultWidth = (double)image.getWidth();
			defaultHeight = (double)image.getHeight();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public BufferedImage resize(BufferedImage image, int width, int height) {
		Image tmp = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = dimg.createGraphics();
		
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return dimg;
	}
	
	public void rotate(double radians) {
		this.radians += radians;
	}
	
	public void draw(Graphics g) {
		at = AffineTransform.getTranslateInstance(x, y);
		at.rotate(this.radians, width/2, height/2);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(image, at, null);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
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

	public double getRadians() {
		return radians;
	}

	public void setRadians(double radians) {
		this.radians = radians;
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

	public AffineTransform getAt() {
		return at;
	}

	public void setAt(AffineTransform at) {
		this.at = at;
	}

	public double getDefaultWidth() {
		return defaultWidth;
	}

	public void setDefaultWidth(double defaultWidth) {
		this.defaultWidth = defaultWidth;
	}

	public double getDefaultHeight() {
		return defaultHeight;
	}

	public void setDefaultHeight(double defaultHeight) {
		this.defaultHeight = defaultHeight;
	}
}
