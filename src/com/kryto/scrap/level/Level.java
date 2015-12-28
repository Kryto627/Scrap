package com.kryto.scrap.level;

import java.util.Random;

import com.kryto.scrap.Game;
import com.kryto.scrap.battle.BattleSetup;
import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.character.manager.EnemyMamager;
import com.kryto.scrap.character.manager.PlayerManager;
import com.kryto.scrap.events.EventCreated;
import com.kryto.scrap.events.EventPassive;
import com.kryto.scrap.events.EventTurn;
import com.kryto.scrap.events.listeners.EventHandler;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gui.GuiAbilities;
import com.kryto.scrap.level.attack.BufferedAttack;
import com.kryto.scrap.level.attack.BufferedAttackManager;
import com.kryto.scrap.level.state.TurnState;

public class Level {

	private PlayerManager playerManager;
	private EnemyMamager enemyManager;
	
	private GuiAbilities gui;
	
	private TurnState state;
	
	private BufferedAttackManager attackManager;

	public Level() {

		playerManager = new PlayerManager(100, 200);
		enemyManager = new EnemyMamager(Game.getWidth() - 100, 200);
		
		gui = new GuiAbilities(this);
		
		state = TurnState.PLAYER;
		
		attackManager = new BufferedAttackManager();
	}

	public void setupBattle(BattleSetup setup) {
		
		enemyManager.setup(setup);
		
		for (CharacterStack stack : enemyManager.getList()) {
			
			EventHandler.getInstance().post(new EventCreated(stack));
		}
	}

	public void setupHand() {
		
		playerManager.setup();
		
		for (CharacterStack stack : playerManager.getList()) {
			
			EventHandler.getInstance().post(new EventCreated(stack));
		}
	}

	public void update() {
				
		enemyManager.update();	
		
		if (state == TurnState.PLAYER) {

			if (!playerManager.isAllDone()) {
				
				updatePlayer();
				
			} else {
				state = TurnState.ENEMY;
			}
		}
		
		if (state == TurnState.ENEMY) {
			
			if (!enemyManager.isAllDone()) {
					
				updateEnemy();
				
			} else {
				state = TurnState.ATTACK;
			}
		}
		
		if (state == TurnState.ATTACK) {
			
			if (!attackManager.isDone()) {
				
				attackManager.update();
				
			} else {
				
				enemyManager.resetAllCharacters();
				playerManager.resetAllCharacters();
				
				state = TurnState.BUFF;
			}
		}
		
		if (state == TurnState.BUFF) {
			
			for (CharacterStack stack : playerManager.getList()) {
				
				stack.getBuffManager().update();
				
				EventHandler.getInstance().post(new EventPassive(stack));
			}
		
			for (CharacterStack stack : enemyManager.getList()) {
				
				stack.getBuffManager().update();
				
				EventHandler.getInstance().post(new EventPassive(stack));
			}
			
			gui.reset();
			
			state = TurnState.PLAYER;
		}
	}
	
	private void updatePlayer() {
				
		playerManager.nextActingCharacter().getBuffManager().onTurn();
		
		EventHandler.getInstance().post(new EventTurn(playerManager.nextActingCharacter()));
		
		gui.update();
	}
	
	private void updateEnemy() {
		
		CharacterStack stack = enemyManager.nextActingCharacter();

		stack.getBuffManager().onTurn();
		
		EventHandler.getInstance().post(new EventTurn(stack));
		
		if (!stack.isDone()) {
			
			Random random = new Random();
			
			int target = random.nextInt(playerManager.getList().size());

			BufferedAttack attack = new BufferedAttack(stack, playerManager.getCharacterAt(target), 75);
			attackManager.addAttack(attack);
				
			stack.setDone(true);
		}
	}

	public void render() {

		Assets.battle_background.render(0, 0, Game.getWidth(), Game.getHeight());
		
		playerManager.render();
		enemyManager.render();

		if (state == TurnState.PLAYER) {
			
			gui.render();
		}
	}
	
	public PlayerManager getPlayerManager() {
		return playerManager;
	}
	
	public EnemyMamager getEnemyManager() {
		return enemyManager;
	}
	
	public BufferedAttackManager getAttackManager() {
		return attackManager;
	}
}