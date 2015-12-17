package com.kryto.scrap.level;

import com.kryto.scrap.Game;
import com.kryto.scrap.battle.BattleSetup;
import com.kryto.scrap.gfx.GLSprite;

public class Level {

	private GLSprite panel, background;
	
	private HandManager handManager;
	private EnemyMamager enemyMamager;
	
	public Level() {
		
		panel = new GLSprite("panel.png");
		background = new GLSprite("battle_bg.png");

		handManager = new HandManager();
		enemyMamager = new EnemyMamager();
	}
	
	public void setupBattle(BattleSetup setup) {
		enemyMamager.setup(setup);
	}
	
	public void setupHand() {
		handManager.setup();
	}
	
	public void update() {
		
		handManager.update();
	}

	public void render() {
		
		panel.render(0, 360, Game.getWidth(), 360);
		background.render(0, 0, Game.getWidth(), Game.getHeight() / 2);

		handManager.render(100, 200);
		enemyMamager.render(Game.getWidth() - 100, 200);
	}
}