package com.kryto.scrap.gfx;

public class GLAssets {

	public static GLFont PIXEL_OPERATOR;
	
	public static GLSprite gui_sheet;
	
	public static GLSubSprite logo;
	
	public static GLSubSprite button_end;
	public static GLSubSprite selected_button_end;
	
	public static void init() {
		
		PIXEL_OPERATOR = new GLFont("PixelOperator-Bold.ttf", 64);
		
		gui_sheet = new GLSprite("gui.png");
		logo = gui_sheet.getSubSprite(128, 0, 64, 22);
		
		button_end = gui_sheet.getSubSprite(124, 0, 4, 21);
		selected_button_end = gui_sheet.getSubSprite(124, 21, 4, 21);
	}
	
	public static void cleanup() {
		
	}
}
