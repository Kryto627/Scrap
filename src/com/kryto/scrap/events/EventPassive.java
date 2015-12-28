package com.kryto.scrap.events;

import com.kryto.scrap.character.CharacterStack;

public class EventPassive implements IEvent {

	private CharacterStack character;
	
	public EventPassive(CharacterStack character) {
		this.character = character;
	}

	public CharacterStack getCharacter() {
		return character;
	}
}
