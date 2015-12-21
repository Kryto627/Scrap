package com.kryto.scrap.level;

import java.util.Random;

import com.kryto.scrap.Game;
import com.kryto.scrap.battle.BattleSetup;
import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gui.Button;
import com.kryto.scrap.level.attack.BufferedAttack;
import com.kryto.scrap.level.attack.BufferedAttackManager;

public class Level {

	private PlayerManager playerManager;
	private EnemyMamager enemyMamager;

	private Button attackBtn;

	private TurnState state;
	
	private BufferedAttackManager attackManager;

	public Level() {

		playerManager = new PlayerManager(100, 200);
		enemyMamager = new EnemyMamager(Game.getWidth() - 100, 200);

		attackBtn = new Button(100, 500, "Attack");

		state = TurnState.PLAYER;
		
		attackManager = new BufferedAttackManager();
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
				
				updatePlayer();
				
			} else {
				state = TurnState.ENEMY;
			}
		}
		
		if (state == TurnState.ENEMY) {
			
			if (!enemyMamager.isAllDone()) {
					
				updateEnemy();
				
			} else {
				state = TurnState.ATTACK;
			}
		}
		
		if (state == TurnState.ATTACK) {
			
			if (!attackManager.isDone()) {
				
				attackManager.update();
				
			} else {
				
				enemyMamager.resetAllCharacters();
				playerManager.resetAllCharacters();
				
				state = TurnState.PLAYER;
			}
		}
	}
	
	private void updatePlayer() {
		
		CharacterStack stack = playerManager.nextActingCharacter();
		
		if (attackBtn.isClicked()) {

			BufferedAttack attack = new BufferedAttack(stack, enemyMamager.getTargetCharacter(), 75);
			attackManager.addAttack(attack);
			
			stack.setDone(true);
		}
	}
	
	private void updateEnemy() {
		
		CharacterStack stack = enemyMamager.nextActingCharacter();

		Random random = new Random();
		
		int target = random.nextInt(playerManager.getList().size());

		BufferedAttack attack = new BufferedAttack(stack, playerManager.getCharacterAt(target), 75);
		attackManager.addAttack(attack);
			
		stack.setDone(true);
	}

	public void render() {

		Assets.battle_background.render(0, 0, Game.getWidth(), Game.getHeight());
		
		playerManager.render();
		enemyMamager.render();

		if (state != TurnState.ATTACK) {
			attackBtn.render();
		}		
	}
}