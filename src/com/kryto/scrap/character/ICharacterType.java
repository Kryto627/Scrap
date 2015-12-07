package com.kryto.scrap.character;

import com.kryto.scrap.gfx.GLAnimation;
import com.kryto.scrap.gfx.GLSprite;

public interface ICharacterType {

	public String getName();

	//TODO Transformations change the number
	public default GLAnimation getAnimationByString() {
		GLSprite sprite = new GLSprite(getName().toLowerCase() + "_1.png");
		GLAnimation animation = new GLAnimation(500, sprite.getSubSprite(0, 0, 32, 32), sprite.getSubSprite(0, 32, 32, 32));
		return animation;
	}
}