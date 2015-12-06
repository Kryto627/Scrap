package com.kryto.scrap;

import org.newdawn.slick.Color;

public class GLScrap {
	
	public void init() {
		GLAssets.init();
	}
	
	public void update() {
		GLAssets.update();
	}
	
	public void render() {
		Color.white.bind();
		new Rectangle(10, 10, 100, 100).trace();
	}
	
	public void cleanup() {
		GLAssets.cleanup();
	}
}
