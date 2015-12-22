package com.kryto.scrap.character.type;

import java.io.Serializable;

import com.kryto.scrap.character.element.ElementFire;
import com.kryto.scrap.character.element.IElement;
import com.kryto.scrap.stats.Stats;

public class TypeBoiler implements ICharacterType, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String getName() {
		return "Boiler";
	}
	
	@Override
	public String getIntroQuote() {
		return "His flames? Death.";
	}
	
	@Override
	public Stats getDefaultStats() {
		Stats stats = new Stats();
		stats.setDefense(15);
		stats.setDodgeChance(5);
		stats.setSpeed(30);
		return stats;
	}
	
	@Override
	public int getHealthMultiplier() {
		return 1000;
	}
	
	@Override
	public int getAttackMultiplier() {
		return 200;
	}
	
	@Override
	public IElement getElement() {
		return new ElementFire();
	}
}
