package com.kryto.scrap.abilities;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.level.Level;
import com.kryto.scrap.level.attack.BufferedHeal;

public class AbilityHeal implements IAbility {

	private int amount;
	private String name;
	private AbilityType type;

	public AbilityHeal(int amount, String name, AbilityType type) {
		this.amount = amount;
		this.name = name;
		this.type = type;
	}

	@Override
	public void onAction(Level level) {
		
		CharacterStack source = level.getPlayerManager().getSelectedCharacter();
		
		level.getAttackManager().addAttack(new BufferedHeal(source, source, amount));
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public AbilityType getType() {
		return type;
	}
}
