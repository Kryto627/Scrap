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
	
	public BufferedAttack(CharacterStack attacker, CharacterStack target, float power) {
		this.attacker = attacker;
		this.target = target;
		this.power = power;
		
		this.defense = target.getCharacter().getType().getBaseDefense();
		this.dodge = target.getCharacter().getType().getBaseDodge();
		
		this.speed = attacker.getCharacter().getType().getBaseSpeed();		
	}

	public int getMaxDamage() {
		return (int) (attacker.getMaxAttack() * (power * 0.01F));
	}
	
	public void attack() {
		
		int value = random.nextInt(100);
		
		if (value <= dodge) {
			target.dodge();
		}
		
		else {
		
			int damage = getMaxDamage();
			damage -= damage * (defense * 0.01F);
				
			target.damage(damage);			
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
