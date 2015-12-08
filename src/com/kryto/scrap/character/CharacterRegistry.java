package com.kryto.scrap.character;

public class CharacterRegistry {

	public static final ICharacterType[] characters = new ICharacterType[256];

	public static void addCharacter(int ID, ICharacterType character) {

		if (characters[ID] != null) {			
			throw new RuntimeException("ID: " + ID + " is already in use!");
		}
			
		else {
			characters[ID] = character;
		}	
	}
	
	public static void init() {

		addCharacter(1, new TypeCruise());
		addCharacter(2, new TypeBoiler());
		addCharacter(3, new TypeFrigid());	
	}
}
