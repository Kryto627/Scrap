package com.kryto.scrap.character;

import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.GLAnimation;

public class CharacterSlot {

	private Character character;
	private GLAnimation animation;
	
	private int maxHealth;
	private int health;
	
	private int maxAttack;
	private int attack;
	
	private Rectangle bounds;
	
	public CharacterSlot(Character character, Rectangle bounds) {
		this.character = character;
		this.bounds = bounds;
		initCharData();
	}

	private void initCharData() {
		animation = character.type.getAnimationByString();
		maxHealth = character.getMaxHealth();
		health = maxHealth;
		
		maxAttack = character.getMaxAttack();
		attack = maxAttack;
	}
	
	public void render() {
		animation.render(bounds);
	}
	
	public Rectangle getBounds() {
		return bounds;
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
