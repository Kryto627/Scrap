package com.kryto.scrap.gui;

import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.Assets;

public class AbilityButton extends Component {

	public AbilityButton(int i) {
		
		int width = 72 * 4;
		int height = 28 * 4;
		
		int x = (13 * 4) + ((i / 2) * (width + (10 * 4)));
		int y = (103 * 4) + ((i % 2) * (height + (8 * 4)));
		
		bounds = new Rectangle(x, y, width, height);
	}
	
	@Override
	public void render() {
		
		Assets.abl_button.render(bounds);		
	}
}
