package com.kryto.scrap.character;

import com.kryto.scrap.element.ElementFire;
import com.kryto.scrap.element.IElement;

public class TypeBoiler implements ICharacterType {

	@Override
	public String getName() {
		return "Boiler";
	}
	
	@Override
	public String getIntroQuote() {
		return "His flames? Death.";
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
