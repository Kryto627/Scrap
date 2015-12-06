package com.kryto.scrap.gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.TextureImpl;
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
	
	public void setSize(float size) {
		font = font.deriveFont(size);
		trueTypeFont = new TrueTypeFont(font, true);
	}
	
	public void render(String text, float x, float y, Color color) {
		
		TextureImpl.bindNone();
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
		GL11.glPushAttrib(GL11.GL_CURRENT_BIT);
		
		trueTypeFont.drawString(x, y, text, color);
		
		GL11.glPopAttrib();
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		
	}
	
	public void renderCentered(String text, float x, float y, Color color) {		
		render(text, x - (getWidth(text) / 2), y - (getHeight() / 2), color);		
	}
	
	public int getWidth(String text) {
		return trueTypeFont.getWidth(text);
	}
	
	public int getHeight() {
		return trueTypeFont.getHeight() + 10;
	}
}