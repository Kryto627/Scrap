package com.kryto.scrap.level.attack;

import java.util.Random;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.util.IWipeable;

public class BufferedAttack implements IWipeable {

	private Random random = new Random();
	private boolean isDone = false;
	
	private CharacterStack attacker, target;
	private float power;
	
	private int defense = 0;
	private int dodge = 0;
	
	private int speed = 0;
	
	private int crit = 0;
	
	public BufferedAttack(CharacterStack attacker, CharacterStack target, float power) {
		this.attacker = attacker;
		this.target = target;
		this.power = power;
		
		this.defense = target.getCharacter().getDefense();
		this.dodge = target.getCharacter().getDodge();
		
		this.speed = attacker.getCharacter().getSpeed();
		
		this.crit = attacker.getCharacter().getCriticalChance();
	}

	public int getMaxDamage() {
		return (int) (attacker.getMaxAttack() * (power * 0.01F));
	}
	
	public void attack() {
		
		int dodgeChance = random.nextInt(100);
		int critChance = random.nextInt(100);
		
		if (dodgeChance <= dodge) {
			target.dodge();
		}
		
		else {
		
			int damage = getMaxDamage();
			damage -= damage * (defense * 0.01F);
				
			if (critChance <= crit) {
				target.damageCritical(damage);
			}
			
			else target.damage(damage);			
		}
		
		wipe();
	}
	
	public int getSpeed() {
		return speed;
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
