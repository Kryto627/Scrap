package com.kryto.scrap.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

	private static Mouse instance = new Mouse();
	
	public static Mouse getInstance() {
		return instance;
	}
	
	private boolean[] buttons;
	private int x, y;
	
	private Mouse() {
		buttons = new boolean[3];
		x = 0;
		y = 0;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		buttons[e.getButton()] = true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()] = false;
	}
	
	public boolean isPressed(int key) {
		return buttons[key];
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
