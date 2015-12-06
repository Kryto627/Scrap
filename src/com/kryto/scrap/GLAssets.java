package com.kryto.scrap;

public class GLAssets {

	public static GLFont PIXEL_OPERATOR;
	
	public static GLSprite logo;
	
	public static void init() {
		
		PIXEL_OPERATOR = new GLFont("PixelOperator-Bold.ttf", 32);
		
		logo = new GLSprite("gui.png");
	}
	
	public static void cleanup() {
		
	}
}
