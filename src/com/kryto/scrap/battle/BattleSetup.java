package com.kryto.scrap.battle;

import java.util.ArrayList;
import java.util.List;

import com.kryto.scrap.character.Character;
import com.kryto.scrap.character.type.ICharacterType;

public class BattleSetup {

	private List<Character> characters;
	
	public BattleSetup() {
		characters = new ArrayList<Character>();
	}
	
	public void addChar(ICharacterType type) {
		Character character = new Character(type);
		characters.add(character);
	}
	
	public List<Character> getCharacters() {
		return characters;
	}
}