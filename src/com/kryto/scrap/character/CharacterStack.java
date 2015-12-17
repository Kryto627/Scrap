package com.kryto.scrap.character;

import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.GLAnimation;

public class CharacterStack {

	private Character character;
	private GLAnimation animation;
	
	private int maxHealth;
	private int health;
	
	private int maxAttack;
	private int attack;
	
	public CharacterStack(Character character) {
		initCharData(character);
	}

	public void initCharData(Character character) {
		this.character = character;
		
		animation = character.type.getAnimationByString();
		
		maxHealth = character.getMaxHealth();
		health = maxHealth;
		
		maxAttack = character.getMaxAttack();
		attack = maxAttack;
	}
	
	public void render(Rectangle rect) {
		animation.render(rect);
	}
	
	public void renderFlipped(Rectangle rect) {
		animation.render(rect, true);
	}
	
	public Character getCharacter() {
		return character;
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
