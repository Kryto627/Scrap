package com.kryto.scrap.character.element;

import com.kryto.scrap.abilities.AbilityBank;
import com.kryto.scrap.gfx.GLSprite;
import com.kryto.scrap.stats.Stats;

public interface IElement {
	
	public String getName();
	public GLSprite getEmblem();
	
	public default Stats getAdditiveStats() {
		return new Stats();
	}
	
	public default void addAbilities(AbilityBank bank) {
		
	}
}
