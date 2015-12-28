package com.kryto.scrap.gui;

import org.newdawn.slick.Color;

import com.kryto.scrap.Input;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.Assets;

public class Tooltip {
	
	private Rectangle mouseBounds;
	private String text;
	
	private Rectangle tooltipBounds;	
	
	public Tooltip(Rectangle mouseBounds, String text) {
		this.mouseBounds = mouseBounds;
		this.text = text;
		
		tooltipBounds = new Rectangle(0, 0, Assets.PIXEL_OPERATOR_SMALL.getWidth(text), 30);
	}
	
	public void render() {
		
		if (mouseBounds.isMouseOver()) {		
			
			tooltipBounds = new Rectangle(Input.getMouseX() + 5, Input.getMouseY() - 30, Assets.PIXEL_OPERATOR_SMALL.getWidth(text) + 5, 30);
			
			tooltipBounds.fill(Color.black);
			tooltipBounds.addSize(-4, -4).fill(Color.darkGray);
			
			Assets.PIXEL_OPERATOR_SMALL.renderCentered(text, tooltipBounds.getCenterX(), tooltipBounds.getCenterY() + 4, Color.white);
		}
	}
}
