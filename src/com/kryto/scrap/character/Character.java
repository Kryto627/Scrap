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
	
	public void render(float x, float y, float width, float height) {
		
		if (hasType() && animation == null) {		
			animation = getType().getAnimationByString();
		}
		
		if (animation != null) animation.render(x, y, width, height);
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
