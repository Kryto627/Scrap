package com.kryto.scrap;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

public class GLFont {

	private TrueTypeFont trueTypeFont;
	private Font font;
	
	public GLFont(String path, float size) {
		
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.getResourceAsStream(path));
			font = font.deriveFont(size);
			trueTypeFont = new TrueTypeFont(font, true);
		} 
		
		catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getHeight() {
		return trueTypeFont.getHeight() + 10;
	}
	
	public void setSize(float size) {
		font = font.deriveFont(size);
		trueTypeFont = new TrueTypeFont(font, true);
	}
	
	public void render(String text, float x, float y, Color color) {
				
		GL11.glPushAttrib(GL11.GL_CURRENT_BIT);
		
		trueTypeFont.drawString(x, y, text, color);
		
		GL11.glPopAttrib();
	}
	
	public void renderCentered(String text, float x, float y, Color color) {		
		render(text, x - (trueTypeFont.getWidth(text) / 2), y - (getHeight() / 2), color);		
	}
}