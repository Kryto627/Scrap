package com.kryto.scrap.gui;

import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.Assets;

public class ButtonBack extends Component {

	public ButtonBack(int x, int y) {
		super(new Rectangle(x, y, 50 * 4, 18 * 4));
	}
	
	@Override
	public void render() {
		
		Rectangle rect = bounds;
		
		if (isMouseOver()) {
			rect = rect.addSize(5, 5);
		}
		
		Assets.button_back.render(rect);
	}
}
