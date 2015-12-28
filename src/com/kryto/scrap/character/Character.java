package com.kryto.scrap.character;

import java.io.Serializable;

import com.kryto.scrap.character.type.ICharacterType;
import com.kryto.scrap.gfx.GLAnimation;
import com.kryto.scrap.stats.Stats;

public class Character implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	public transient GLAnimation animation;
	
	public ICharacterType type;
	public int exp, level;
	
	public Character(ICharacterType type) {
		this.type = type;
	}
	
	public Character() {
		type = null;
	}
		
	public void renderCentered(float x, float y, float width, float height, float scale) {
		
		float scaledWidth = width * scale;
		float scaledHeight = height * scale;
		
		if (type != null && animation == null) {		
			animation = type.getAnimationByString();
		}
		
		if (animation != null) {
			animation.render(x - (scaledWidth / 2), y - (scaledHeight / 2), scaledWidth, scaledHeight);
		}
	}
	
	public ICharacterType getType() {		
		return type;		
	}
	
	public Stats getStats() {
		Stats stats = getType().getDefaultStats();
		
		stats.setMaxHealth((level + 1) * getType().getHealthMultiplier());
		stats.setMaxDamage((level + 1) * getType().getAttackMultiplier());
		
		stats.add(getType().getElement().getAdditiveStats());
		
		stats.resetHealth();	
		
		return stats;
	}
}
