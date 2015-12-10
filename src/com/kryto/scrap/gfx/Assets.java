package com.kryto.scrap.gfx;

public class Assets {

	public static GLFont PIXEL_OPERATOR_BIG, PIXEL_OPERATOR_SMALL;
	
	public static GLSprite gui_sheet;
	
	public static GLSprite logo;
	
	public static GLSprite button_end;
	public static GLSprite selected_button_end;
	
	public static GLSprite background;
	
	public static void init() {
		
		PIXEL_OPERATOR_BIG = new GLFont("PixelOperator-Bold.ttf", 64);
		PIXEL_OPERATOR_SMALL = new GLFont("PixelOperator-Bold.ttf", 32);
		
		gui_sheet = new GLSprite("gui.png");
		
		logo = gui_sheet.getSubSprite(128, 0, 64, 22);
		
		button_end = gui_sheet.getSubSprite(124, 0, 4, 21);
		
		selected_button_end = gui_sheet.getSubSprite(124, 21, 4, 21);
		
		background = new GLSprite("bg.png");
	}
	
	public static void cleanup() {
		
		
	}
}
