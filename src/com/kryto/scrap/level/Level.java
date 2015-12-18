package com.kryto.scrap.level;

import java.util.Random;

import com.kryto.scrap.Game;
import com.kryto.scrap.battle.BattleSetup;
import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.gfx.GLSprite;
import com.kryto.scrap.gui.Button;

public class Level {

	private GLSprite panel, background;
	
	private HandManager handManager;
	private EnemyMamager enemyMamager;
	
	private Button button;
	
	public Level() {
		
		panel = new GLSprite("panel.png");
		background = new GLSprite("battle_bg.png");

		handManager = new HandManager(100, 200);
		enemyMamager = new EnemyMamager(Game.getWidth() - 100, 200);
		
		button = new Button(100, 500, "Attack");
	}
	
	public void setupBattle(BattleSetup setup) {
		enemyMamager.setup(setup);
	}
	
	public void setupHand() {
		handManager.setup();
	}
	
	public void update() {
		enemyMamager.update();
		
		if (!handManager.isAllDone()) {
			
			CharacterStack stack = handManager.nextActingCharacter();
			
			if (button.isClicked()) {
				
				stack.takeTurn(enemyMamager.getTargetCharacter(), 75);
			}
		}
		
		if (!enemyMamager.isAllDone()) {
			
			CharacterStack stack = enemyMamager.nextActingCharacter();
			
			Random random = new Random();
			
			int target = random.nextInt(EnemyMamager.AMOUNT - 1);
			int power = 75;
			
			stack.takeTurn(handManager.getCharacterAt(target), power);
		}
		
		if (enemyMamager.isAllDone() && handManager.isAllDone()) {
			
			for (CharacterStack stack : handManager.hand) {
				if (stack != null) {
					stack.attack();
				}
			}
			
			for (CharacterStack stack : enemyMamager.hand) {
				 if (stack != null) {
					 stack.attack();
				 }
			}
		}
	}

	public void render() {
		
		panel.render(0, 360, Game.getWidth(), 360);
		background.render(0, 0, Game.getWidth(), Game.getHeight() / 2);

		handManager.render();
		enemyMamager.render();
		
		button.render();
	}
}