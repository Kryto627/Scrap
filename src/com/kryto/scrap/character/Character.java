package com.kryto.scrap.character;

import java.io.Serializable;

import com.kryto.scrap.gfx.GLAnimation;

public class Character implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	public int ID;
	public int exp;
	public int levelCost;
	public int level;		
	
	public transient GLAnimation animation;
	
	public ICharacterType getType() {		
		return CharacterRegistry.characters[ID];		
	}
	
	public int getEXPCost() {
		return (level + 1) * 5;
	}
	
	public int getMaxHealth() {
		return (level + 1) * getType().getHealthMultiplier();
	}
	
	public int getMaxAttack() {
		return (level + 1) * getType().getAttackMultiplier();
	}
	
	public void renderCentered(float x, float y, float width, float height, float scale) {
		
		float scaledWidth = width * scale;
		float scaledHeight = height * scale;
		
		if (getType() != null && animation == null) {		
			animation = getType().getAnimationByString();
		}
		
		if (animation != null) animation.render(x - (scaledWidth / 2), y - (scaledHeight / 2), scaledWidth, scaledHeight);
	}
}
