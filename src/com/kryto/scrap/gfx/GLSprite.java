package com.kryto.scrap.gfx;

import java.awt.image.BufferedImage;

import com.kryto.scrap.geometry.Rectangle;

import static org.lwjgl.opengl.GL11.*;

public class GLSprite {

	private BufferedImage image;
	private int textureID;
	private int width, height;
	
	public GLSprite(String path) {
		this.image = ImageLoader.loadImage(path);
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.textureID = ImageLoader.loadTexture(image);
	}
	
	public GLSprite(BufferedImage image) {
		this.image = image;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.textureID = ImageLoader.loadTexture(image);
	}
	
	public GLSprite getSubSprite(int x, int y, int width, int height) {
		return new GLSprite(image.getSubimage(x, y, width, height));
	}
	
	public void bind() {
		glBindTexture(GL_TEXTURE_2D, textureID);
	}
	
	public void unbind() {
		glBindTexture(GL_TEXTURE_2D, 0);
	}
	
	public void render(float x, float y, float width, float height) {
		
		glEnable(GL_TEXTURE_2D);
		
		bind();
		
		glBegin(GL_QUADS);		
		
			glTexCoord2f(0, 0);
			glVertex2f(x, y);
			
			glTexCoord2f(1, 0);
			glVertex2f(x + width, y);
			
			glTexCoord2f(1, 1);
			glVertex2f(x + width, y + height);
			
			glTexCoord2f(0, 1);
			glVertex2f(x, y + height);
		
		glEnd();
		
		unbind();
		
		glLoadIdentity();
		
		glDisable(GL_TEXTURE_2D);
	}
	
	public void renderCentered(float x, float y, float scale) {
		
		float scaledWidth = width * scale;
		float scaledHeight = height * scale;
		
		render(x - (scaledWidth / 2), y - (scaledHeight / 2), scaledWidth, scaledHeight);
	}
	
	public void render(Rectangle rect) {
		render(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}