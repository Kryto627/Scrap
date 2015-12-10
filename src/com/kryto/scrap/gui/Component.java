package com.kryto.scrap.gui;

import org.lwjgl.input.Mouse;

import com.kryto.scrap.Game;
import com.kryto.scrap.geometry.Rectangle;

public class Component {
	
	protected Rectangle bounds;
	
	private static boolean canCallClick;
	
	public Component(Rectangle bounds) {
		this.bounds = bounds;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
	public void update() {
		
	}
	
	public void render() {
		
	}
	
	public boolean isMouseOver() {		
		return bounds.contains(Mouse.getX(), Game.getRealMouseY());
	}
	
	public boolean isClicked() {
		
		if (isMouseOver() && Mouse.isButtonDown(0) && canCallClick) {
			canCallClick = false;
			return true;
		}
		
		if (!Mouse.isButtonDown(0)) {
			canCallClick = true;
		}	
		
		return false;
	}
}
