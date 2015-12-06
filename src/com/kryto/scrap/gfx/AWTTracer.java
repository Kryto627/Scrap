package com.kryto.scrap.gfx;

import java.awt.Rectangle;

import org.lwjgl.opengl.GL11;

public class AWTTracer {

	public static void trace(Rectangle rect) {	
				
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
	}
}
