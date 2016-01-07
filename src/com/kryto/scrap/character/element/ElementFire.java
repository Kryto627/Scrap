package com.kryto.scrap.character.element;

import com.kryto.scrap.abilities.AbilityAttack;
import com.kryto.scrap.abilities.AbilityBank;
import com.kryto.scrap.abilities.AbilityType;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gfx.GLSprite;

public class ElementFire implements IElement {
	
	@Override
	public String getName() {
		return "Fire";
	}

	@Override
	public GLSprite getEmblem() {
		return Assets.emblem_sheet.getSubSprite(0, 0, 26, 26);
	}
	
	@Override
	public void addAbilities(AbilityBank bank) {
		IElement.super.addAbilities(bank);
		bank.add(new AbilityAttack(AbilityType.ATTACK, 75, "Fire Slam"));
	}
}
