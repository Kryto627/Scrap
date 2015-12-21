package com.kryto.scrap.level.attack;

import java.util.Random;

import com.kryto.scrap.character.CharacterStack;

public class BufferedAttack {

	private Random random = new Random();
	
	private CharacterStack attacker, target;
	private float power;
	
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
	}
}
