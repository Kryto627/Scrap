package com.kryto.scrap.abilities;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.events.EventAttack;
import com.kryto.scrap.events.EventDodged;
import com.kryto.scrap.events.listeners.EventHandler;
import com.kryto.scrap.level.LevelManager;
import com.kryto.scrap.util.MathUtil;

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
	public void onAction() {
		
		CharacterStack attacker = LevelManager.getInstance().getLevel().getFastest();
		CharacterStack target = LevelManager.getInstance().getLevel().getEnemyManager().getTargetCharacter();
		
		int damage = MathUtil.percent(attacker.getStats().getMaxDamage(), power);
		
		if (MathUtil.chance(target.getStats().getDodgeChance())) {
			
			EventHandler.getInstance().post(new EventDodged(attacker, target));
			
			target.dodge();
		} else {
			
			if (MathUtil.chance(attacker.getStats().getCritChance())) {
				
				EventHandler.getInstance().post(new EventAttack(attacker, target));
				
				target.damageCritical(damage);
				
			} else {
				
				EventHandler.getInstance().post(new EventAttack(attacker, target));
				
				target.damage(damage);
			}
		}
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
