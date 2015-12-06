package com.kryto.scrap;

import org.lwjgl.opengl.GL11;

public class Rectangle {

	private float x, y, width, height;

	public Rectangle(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public boolean intersects(Rectangle rec) {

		return false;
	}

	public boolean contains(float tx, float ty) {
		return tx > x && tx < (x + width) && ty > y && ty < (y + height);
	}

	public void trace() {

		GL11.glLineWidth(2.5F);

		GL11.glBegin(GL11.GL_LINES);
		GL11.glVertex2f(x, y);
		GL11.glVertex2f(x + width, y);
		GL11.glEnd();

		GL11.glBegin(GL11.GL_LINES);
		GL11.glVertex2f(x, y);
		GL11.glVertex2f(x + width, y);
		GL11.glEnd();

		GL11.glBegin(GL11.GL_LINES);
		GL11.glVertex2f(x, y);
		GL11.glVertex2f(x + width, y);
		GL11.glEnd();
		
		GL11.glBegin(GL11.GL_LINES);
		GL11.glVertex2f(x, y);
		GL11.glVertex2f(x + width, y);
		GL11.glEnd();
	}
}