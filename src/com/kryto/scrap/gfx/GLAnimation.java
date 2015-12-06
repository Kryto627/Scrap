package com.kryto.scrap.gfx;

import com.kryto.scrap.util.Timer;

public class GLAnimation {

	private Timer timer;
	private GLSprite[] sprites;
	private int currentFrame;
	
	public GLAnimation(long time, GLSprite... sprites) {
		this.timer = new Timer(time);
		this.sprites = sprites;
		this.currentFrame = 0;
	}
	
	public GLSprite getCurrentSprite() {
		return sprites[currentFrame];
	}
	
	public void update() {
		if (timer.isDoneAndReset()) {
			currentFrame++;
			currentFrame %= sprites.length;
		}
	}
	
	public void render(float x, float y, float width, float height) {
		update();
		getCurrentSprite().render(x, y, width, height);
	}
}