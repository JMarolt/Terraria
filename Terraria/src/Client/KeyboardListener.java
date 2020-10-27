package Client;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener extends KeyAdapter implements KeyListener{

	private boolean keyPressed[] = new boolean[128];
	private boolean pressed = false;
	private int key = 0;
	
	@Override
	public void keyPressed(KeyEvent keyEvent) {
		keyPressed[keyEvent.getKeyCode()] = true;
		key = keyEvent.getKeyCode();
		pressed = true;
	}
	
	@Override
	public void keyReleased(KeyEvent keyEvent) {
		keyPressed[keyEvent.getKeyCode()] = false;
		key = 0;
		pressed = false;
	}
	
	public boolean isKeyPressed(int keyCode) {
		if(pressed == false) {
			return keyPressed[keyCode];
		}else {
			return false;
		}
	}
	
	public boolean anyKeyPressed() {
		return key != 0;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
}