package com.kryto.scrap;

public class GLSubSprite {

	private GLSprite sprite;
	private int tileX, tileY, tileWidth, tileHeight;
	
	public GLSubSprite(GLSprite sprite, int tileX, int tileY, int tileWidth, int tileHeight) {
		this.sprite = sprite;
		this.tileX = tileX;
		this.tileY = tileY;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
	}
	
	public void render(float x, float y, float width, float height) {
		sprite.renderSubTile(x, y, width, height, tileX, tileY, tileWidth, tileHeight);
	}
	
	public void render(float x, float y, float scale) {
		render(x, y, tileWidth * scale, tileHeight * scale);
	}
	
	public void renderCentered(float x, float y, float scale) {
		render(x - (tileWidth * scale) / 2, y - (tileHeight * scale) / 2, tileWidth * scale, tileHeight * scale);
	}
}
