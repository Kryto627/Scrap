package com.kryto.scrap.events;

import com.kryto.scrap.character.CharacterStack;

public class EventTurn implements IEvent {

	private CharacterStack character;
	
	public EventTurn(CharacterStack character) {
		this.character = character;
	}

	public CharacterStack getCharacter() {
		return character;
	}
}
