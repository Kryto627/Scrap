package com.kryto.scrap;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class GLSprite {

	private Texture texture;
	
	public GLSprite(String path) {
		try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(path), GL11.GL_NEAREST);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void render(float x, float y) {
		render(x, y, texture.getWidth(), texture.getHeight());
	}
	
	public void render(float x, float y, float w, float h) {
		
		texture.bind();
		
		GL11.glBegin(GL11.GL_QUADS);
		
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(x, y);
			
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(x + w, y);
			
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(x + w, y + h);
			
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(x, y + h);
		
		GL11.glEnd();
	}
	
	public void renderSubTile(float renderX, float renderY, float renderWidth, float renderHeight, float tileX, float tileY, float tileWidth, float tileHeight) {
		
		texture.bind();
		
		float pixelX = 1.0F / texture.getTextureWidth();
		float pixelY = 1.0F / texture.getTextureHeight();
		
		float beginX = pixelX * tileX;
		float beginY = pixelY * tileY;
		
		float endX = (pixelX * tileWidth) + beginX;
		float endY = (pixelY * tileHeight) + beginY;
		
		GL11.glBegin(GL11.GL_QUADS);
			
			GL11.glTexCoord2f(beginX, beginY);
			
			GL11.glVertex2f(renderX, renderY);
			
			GL11.glTexCoord2f(endX, beginY);
			
			GL11.glVertex2f(renderX + renderWidth, renderY);
			
			GL11.glTexCoord2f(endX, endY);
			
			GL11.glVertex2f(renderX + renderWidth, renderY + renderHeight);
			
			GL11.glTexCoord2f(beginX, endY);
			
			GL11.glVertex2f(renderX, renderY + renderHeight);
		
		GL11.glEnd();
	}
	
	public void renderSubIndex(float x, float y, float w, float h, int i, float tileWidth, float tileHeight) {
		
		int tileAmountX = (int) (texture.getTextureWidth() / tileWidth);
		int tileAmountY = (int) (texture.getTextureHeight() / tileHeight);
		
		float tileX = (i % tileAmountX) * tileWidth;
		float tileY = (i % tileAmountY) * tileHeight;
		
		renderSubTile(x, y, w, h, tileX, tileY, tileWidth, tileHeight);
	}
	
	public Texture getTexture() {
		return texture;
	}
}
