package com.kryto.scrap.gfx;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

import com.kryto.scrap.Game;
import com.kryto.scrap.geometry.Rectangle;

public class RenderUtil {

	/*public static void renderTexture(Texture texture, float x, float y, float width, float height) {

		texture.bind();

		GL11.glBegin(GL11.GL_QUADS);

		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2f(x, y);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2f(x + width, y);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2f(x + width, y + height);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2f(x, y + height);

		GL11.glEnd();

		GL11.glLoadIdentity();
	}

	public static void renderTexture(Texture texture, float x, float y, float width, float height, int tileX, int tileY, int tileWidth, int tileHeight) {

		texture.bind();
		
		float pixelX = 1.0F / texture.getTextureWidth();
		float pixelY = 1.0F / texture.getTextureHeight();

		float beginX = pixelX * tileX;
		float beginY = pixelY * tileY;
		
		float endX = (pixelX * tileWidth) + beginX;
		float endY = (pixelY * tileHeight) + beginY;
		
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glTexCoord2f(beginX, beginY);
		GL11.glVertex2f(x, y);

		GL11.glTexCoord2f(endX, beginY);
		GL11.glVertex2f(x + width, y);

		GL11.glTexCoord2f(endX, endY);
		GL11.glVertex2f(x + width, y + height);

		GL11.glTexCoord2f(beginX, endY);
		GL11.glVertex2f(x, y + height);

		GL11.glEnd();

		GL11.glLoadIdentity();
	}*/

	public static void renderRect(float x, float y, float width, float height, Color color) {

		color.bind();

		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2f(x, y);
		GL11.glVertex2f(x + width, y);
		GL11.glVertex2f(x + width, y + height);
		GL11.glVertex2f(x, y + height);

		GL11.glEnd();

		Color.white.bind();
	}
	
	public static void trace(Rectangle rect, Color color) {	
		
		color.bind();
		
		float x = (float)rect.getX();
		float y = (float)rect.getY();
		float width = (float)rect.getWidth();
		float height = (float)rect.getHeight();
		
		GL11.glLineWidth(2.5F);

		GL11.glBegin(GL11.GL_LINES);
		GL11.glVertex2f(x, y);
		GL11.glVertex2f(x + width, y);
		GL11.glEnd();

		GL11.glBegin(GL11.GL_LINES);
		GL11.glVertex2f(x + width, y);
		GL11.glVertex2f(x + width, y + height);
		GL11.glEnd();

		GL11.glBegin(GL11.GL_LINES);
		GL11.glVertex2f(x + width, y + height);
		GL11.glVertex2f(x, y + height);
		GL11.glEnd();
		
		GL11.glBegin(GL11.GL_LINES);
		GL11.glVertex2f(x, y + height);
		GL11.glVertex2f(x, y);
		GL11.glEnd();
		
		Color.white.bind();
	}
	
	public static void setBackgroundColor(Color color) {
		renderRect(0, 0, Game.getWidth(), Game.getHeight(), color);
	}
}
