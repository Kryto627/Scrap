package com.kryto.scrap.gui;

import java.awt.Point;
import java.awt.Rectangle;

import org.lwjgl.input.Mouse;

import com.kryto.scrap.GLGame;

public class Button {

	public Rectangle bounds;	
	private String text;
	private static int defaultWidth = 101;
	
	public Button(int x, int y, int width, String text) {
		this.bounds = new Rectangle(x, y, defaultWidth, 21);
		this.text = text;
	}
	
	public Button(int x, int y, String text) {
		this(x, y, defaultWidth, text);
	}
	
	public Button(int index, String text) {
		this(GLGame.getCenterX() - (defaultWidth / 2), (GLGame.getCenterY() - (index * 70)) + 100, defaultWidth, text);
	}
	
	public void update() {
		
	}
	
	public void render() {
		
		
	}
		
	public boolean isMouseOver() {		
		return bounds.contains(new Point(Mouse.getX(), Mouse.getY()));
	}
	
	public boolean isClicked() {
		return isMouseOver() && Mouse.isButtonDown(1);
	}
}
