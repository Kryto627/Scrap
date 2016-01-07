package com.kryto.scrap.character.type;

import com.kryto.scrap.abilities.AbilityAttack;
import com.kryto.scrap.abilities.AbilityBank;
import com.kryto.scrap.character.element.IElement;
import com.kryto.scrap.gfx.GLAnimation;
import com.kryto.scrap.gfx.GLSprite;
import com.kryto.scrap.stats.Stats;

public interface ICharacterType {
	
	public String getName();
	
	public IElement getElement();
	
	public Stats getDefaultStats();
	
	public int getHealthMultiplier();
	
	public int getAttackMultiplier();
	
	public default String getIntroQuote() {
		return "...";
	}
	
	//TODO Transformations change the number
	public default GLAnimation getAnimationByString() {
		GLSprite sprite = new GLSprite(getName().toLowerCase() + "_1.png");
		GLAnimation animation = new GLAnimation(500, sprite.getSubSprite(0, 0, 32, 32), sprite.getSubSprite(0, 32, 32, 32));
		return animation;
	}
	
	public default void addAbilities(AbilityBank bank) {
		bank.add(new AbilityAttack(50, "Punch"));
		getElement().addAbilities(bank);
	}
}