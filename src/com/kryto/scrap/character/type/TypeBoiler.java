package com.kryto.scrap.character.type;

import java.io.Serializable;

import com.kryto.scrap.abilities.AbilityBank;
import com.kryto.scrap.abilities.AbilityBase;
import com.kryto.scrap.abilities.AbilityType;
import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.character.element.ElementFire;
import com.kryto.scrap.character.element.IElement;
import com.kryto.scrap.effects.EffectHealOverTime;
import com.kryto.scrap.level.Level;
import com.kryto.scrap.level.attack.BufferedAttack;
import com.kryto.scrap.stats.Stats;
import com.kryto.scrap.util.MathUtil;

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
		stats.setCritChance(15);
		stats.setDodgeChance(5);
		stats.setSpeed(30);
		return stats;
	}
	
	@Override
	public int getHealthMultiplier() {
		return 1500;
	}
	
	@Override
	public int getAttackMultiplier() {
		return 200;
	}
	
	@Override
	public IElement getElement() {
		return new ElementFire();
	}
	
	@Override
	public void addAbilities(AbilityBank bank) {
		ICharacterType.super.addAbilities(bank);
		
		bank.add(new AbilityBase(AbilityType.SPECIAL, "Fury Weld") {
			
			@Override
			public void onAction(Level level) {
				
				CharacterStack attacker = level.getPlayerManager().getSelectedCharacter();
				CharacterStack target = level.getEnemyManager().getTargetCharacter();
				
				int power = 300;
				int damage = MathUtil.percent(attacker.getStats().getMaxDamage(), power);
				
				level.getAttackManager().addAttack(new BufferedAttack(attacker, target, power));
				
				target.getEffectManager().addEffect(new EffectHealOverTime(damage, 5));
			}
		});
	}
}
