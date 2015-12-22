package com.kryto.scrap.level.attack;

import java.util.Random;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.event.EventHandler;
import com.kryto.scrap.stats.Stats;
import com.kryto.scrap.util.IWipeable;
import com.kryto.scrap.util.MathUtil;

public class BufferedAttack implements IWipeable {

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
	
	public void attack() {
		
		int dodgeChance = random.nextInt(100);
		int critChance = random.nextInt(100);
		
		if (dodgeChance <= targetStats.getDodgeChance()) {
			target.dodge();
		}
		
		else {
			
			EventHandler.getInstance().call(e -> e.onAttack(attacker, target));
			
			int damage = getMaxDamage();
			damage -= MathUtil.percent(damage, targetStats.getDefense());
				
			if (critChance <= attackerStats.getCritChance()) {
				target.damageCritical(damage);
			}
			
			else {
				target.damage(damage);			
			}
		}
		
		wipe();
	}
	
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
