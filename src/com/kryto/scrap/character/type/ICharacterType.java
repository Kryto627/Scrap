package com.kryto.scrap.character.type;

import com.kryto.scrap.element.IElement;
import com.kryto.scrap.gfx.GLAnimation;
import com.kryto.scrap.gfx.GLSprite;

public interface ICharacterType {
	
	public String getName();
	public IElement getElement();
	
	public int getHealthMultiplier();
	public int getAttackMultiplier();
	
	public int getBaseDefence();
	public int getBaseDodge();
	
	public int getBaseSpeed();
	
	public default String getIntroQuote() {
		return "...";
	}
	
	//TODO Transformations change the number
	public default GLAnimation getAnimationByString() {
		GLSprite sprite = new GLSprite(getName().toLowerCase() + "_1.png");
		GLAnimation animation = new GLAnimation(500, sprite.getSubSprite(0, 0, 32, 32), sprite.getSubSprite(0, 32, 32, 32));
		return animation;
	}
}