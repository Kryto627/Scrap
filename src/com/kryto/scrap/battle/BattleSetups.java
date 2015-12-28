package com.kryto.scrap.battle;

import com.kryto.scrap.character.type.TypeCruise;
import com.kryto.scrap.character.type.TypeFrigid;

public class BattleSetups {

	public static BattleSetup firstBattle;
	
	public static void init() {
		firstBattle = new BattleSetup();
		firstBattle.addChar(new TypeCruise());
	}
}