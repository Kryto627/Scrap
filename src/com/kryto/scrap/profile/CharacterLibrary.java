package com.kryto.scrap.profile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CharacterLibrary implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public List<Character> characters;	
	
	public CharacterLibrary() {
		characters = new ArrayList<Character>();
	}
}
