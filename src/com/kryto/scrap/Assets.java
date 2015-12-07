package com.kryto.scrap;

import com.kryto.scrap.gfx.GLFont;
import com.kryto.scrap.gfx.GLSprite;

public class Assets {

	public static GLFont PIXEL_OPERATOR;
	
	public static GLSprite gui_sheet;
	
	public static GLSprite logo;
	
	public static GLSprite button_end;
	public static GLSprite selected_button_end;
	
	public static GLSprite background;
	
	public static void init() {
		
		PIXEL_OPERATOR = new GLFont("PixelOperator-Bold.ttf", 64);
		
		gui_sheet = new GLSprite("gui.png");
		
		logo = gui_sheet.getSubSprite(128, 0, 64, 22);
		
		button_end = gui_sheet.getSubSprite(124, 0, 4, 21);
		
		selected_button_end = gui_sheet.getSubSprite(124, 21, 4, 21);
		
		background = new GLSprite("bg.png");
	}
	
	public static void cleanup() {
		
		
	}
}
