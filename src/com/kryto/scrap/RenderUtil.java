package com.kryto.scrap;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

public class RenderUtil {

	public static void renderRect(float x, float y, float width, float height, Color color) {
			
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		
		color.bind();
		
		GL11.glBegin(GL11.GL_QUADS);
		
			GL11.glVertex2f(x, y);
			GL11.glVertex2f(x + width, y);
			GL11.glVertex2f(x + width, y + height);
			GL11.glVertex2f(x, y + height);
		
		GL11.glEnd();
		
		Color.white.bind();
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}
}
