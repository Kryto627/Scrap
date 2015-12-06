package com.kryto.scrap.gfx;

import com.kryto.scrap.GLSprite;

public class Assets {

	public static CustomFont GRAVITY_ITALIC;
	
	public static Sprite logo;
	
	public static GLSprite button;
	
	public static Sprite frigid;
	public static Animation frigidAnimated;
	
	public static Sprite cruise;
	public static Animation cruiseAnimated;
	
	public static Sprite boiler;
	public static Animation boilerAnimated;
	
	public static void init() {	
		
		GRAVITY_ITALIC = new CustomFont("/Gravity-Italic.ttf");		
		GRAVITY_ITALIC.setSize(32);
		
		logo = new Sprite("/scrap_logo.png");
		
		button = new GLSprite("button.png");
		
		frigid = new Sprite("/frigid_1.png");
		frigidAnimated = new Animation(500, frigid.getSubSprite(0, 0, 32, 32), frigid.getSubSprite(0, 32, 32, 32));
		
		cruise = new Sprite("/cruise_1.png");
		cruiseAnimated = new Animation(500, cruise.getSubSprite(0, 0, 32, 32), cruise.getSubSprite(0, 32, 32, 32));
		
		boiler = new Sprite("/boiler_1.png");
		boilerAnimated = new Animation(500, boiler.getSubSprite(0, 0, 32, 32), boiler.getSubSprite(0, 32, 32, 32));
	}
	
	public static void updateAnimations() {
		
		frigidAnimated.update();
		cruiseAnimated.update();
		boilerAnimated.update();
	}
}
