package com.kryto.scrap.character.type;

import com.kryto.scrap.element.ElementIce;
import com.kryto.scrap.element.IElement;

public class TypeFrigid implements ICharacterType {

	@Override
	public String getName() {
		return "Frigid";
	}

	@Override
	public String getIntroQuote() {
		return "They call him The Fridge.";
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
