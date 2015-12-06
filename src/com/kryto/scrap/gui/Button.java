package com.kryto.scrap.gui;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import com.kryto.scrap.framework.Window;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.input.Mouse;

public class Button {

	public Rectangle bounds;	
	private String text;
	private static int defaultWidth = 101;
	
	public Button(int x, int y, int width, String text) {
		this.bounds = new Rectangle(x, y, width, 21);
		this.text = text;
	}
	
	public Button(int x, int y, String text) {
		this(x, y, defaultWidth, text);
	}
	
	public Button(int index, String text) {
		this(Window.getCenterX() - (defaultWidth / 2), (Window.getCenterY() - (index * 70)) + 100, defaultWidth, text);
	}
	
	public void update() {
		
	}
	
	public void render(Graphics2D g) {
		
		Assets.button.renderSubTile(bounds.x, bounds.y, bounds.width, bounds.height, 0, 0, defaultWidth, bounds.height);
	}
	
	public boolean isMouseOver() {		
		return bounds.contains(new Point(Mouse.getInstance().getX(), Mouse.getInstance().getY()));
	}
	
	public boolean isClicked() {
		return isMouseOver() && Mouse.getInstance().isPressed(MouseEvent.BUTTON1);
	}
}
