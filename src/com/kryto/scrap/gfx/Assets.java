package com.kryto.scrap.gfx;

public class Assets {

	public static GLFont PIXEL_OPERATOR_BIG, PIXEL_OPERATOR_SMALL;
	
	public static GLSprite gui_sheet;
	public static GLSprite battle_sheet;
	
	public static GLSprite logo;	
	public static GLSprite menu_background;
	
	public static GLSprite button_end;

	public static GLSprite battle_background;
	
	public static GLSprite abl_type_button;
	public static GLSprite abl_button;
	
	public static void init() {
		
		PIXEL_OPERATOR_BIG = new GLFont("PixelOperator-Bold.ttf", 64);
		PIXEL_OPERATOR_SMALL = new GLFont("PixelOperator-Bold.ttf", 32);
		
		gui_sheet = new GLSprite("gui_sheet.png");
		battle_sheet = new GLSprite("battle_sheet.png");
		
		logo = gui_sheet.getSubSprite(128, 0, 64, 22);
		menu_background = new GLSprite("menu_background.png");
		
		button_end = gui_sheet.getSubSprite(124, 0, 4, 21);		

		battle_background = battle_sheet.getSubSprite(0, 0, 320, 180);
		
		abl_type_button = battle_sheet.getSubSprite(0, 180, 32, 32);
		abl_button = battle_sheet.getSubSprite(0, 212, 78, 28);
	}
	
	public static void cleanup() {
		
		
	}
}
