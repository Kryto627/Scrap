package com.kryto.scrap.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter {

	private static Keyboard instance = new Keyboard();
	
	public static Keyboard getInstance() {
		return instance;
	}
	
	private boolean[] keys;
	
	private Keyboard() {
		keys = new boolean[256];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	public boolean isPressed(int key) {
		return keys[key];
	}
	
	public int getCurrentPressedKey() {
		
		for (int i= 0; i < keys.length; i++) {
			if (keys[i]) {
				return i;
			}
		}
		
		return -1;
	}
}
