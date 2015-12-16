package com.kryto.scrap.profile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.kryto.scrap.character.Character;

public class CharacterLibrary implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public List<Character> characters;
	public Character[] hand;
	
	public CharacterLibrary() {
		characters = new ArrayList<Character>();
		hand = new Character[2];
	}
}
