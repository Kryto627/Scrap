package com.kryto.scrap.character.type;

import java.io.Serializable;

import com.kryto.scrap.character.element.ElementWind;
import com.kryto.scrap.character.element.IElement;
import com.kryto.scrap.stats.Stats;

public class TypeCruise implements ICharacterType, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String getName() {
		return "Cruise";
	}

	@Override
	public String getIntroQuote() {
		return "The Top Gun.";
	}
	
	@Override
	public Stats getDefaultStats() {
		Stats stats = new Stats();
		stats.setDefense(10);
		stats.setCritChance(5);
		stats.setDodgeChance(10);
		stats.setSpeed(60);
		return stats;
	}
	
	@Override
	public int getHealthMultiplier() {
		return 1200;
	}
	
	@Override
	public int getAttackMultiplier() {
		return 240;
	}
	
	@Override
	public IElement getElement() {
		return new ElementWind();
	}
}
