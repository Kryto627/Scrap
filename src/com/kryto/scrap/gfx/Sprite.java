package com.kryto.scrap.gfx;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Sprite {

	private BufferedImage image;
	
	public Sprite(String imagePath) {
		image = ImageLoader.getImage(imagePath);
	}
	
	public Sprite(BufferedImage image) {
		this.image = image;
	}
	
	public Sprite getSubSprite(int x, int y, int width, int height) {
		return new Sprite(image.getSubimage(x, y, width, height));
	}
	
	public void render(Graphics2D g, int x, int y) {
		g.drawImage(image, x, y, null);		
	}
	
	public void render(Graphics2D g, int x, int y, int width, int height) {
		g.drawImage(image, x, y, width, height, null);		
	}
	
	public BufferedImage getImage() {
		return image;
	}
}
