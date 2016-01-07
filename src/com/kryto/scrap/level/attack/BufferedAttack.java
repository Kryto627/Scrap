package com.kryto.scrap.level.attack;

import java.util.Random;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.events.EventAttack;
import com.kryto.scrap.events.EventDodged;
import com.kryto.scrap.events.listeners.EventHandler;
import com.kryto.scrap.stats.Stats;
import com.kryto.scrap.util.MathUtil;

public class BufferedAttack implements IBufferedAction {

	private Random random = new Random();
	private boolean isDone = false;
	
	private CharacterStack attacker, target;
	private Stats attackerStats, targetStats;
	private float power;
	
	public BufferedAttack(CharacterStack attacker, CharacterStack target, float power) {
		this.attacker = attacker;
		this.target = target;
		this.power = power;
		
		this.attackerStats = attacker.getStats().clone();
		this.targetStats = target.getStats().clone();
	}

	public int getMaxDamage() {
		return (int) MathUtil.percent(attackerStats.getMaxDamage(), power);
	}
	
	@Override
	public void onAction() {
		
		int dodgeChance = random.nextInt(100);
		int critChance = random.nextInt(100);
		
		if (dodgeChance <= targetStats.getDodgeChance()) {
			
			EventHandler.getInstance().post(new EventDodged(attacker, target));
			
			target.dodge();			
		}
		
		else {
			
			EventHandler.getInstance().post(new EventAttack(attacker, target));
			
			attacker.getBuffManager().onAttack(target);
			
			int damage = getMaxDamage();
			damage -= MathUtil.percent(damage, targetStats.getDefense());
				
			if (critChance < attackerStats.getCritChance()) {
				target.damageCritical(damage);
			}
			
			else {
				target.damage(damage);			
			}
		}
	}
	
	@Override
	public int getSpeed() {
		return attackerStats.getSpeed();
	}

	@Override
	public void wipe() {
		isDone = true;
	}

	@Override
	public boolean wiped() {
		return isDone;
	}
}
