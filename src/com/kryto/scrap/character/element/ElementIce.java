package com.kryto.scrap.character.element;

import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gfx.GLSprite;

public class ElementIce implements IElement {

	@Override
	public String getName() {
		return "Ice";
	}

	@Override
	public GLSprite getEmblem() {
		return Assets.emblem_sheet.getSubSprite(52, 0, 26, 26);
	}
}
