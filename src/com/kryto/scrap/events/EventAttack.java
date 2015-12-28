package com.kryto.scrap.events;

import com.kryto.scrap.character.CharacterStack;

public class EventAttack implements IEvent {

	private CharacterStack character, target;
	
	public EventAttack(CharacterStack character, CharacterStack target) {
		this.character = character;
		this.target = target;
	}
	
	public CharacterStack getTarget() {
		return target;
	}

	public CharacterStack getCharacter() {
		return character;
	}
}
