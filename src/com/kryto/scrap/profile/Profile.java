package com.kryto.scrap.profile;

import java.io.Serializable;

public class Profile implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public boolean markForDelete;
	
	public CharacterLibrary charLib;
	
	public Profile() {
		markForDelete = false;
		charLib = new CharacterLibrary();
	}
}
