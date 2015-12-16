package com.kryto.scrap.state;

import com.kryto.scrap.level.Level;
import com.kryto.scrap.level.Levels;

public class BattleState implements IGameState {
	
	private Level currentLevel;
	
	@Override
	public void init(GameStateManager gsm) {
		Levels.init();
		currentLevel = Levels.firstLevel;
	}

	@Override
	public void update(GameStateManager gsm) {
		currentLevel.update();
	}

	@Override
	public void render() {
		currentLevel.render();
	}

	@Override
	public void onEnter() {
		currentLevel.createFromHand();
	}

	@Override
	public void onLeave() {
		
	}
}