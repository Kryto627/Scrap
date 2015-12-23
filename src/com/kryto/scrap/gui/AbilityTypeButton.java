package com.kryto.scrap.gui;

import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gfx.GLSprite;

public class AbilityTypeButton extends Component {

	private GLSprite icon;
	
	public AbilityTypeButton(int i) {
		super(new Rectangle((19 + ((i - 1) * 80)) * 4, 102 * 4, 64 * 4, 64 * 4));
		
		icon = Assets.battle_sheet.getSubSprite(i * 32, 180, 32, 32);
	}
		
	public void render() {
		
		Rectangle rect = bounds;
		
		if (isMouseOver()) {
			rect = rect.addSize(20, 20);
		}
		
		Assets.abl_type_button.render(rect);
		icon.render(rect);
	}
}
