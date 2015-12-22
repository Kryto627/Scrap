package com.kryto.scrap.battle;

import com.kryto.scrap.character.type.TypeCruise;

public class BattleSetups {

	public static BattleSetup firstBattle;
	
	public static void init() {
		firstBattle = new BattleSetup();
		firstBattle.addChar(new TypeCruise());
	}
}