package com.kryto.scrap.gfx;

public class Assets {

	public static CustomFont GRAVITY_ITALIC;
	
	public static void init() {
				
		GRAVITY_ITALIC = new CustomFont("/Gravity-Italic.ttf");		
		GRAVITY_ITALIC.setSize(32);
	}
}
