package com.kryto.scrap.character;

import java.io.Serializable;

import com.kryto.scrap.gfx.GLAnimation;

public class Character implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	public int ID;
	public int level;
	public int exp;
	
	public transient GLAnimation animation;
	
	public ICharacterType getType() {		
		return CharacterRegistry.characters[ID];		
	}
	
	public boolean hasType() {
		return getType() != null;
	}
	
	public void renderCentered(float x, float y, float width, float height, float scale) {
		
		float scaledWidth = width * scale;
		float scaledHeight = height * scale;
		
		if (hasType() && animation == null) {		
			animation = getType().getAnimationByString();
		}
		
		if (animation != null) animation.render(x - (scaledWidth / 2), y - (scaledHeight / 2), scaledWidth, scaledHeight);
	}
	
	//TODO return character's baseHealth + (level * whatever);
	public int getMaxHealth() {
		return (level + 1) * 10;
	}
	
	//TODO Fix this!
	public int getLevelExpCost() {
		return (level + 1) * 10;
	}
}
