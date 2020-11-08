package Client;

import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseTracker extends MouseAdapter implements MouseMotionListener, MouseWheelListener{

	public boolean mousePressed = false;
	public boolean mouseDragged = false;
	public boolean mouseReleased = false;
	public int mouseButton = -1;
	public int x = MouseInfo.getPointerInfo().getLocation().x;
	public int y = MouseInfo.getPointerInfo().getLocation().y;
	private int pressedX = 0;
	private int pressedY = 0;
	public float dx = -1.0f, dy = -1.0f;
	private int wheelRotations = 0;
	
	public void update() {
		x = MouseInfo.getPointerInfo().getLocation().x;
		y = MouseInfo.getPointerInfo().getLocation().y;
		wheelRotations = 0;
	}
	
	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		this.mousePressed = true;
		this.mouseButton = mouseEvent.getButton();
		pressedX = x;
		pressedY = y;
	}
	
	@Override
	public void mouseReleased(MouseEvent mouseEvent) {
		this.mouseDragged = false;
		this.mousePressed = false;
		this.dx = 0;
		this.dy = 0;
		mouseReleased = true;
	}
	
	@Override
	public void mouseMoved(MouseEvent mouseEvent) {
		this.x = mouseEvent.getX();
		this.y = mouseEvent.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent mouseEvent) {
		this.mouseDragged = true;
		this.dx = mouseEvent.getX() - this.x;
		this.dy = mouseEvent.getY() - this.y;
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		wheelRotations = e.getWheelRotation();
	}

	public int getPressedX() {
		return pressedX;
	}

	public int getPressedY() {
		return pressedY;
	}

	public int getWheelRotations() {
		return wheelRotations;
	}

	public void setWheelRotations(int wheelRotations) {
		this.wheelRotations = wheelRotations;
	}
	
}