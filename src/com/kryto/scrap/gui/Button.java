package com.kryto.scrap.gui;

import org.newdawn.slick.Color;

import com.kryto.scrap.Game;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gfx.GLSprite;

public class Button extends Component {

	private GLSprite image;
	private String text;
	
	private float brightness = 0;
	private boolean forward = true;
	
	private static final int defaultWidth = 275;
	
	public Button(int x, int y, int width, String text) {		
		super(new Rectangle(x, y, width, 80));
		
		this.text = text;
		
		this.image = Assets.gui_sheet.getSubSprite(0, 0, 70, 21);
	}
	
	public Button(int x, int y, String text) {
		this(x, y, defaultWidth, text);
	}
	
	public Button(int index, String text) {
		this(Game.getCenterX() - defaultWidth / 2, (Game.getCenterY() - (index * 100)) + 200, defaultWidth, text);
	}
	
	public void render() {	
		
		Rectangle rect = bounds;
		
		if (!isMouseOver()) {			
			brightness = 0;
		}
		
		else {
			
			rect = rect.addSize(30, 10);
			
			if (brightness >= 1) forward = false;
			else if (brightness < 0) forward = true;
			
			if (forward) brightness += 0.08F;
			else brightness -= 0.08F;	
		}
		
		image.render(rect);
		Assets.button_end.render(rect.getX() + rect.getWidth() - 20, rect.getY(), 20, rect.getHeight());
		
		Color.white.bind();
		Assets.PIXEL_OPERATOR_BIG.renderCentered(text, rect.getCenterX(), rect.getCenterY(), Color.darkGray.brighter(brightness));
	}
		
	public void setText(String text) {
		this.text = text;
	}	
}
