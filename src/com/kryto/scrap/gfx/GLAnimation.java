package com.kryto.scrap.gfx;

import com.kryto.scrap.util.Timer;

public class GLAnimation {

	private Timer timer;
	private GLSprite sprite;
	private int tileWidth, tileHeight;
	private int[] indexes;
	private int currentIndex;
	
	public GLAnimation(long time, String path, int tileWidth, int tileHeight, int... indexes) {
		this.timer = new Timer(time);
		this.sprite = new GLSprite(path);
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.indexes = indexes;
		this.currentIndex = 0;
	}
	
	public void update() {
		
		if (timer.isDoneAndReset()) {
			currentIndex++;
			currentIndex %= indexes.length;
		}
	}
	
	public void render(float x, float y, float w, float h) {
		update();
		sprite.renderSubIndex(x, y, w, h, indexes[currentIndex], tileWidth, tileHeight);
	}
}