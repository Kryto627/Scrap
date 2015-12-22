package com.kryto.scrap.character.type;

import java.io.Serializable;

import com.kryto.scrap.element.ElementIce;
import com.kryto.scrap.element.IElement;
import com.kryto.scrap.stats.Stats;

public class TypeFrigid implements ICharacterType, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String getName() {
		return "Frigid";
	}

	@Override
	public String getIntroQuote() {
		return "They call him The Fridge.";
	}
	
	@Override
	public Stats getDefaultStats() {
		Stats stats = new Stats();
		stats.setDefense(30);
		stats.setDodgeChance(1);
		stats.setSpeed(20);
		return stats;
	}
	
	@Override
	public int getHealthMultiplier() {
		return 1200;
	}
		
	@Override
	public int getAttackMultiplier() {
		return 160;
	}
	
	@Override
	public IElement getElement() {
		return new ElementIce();
	}
}
