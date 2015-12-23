package com.kryto.scrap.character.element;

import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gfx.GLSprite;

public class ElementWind implements IElement {

	@Override
	public String getName() {
		return "Wind";
	}
	
	@Override
	public int getDodgeAdditive() {
		return 20;
	}	

	@Override
	public GLSprite getEmblem() {
		return Assets.emblem_sheet.getSubSprite(26, 0, 26, 26);
	}
}
