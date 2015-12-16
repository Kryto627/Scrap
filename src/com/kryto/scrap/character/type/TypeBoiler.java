package com.kryto.scrap.character.type;

import java.io.Serializable;

import com.kryto.scrap.element.ElementFire;
import com.kryto.scrap.element.IElement;

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
