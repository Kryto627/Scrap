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
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public GLSprite(Texture texture) {
		this.texture = texture;
	}
	
	public void render(float x, float y) {
		render(x, y, texture.getTextureWidth(), texture.getTextureHeight());
	}
	
	public void render(float x, float y, float width, float height) {
		
		RenderUtil.renderTexture(texture, x, y, width, height);
	}
	
	public void renderSubTile(float renderX, float renderY, float renderWidth, float renderHeight, int tileX, int tileY, int tileWidth, int tileHeight) {
		
		RenderUtil.renderTexture(texture, renderX, renderY, renderWidth, renderHeight, tileX, tileY, tileWidth, tileHeight);
	}
	
	public void renderSubIndex(float x, float y, float w, float h, int i, int tileWidth, int tileHeight) {
		
		int tileAmountX = (int) (texture.getTextureWidth() / tileWidth);
		int tileAmountY = (int) (texture.getTextureHeight() / tileHeight);
		
		int tileX = (i % tileAmountX) * tileWidth;
		int tileY = (i % tileAmountY) * tileHeight;
		
		renderSubTile(x, y, w, h, tileX, tileY, tileWidth, tileHeight);
	}
	
	public GLSubSprite getSubSprite(int tileX, int tileY, int tileWidth, int tileHeight) {
		return new GLSubSprite(this, tileX, tileY, tileWidth, tileHeight);
	}
	
	public Texture getTexture() {
		return texture;
	}
}
