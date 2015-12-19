package com.kryto.scrap.level;

import java.util.Random;

import com.kryto.scrap.Game;
import com.kryto.scrap.battle.BattleSetup;
import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.gfx.GLSprite;
import com.kryto.scrap.gui.Button;
import com.kryto.scrap.util.Timer;

public class Level {

	private GLSprite panel, background;

	private PlayerManager playerManager;
	private EnemyMamager enemyMamager;

	private Button attackBtn;

	private Timer turnTimer;
	private TurnState state;

	public Level() {

		panel = new GLSprite("panel.png");
		background = new GLSprite("battle_bg.png");

		playerManager = new PlayerManager(100, 200);
		enemyMamager = new EnemyMamager(Game.getWidth() - 100, 200);

		attackBtn = new Button(100, 500, "Attack");

		turnTimer = new Timer(1000);
		state = TurnState.PLAYER;
	}

	public void setupBattle(BattleSetup setup) {
		enemyMamager.setup(setup);
	}

	public void setupHand() {
		playerManager.setup();
	}

	public void update() {
		enemyMamager.update();

		if (state == TurnState.PLAYER) {

			if (!playerManager.isAllDone()) {
				
				CharacterStack stack = playerManager.nextActingCharacter();

				if (attackBtn.isClicked()) {

					stack.attack(75, enemyMamager.getTargetCharacter());

					turnTimer.reset();
				}
				
			} else {
				enemyMamager.resetAllCharacters();
				state = TurnState.ENEMY;
			}
		}
		
		if (state == TurnState.ENEMY) {
			
			if (!enemyMamager.isAllDone()) {
				
				if (turnTimer.isDone()) {
					
					CharacterStack stack = enemyMamager.nextActingCharacter();

					Random random = new Random();

					int target = random.nextInt(playerManager.getList().size());
					int power = 75;

					stack.attack(power, playerManager.getCharacterAt(target));
					
					turnTimer.reset();
				}
				
			} else {
				playerManager.resetAllCharacters();
				state = TurnState.PLAYER;
			}
		}
	}

	public void render() {

		panel.render(0, 360, Game.getWidth(), 360);
		background.render(0, 0, Game.getWidth(), Game.getHeight() / 2);

		playerManager.render();
		enemyMamager.render();

		attackBtn.render();
	}
}