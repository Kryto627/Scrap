package com.kryto.scrap.level;

import com.kryto.scrap.battle.BattleSetup;

public class LevelManager {

	private static LevelManager instance = new LevelManager();
	
	public static LevelManager getInstance() {
		return instance;
	}
	
	private Level level;
	
	private LevelManager() {
		level = new Level();
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void enterBattle(BattleSetup setup) {
		level.setupBattle(setup);
		level.setupHand();
	}
}
