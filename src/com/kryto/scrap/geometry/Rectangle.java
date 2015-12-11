package com.kryto.scrap.geometry;

import org.newdawn.slick.Color;

import com.kryto.scrap.gfx.RenderUtil;

public class Rectangle {
	
	private float x, y, width, height;

	public Rectangle(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Rectangle rect) {
		this.x = rect.x;
		this.y = rect.y;
		this.width = rect.width;
		this.height = rect.height;
	}
	
	public boolean contains(float px, float py) {
		return px > x && px < (x + width) && py > y && py < (y + height);
	}
	
	public Rectangle addSize(float w, float h) {
		return new Rectangle(x - (w / 2), y - (h / 2), width + w, height + h);
	}
	
	public void fill(Color color) {
		RenderUtil.renderRect(x, y, width, height, color);
	}
	
	public Rectangle clone() {
		return new Rectangle(this);
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
	
	public float getCenterX() {
		return x + width / 2;
	}
	
	public float getCenterY() {
		return y + height / 2;
	}
}
