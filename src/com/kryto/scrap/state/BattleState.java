package com.kryto.scrap.state;

import com.kryto.scrap.battle.BattleSetup;
import com.kryto.scrap.level.LevelManager;

public class BattleState implements IGameState {
	
	@Override
	public void init(GameStateManager gsm) {

	}
	
	@Override
	public void update(GameStateManager gsm) {
		LevelManager.getInstance().getLevel().update();
	}

	@Override
	public void render() {
		LevelManager.getInstance().getLevel().render();
	}

	@Override
	public void onEnter() {
	}

	@Override
	public void onLeave() {
	}
	
	public static void enterBattle(BattleSetup setup) {

		GameStateManager.getInstance().switchState(3);

		LevelManager.getInstance().enterBattle(setup);
	}
}