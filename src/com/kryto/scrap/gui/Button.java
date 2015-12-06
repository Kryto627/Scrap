package com.kryto.scrap.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import com.kryto.scrap.framework.Window;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.input.Mouse;

public class Button {

	public Rectangle bounds;	
	private String message;
	
	public Button(int x, int y, int width, String message) {
		this.bounds = new Rectangle(x, y, 200, 50);
		this.message = message;
	}
	
	public Button(int x, int y, String message) {
		this(x, y, 200, message);
	}
	
	public Button(int index, String message) {
		this(Window.getCenterX() - (200 / 2), (Window.getCenterY() - (index * 70)) + 100, 200, message);
	}
	
	public void update() {
		
	}
	
	public void render(Graphics2D g) {
		
		g.setColor(new Color(0, 0, 0, 50));
		g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		
		if (!message.isEmpty()) {
			
			Assets.GRAVITY_ITALIC.renderCenteredString(g, message, Color.WHITE, (bounds.x + (bounds.width / 2)), (bounds.y + (bounds.height / 2)));
		}		
		
		if (isMouseOver()) {
				
			g.setColor(Color.WHITE);
			g.draw(bounds);
		}
	}
		
	public boolean isMouseOver() {		
		return bounds.contains(new Point(Mouse.getInstance().getX(), Mouse.getInstance().getY()));
	}
	
	public boolean isClicked() {
		return isMouseOver() && Mouse.getInstance().isPressed(MouseEvent.BUTTON1);
	}
}
