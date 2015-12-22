package com.kryto.scrap.element;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.gfx.GLSprite;

public interface IElement {
	
	public String getName();
	public GLSprite getEmblem();
	
	public default int getDodgeAdditive() {
		return 0;
	}
	
	public default void updatePassive(CharacterStack stack) {
		
	}
	
	public default void onAttack(CharacterStack attacker, CharacterStack target) {
		
	}
}
