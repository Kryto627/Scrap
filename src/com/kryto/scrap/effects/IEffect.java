package com.kryto.scrap.effects;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;

public interface IEffect {

	public void onAttack(CharacterStack target);
	
	public void onTurn();
	
	public void init();
	
	public void update();
	
	public void end();
	
	public void render(Rectangle rect);
}
