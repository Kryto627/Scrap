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
	
	public GLAnimation(long time, GLSprite sheet, int size, int... frames) {
		this.timer = new Timer(time);
		this.sprites = new GLSprite[frames.length];
		
		int tileAmountX = sheet.getWidth() / size;
		int tileAmountY = sheet.getHeight() / size;
		
		for (int i = 0; i < frames.length; i++) {
			
			int tileX = (i % tileAmountX) * size;
			int tileY = (i / tileAmountY) * size;
			
			sprites[i] = sheet.getSubSprite(tileX, tileY, size, size);
		}
	}
	
	public GLAnimation(long time, GLSprite sheet, int size) {
		this.timer = new Timer(time);
		
		int tilesX = sheet.getWidth() / size;
		int tilesY = sheet.getHeight() / size;
		
		this.sprites = new GLSprite[tilesX * tilesY];
		
		for (int x = 0; x < tilesX; x++) {
			for (int y = 0; y < tilesY; y++) {
			
				sprites[x + y * tilesX] = sheet.getSubSprite(x * size, y * size, size, size);
			}
		}
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