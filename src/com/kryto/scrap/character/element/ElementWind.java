package com.kryto.scrap.character.element;

import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gfx.GLSprite;
import com.kryto.scrap.stats.Stats;

public class ElementWind implements IElement {

	@Override
	public String getName() {
		return "Wind";
	}
		
	@Override
	public Stats getAdditiveStats() {		
		Stats stats = new Stats();		
		stats.setDodgeChance(10);		
		return stats;
	}

	@Override
	public GLSprite getEmblem() {
		return Assets.emblem_sheet.getSubSprite(26, 0, 26, 26);
	}
}
