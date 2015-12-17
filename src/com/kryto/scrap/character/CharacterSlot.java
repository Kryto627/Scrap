package com.kryto.scrap.character;

import org.lwjgl.input.Mouse;

import com.kryto.scrap.Input;
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
	private boolean flip;
	
	private boolean isGood;
	private boolean selected;
	
	public CharacterSlot(Rectangle bounds, boolean flip) {
		this.bounds = bounds;
		this.flip = flip;
	}

	public void initCharData(Character character, boolean isGood) {
		this.character = character;
		this.isGood = isGood;
		
		animation = character.type.getAnimationByString();
		maxHealth = character.getMaxHealth();
		health = maxHealth;
		
		maxAttack = character.getMaxAttack();
		attack = maxAttack;
	}
	
	public void update() {
		if (character != null && Mouse.isButtonDown(0)) {
			selected = bounds.contains(Input.getMouseX(), Input.getMouseY());
		}
	}
	
	public void render() {
		if (character != null) {
			animation.render(bounds, flip);
		}
	}
	
	public boolean isGood() {
		return isGood;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public Rectangle getBounds() {
		return bounds;
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
