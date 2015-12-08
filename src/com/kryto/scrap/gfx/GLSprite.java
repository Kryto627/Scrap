package com.kryto.scrap.gfx;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

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
		render(x - ((width * scale) / 2), y - ((height * scale) / 2), width * scale, height * scale);
	}
	
	public void render(Rectangle rect) {
		render((float)rect.getX(), (float)rect.getY(), (float)rect.getWidth(), (float)rect.getHeight());
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}