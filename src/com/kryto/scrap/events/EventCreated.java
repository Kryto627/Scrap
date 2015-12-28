package com.kryto.scrap.events;

import com.kryto.scrap.character.CharacterStack;

public class EventCreated implements IEvent {

	private CharacterStack character;
	
	public EventCreated(CharacterStack character) {
		this.character = character;
	}

	public CharacterStack getCharacter() {
		return character;
	}
}
