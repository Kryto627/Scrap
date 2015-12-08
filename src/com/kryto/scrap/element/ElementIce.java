package com.kryto.scrap.element;

import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gfx.GLSprite;

public class ElementIce implements IElement {

	@Override
	public String getName() {
		return "Ice";
	}

	@Override
	public GLSprite getEmblem() {
		return Assets.gui_sheet.getSubSprite(52, 63, 26, 26);
	}
}
