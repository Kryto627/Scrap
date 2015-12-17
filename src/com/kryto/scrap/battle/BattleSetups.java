package com.kryto.scrap.battle;

import com.kryto.scrap.character.type.TypeFrigid;

public class BattleSetups {

	public static BattleSetup firstBattle;
	
	public static void init() {
		firstBattle = new BattleSetup();
		firstBattle.setupChar(0, new TypeFrigid());
	}
}