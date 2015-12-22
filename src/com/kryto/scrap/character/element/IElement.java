package com.kryto.scrap.character.element;

import com.kryto.scrap.gfx.GLSprite;

public interface IElement {
	
	public String getName();
	public GLSprite getEmblem();
	
	public default int getDodgeAdditive() {
		return 0;
	}
}
