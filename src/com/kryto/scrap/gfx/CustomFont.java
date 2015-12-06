package com.kryto.scrap.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class CustomFont {

	private Font font;
	
	public CustomFont(String path) {
			
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, Assets.class.getResourceAsStream(path));
		} 
		
		catch (FontFormatException e) {
			e.printStackTrace();
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setSize(float size) {
		font = font.deriveFont((float)size);
	}
	
	public double getWidth(String str) {		
		return getBounds(str).getWidth();		
	}
		
	public double getHeight(String str) {		
		return getBounds(str).getHeight();		
	}
	
	public Rectangle2D getBounds(String text) {
		
		AffineTransform at = new AffineTransform();
		FontRenderContext frc = new FontRenderContext(at, true, true);
		
		return font.getStringBounds(text, frc);
	}
	
	public void setupRender(Graphics2D g) {		
		g.setFont(font);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}
	
	public void renderString(Graphics2D g, String text, Color color, int x, int y) {		
		setupRender(g);
		g.setColor(color);
		g.drawString(text, x, y);
	}
	
	public void renderCenteredString(Graphics2D g, String text, Color color, int x, int y) {
		
		renderString(g, text, color, (int) (x - (getWidth(text) / 2)), (int) (y - (getHeight(text) / 2)));	
	}
}
