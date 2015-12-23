package com.kryto.scrap.gui;

import org.newdawn.slick.Color;

import com.kryto.scrap.Game;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.Assets;

public class Button extends Component {

	private String text;
	
	private float brightness = 0;
	private boolean forward = true;
	
	public Button(int x, int y, String text) {		
		super(new Rectangle(x, y, 71 * 4, 21 * 4));
		
		this.text = text;
	}
	
	public Button(int index, String text) {
		this(Game.getCenterX() - (71 * 4) / 2, 200 + ((Game.getCenterY() - 21 / 2) - index * 100), text);
	}
	
	public void render() {	
		
		Rectangle rect = bounds;
		
		if (!isMouseOver()) {
			brightness = 0;
		}
		
		else {
			
			rect = rect.addSize(10, 10);
			
			if (brightness >= 1) forward = false;
			else if (brightness < 0) forward = true;
			
			if (forward) brightness += 0.08F;
			else brightness -= 0.08F;	
		}
		
		Assets.button.render(rect);
		
		Color.white.bind();
		Assets.PIXEL_OPERATOR_BIG.renderCentered(text, rect.getCenterX(), rect.getCenterY(), Color.darkGray.brighter(brightness));
	}
		
	public void setText(String text) {
		this.text = text;
	}	
}
