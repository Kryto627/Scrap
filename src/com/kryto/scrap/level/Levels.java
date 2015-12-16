package com.kryto.scrap.level;

import com.kryto.scrap.character.Character;
import com.kryto.scrap.character.type.TypeFrigid;

public class Levels {

	public static Level firstLevel;
	
	public static void init() {
		firstLevel = new Level();
		firstLevel.setEnemy(0, new Character(new TypeFrigid()));
	}
}
