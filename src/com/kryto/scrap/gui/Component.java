package com.kryto.scrap.gui;

import org.lwjgl.input.Mouse;

import com.kryto.scrap.geometry.Rectangle;

public class Component {
	
	protected Rectangle bounds;
	
	private boolean disabled;
	
	private static boolean canCallClick;
	
	public Component(Rectangle bounds) {
		this.bounds = bounds;
	}
	
	public Component() {
		super();
	}
	
	public void update() {}
	
	public void render() {}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
	public boolean isDisabled() {
		return disabled;
	}
	
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
	public boolean isMouseOver() {		
		return !isDisabled() && bounds.isMouseOver();
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
