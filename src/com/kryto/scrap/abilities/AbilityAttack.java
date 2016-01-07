package com.kryto.scrap.abilities;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.level.Level;
import com.kryto.scrap.level.attack.BufferedAttack;

public class AbilityAttack implements IAbility {

	private int power;
	private String name;
	private AbilityType type;
	
	public AbilityAttack(AbilityType type, int power, String name) {
		this.power = power;
		this.name = name;
		this.type = type;
	}

	@Override
	public void onAction(Level level) {
		
		CharacterStack attacker = level.getPlayerManager().getSelectedCharacter();
		CharacterStack target = level.getEnemyManager().getTargetCharacter();
		
		level.getAttackManager().addAttack(new BufferedAttack(attacker, target, power));
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public AbilityType getType() {
		return type;
	}
	
	public int getPower() {
		return power;
	}
}
