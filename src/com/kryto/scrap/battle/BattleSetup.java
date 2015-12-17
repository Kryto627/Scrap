package com.kryto.scrap.battle;

import com.kryto.scrap.character.Character;
import com.kryto.scrap.character.type.ICharacterType;

public class BattleSetup {

	private Character[] characters;
	
	public BattleSetup() {
		characters = new Character[2];
	}
	
	public void setupChar(int index, ICharacterType type) {
		Character character = new Character(type);
		characters[index] = character;
	}
	
	public Character[] getCharacters() {
		return characters;
	}
}