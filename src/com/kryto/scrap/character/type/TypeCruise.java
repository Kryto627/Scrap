package com.kryto.scrap.character.type;

import com.kryto.scrap.element.ElementWind;
import com.kryto.scrap.element.IElement;

public class TypeCruise implements ICharacterType {

	@Override
	public String getName() {
		return "Cruise";
	}

	@Override
	public String getIntroQuote() {
		return "The Top Gun.";
	}
	
	@Override
	public int getHealthMultiplier() {
		return 800;
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
