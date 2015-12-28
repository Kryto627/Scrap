package com.kryto.scrap.event;

import com.kryto.scrap.character.CharacterStack;

public interface IEventListerner {

	public void onCreated(CharacterStack stack);
	
	public void onAttack(CharacterStack attacker, CharacterStack target);
	
	public void onDodged(CharacterStack attacker, CharacterStack target);
	
	public void onTurn(CharacterStack stack);
	
	public void onPassive(CharacterStack stack);
}
