package com.kryto.scrap.state;

import com.kryto.scrap.battle.BattleSetup;
import com.kryto.scrap.level.Level;

public class BattleState implements IGameState {

	private Level level = new Level();
	
	@Override
	public void init(GameStateManager gsm) {
	}
	
	@Override
	public void update(GameStateManager gsm) {
		level.update();
	}

	@Override
	public void render() {
		level.render();
	}

	@Override
	public void onEnter() {
		level.setupHand();
	}

	@Override
	public void onLeave() {
	}
	
	public void enterBattle(BattleSetup setup) {

		GameStateManager.getInstance().switchState(3);

		level.setupBattle(setup);
	}
}