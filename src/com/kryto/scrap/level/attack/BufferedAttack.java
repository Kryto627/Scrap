package com.kryto.scrap.level.attack;

import java.util.Random;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.util.IWipeable;

public class BufferedAttack implements IWipeable {

	private Random random = new Random();
	private boolean isDone = false;
	
	private CharacterStack attacker, target;
	private float power;
	
	private int speed = 0;
	
	public BufferedAttack(CharacterStack attacker, CharacterStack target, float power) {
		this.attacker = attacker;
		this.target = target;
		this.power = power;
	}

	public int getMaxDamage() {
		return (int) (attacker.getMaxAttack() + (power * 0.01F));
	}
	
	public void attack() {
		int damage = random.nextInt(getMaxDamage());
		target.damage(damage);
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
