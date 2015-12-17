package com.kryto.scrap.level;

import org.lwjgl.input.Keyboard;

import com.kryto.scrap.Game;
import com.kryto.scrap.battle.BattleSetup;
import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.gfx.GLSprite;

public class Level {

	private GLSprite panel, background;
	
	private HandManager handManager;
	private EnemyMamager enemyMamager;
	
	public Level() {
		
		panel = new GLSprite("panel.png");
		background = new GLSprite("battle_bg.png");

		handManager = new HandManager(100, 200);
		enemyMamager = new EnemyMamager(Game.getWidth() - 100, 200);
	}
	
	public void setupBattle(BattleSetup setup) {
		enemyMamager.setup(setup);
	}
	
	public void setupHand() {
		handManager.setup();
	}
	
	public void update() {
		enemyMamager.update();
		handManager.update();
		
		if (!handManager.isAllDone()) {
			
			CharacterStack stack = handManager.getSelectedCharacter();
			
			if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
				
				stack.setDone(true);
				
				stack.setTarget(enemyMamager.getTargetCharacter());
			}
		}
	}

	public void render() {
		
		panel.render(0, 360, Game.getWidth(), 360);
		background.render(0, 0, Game.getWidth(), Game.getHeight() / 2);

		handManager.render();
		enemyMamager.render();
	}
}