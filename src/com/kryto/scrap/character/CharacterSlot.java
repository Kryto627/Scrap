package com.kryto.scrap.character;

import com.kryto.scrap.gfx.GLAnimation;

public class CharacterSlot {

	private Character character;
	private GLAnimation animation;
	
	private int maxHealth;
	private int health;
	
	private int maxAttack;
	private int attack;
	
	public CharacterSlot(Character character) {
		this.character = character;
		initCharData();
	}

	private void initCharData() {
		animation = character.type.getAnimationByString();
		maxHealth = character.getMaxHealth();
		health = maxHealth;
		
		maxAttack = character.getMaxAttack();
		attack = maxAttack;
	}
	
	public void render(float x, float y, float width, float height, boolean flip) {
		if (!flip) {
			animation.render(x, y, width, height);
		} else {
			animation.render(x + width, y, -width, height);
		}
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getMaxAttack() {
		return maxAttack;
	}
	public int getAttack() {
		return attack;
	}
}
