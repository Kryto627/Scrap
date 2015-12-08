package com.kryto.scrap.element;

import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gfx.GLSprite;

public class ElementWind implements IElement {

	@Override
	public String getName() {
		return "Wind";
	}

	@Override
	public GLSprite getEmblem() {
		return Assets.gui_sheet.getSubSprite(26, 63, 26, 26);
	}
}
