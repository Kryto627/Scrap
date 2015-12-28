package com.kryto.scrap.events;

import com.kryto.scrap.character.CharacterStack;

public class EventDodged implements IEvent {

	private CharacterStack character, target;
	
	public EventDodged(CharacterStack character, CharacterStack target) {
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
