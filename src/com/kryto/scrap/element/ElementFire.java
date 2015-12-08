package com.kryto.scrap.element;

import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gfx.GLSprite;

public class ElementFire implements IElement {

	@Override
	public String getName() {
		return "Fire";
	}

	@Override
	public GLSprite getEmblem() {
		return Assets.gui_sheet.getSubSprite(0, 63, 26, 26);
	}
}
