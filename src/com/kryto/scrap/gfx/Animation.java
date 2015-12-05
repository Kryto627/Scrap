package com.kryto.scrap.gfx;

import java.awt.Graphics2D;

import com.kryto.scrap.util.Timer;

public class Animation {

	private Timer timer;	
	private Sprite[] sprites;
	private int currentFrame;
	
	public Animation(long time, Sprite... sprites) {
		this.timer = new Timer(time);
		this.sprites = sprites;
		this.currentFrame = 0;
	}
	
	public void update() {
		
		if (timer.isDoneAndReset()) {
			currentFrame++;
			currentFrame %= sprites.length;
		}	
	}
	
	public void render(Graphics2D g, int x, int y) {
		getCurrentFrame().render(g, x, y);
	}
	
	public void render(Graphics2D g, int x, int y, int width, int height) {
		getCurrentFrame().render(g, x, y, width, height);
	}
	
	public Sprite getCurrentFrame() {
		return sprites[currentFrame];
	}
}
