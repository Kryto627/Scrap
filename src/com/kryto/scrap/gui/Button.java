package com.kryto.scrap.gui;

import java.awt.Rectangle;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;

import com.kryto.scrap.GLAssets;
import com.kryto.scrap.GLGame;
import com.kryto.scrap.GLSubSprite;

public class Button {

	public Rectangle bounds;
	private GLSubSprite image, selected_image;
	private String text;
	private static int defaultWidth = 101;
	private static int defaultScale = 4;
	
	public Button(int x, int y, int width, String text) {
		this.bounds = new Rectangle(x - ((width * defaultScale) / 2), y - ((21 * defaultScale) / 2), width * defaultScale, 21 * defaultScale);
		this.image = GLAssets.gui_sheet.getSubSprite(0, 0, width - 4, 21);
		this.selected_image = GLAssets.gui_sheet.getSubSprite(0, 21, width - 4, 21);
		this.text = text;		
	}
	
	public Button(int x, int y, String text) {
		this(x, y, defaultWidth, text);
	}
	
	public Button(int index, String text) {
		this(GLGame.getCenterX() - (defaultWidth / 2), (GLGame.getCenterY() - (index * 70)) + 100, defaultWidth, text);
	}
	
	public void update() {
		
	}
	
	public void render() {	
		
		if (!isMouseOver()) {		
			image.renderCentered((float)bounds.getCenterX() - 10, (float)bounds.getCenterY(), defaultScale);
			GLAssets.button_end.renderCentered(bounds.x + bounds.width - 10, (float)bounds.getCenterY(), defaultScale);
		}
		
		else {
			selected_image.renderCentered((float)bounds.getCenterX() - 10, (float)bounds.getCenterY(), defaultScale);
			GLAssets.selected_button_end.renderCentered(bounds.x + bounds.width - 10, (float)bounds.getCenterY(), defaultScale);
		}
		
		GLAssets.PIXEL_OPERATOR.renderCentered(text, (float)bounds.getCenterX(), (float)bounds.getCenterY(), Color.darkGray);
	}
		
	public boolean isMouseOver() {		
		return bounds.contains(Mouse.getX(), Mouse.getY());
	}
	
	public boolean isClicked() {
		return isMouseOver() && Mouse.isButtonDown(1);
	}
}
