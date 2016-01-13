package com.kryto.scrap.level;

import java.util.ArrayList;
import java.util.List;
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
import com.kryto.scrap.util.Timer;

public class Level {

	public enum RoundState {
		SETUP, IN_ROUND;
	}

	private List<CharacterStack> roundCharacters = new ArrayList<CharacterStack>();
	private RoundState roundState = RoundState.SETUP;
	private Timer roundTimer = new Timer(500);
	private PlayerManager playerManager;
	private EnemyMamager enemyManager;
	private GuiAbilities gui;
	private CharacterStack fastest;

	public Level() {
		playerManager = new PlayerManager(100, 200);
		enemyManager = new EnemyMamager(Game.getWidth() - 100, 200);
		gui = new GuiAbilities();
	}

	public void setupBattle(BattleSetup setup) {
		enemyManager.setup(setup);
		enemyManager.getList().forEach(c -> EventHandler.getInstance().post(new EventCreated(c)));
	}

	public void setupHand() {
		playerManager.setup();
		playerManager.getList().forEach(c -> EventHandler.getInstance().post(new EventCreated(c)));
	}

	public void update() {

		enemyManager.update();

		if (roundState == RoundState.SETUP) {
			roundCharacters.clear();
			roundCharacters.addAll(enemyManager.getList());
			roundCharacters.addAll(playerManager.getList());
			roundCharacters.forEach(c -> c.setDone(false));
			roundState = RoundState.IN_ROUND;
		}

		if (roundState == RoundState.IN_ROUND && roundTimer.isDone()) {

			CharacterStack fastest = getFastestCharacter();

			if (this.fastest != fastest) {
				EventHandler.getInstance().post(new EventPassive(fastest));
				this.fastest = fastest;
			}

			EventHandler.getInstance().post(new EventTurn(fastest));

			if (!fastest.isPlayer) {
				//Fix
				fastest.getAbilities().getAbilities().get(0).onAction();
				fastest.setDone(true);
			}

			if (fastest.isPlayer) {
				gui.update(fastest);
			}

			if (fastest.isDone()) {
				roundCharacters.remove(fastest);
				roundTimer.reset();
			}

			if (roundCharacters.isEmpty()) {
				roundState = RoundState.SETUP;
			}
		}
	}

	public void render() {

		Assets.battle_background.render(0, 0, Game.getWidth(), Game.getHeight());

		playerManager.render();
		enemyManager.render();

		if (getFastest() != null && getFastest().isPlayer && !getFastest().isDone()) {
			gui.render();
		}
	}

	private CharacterStack getFastestCharacter() {
		CharacterStack stack = null;

		for (CharacterStack c : roundCharacters) {
			if (stack == null || stack.getStats().getSpeed() <= c.getStats().getSpeed()) {
				stack = c;
			}
		}

		return stack;
	}

	public CharacterStack getRandomPlayer() {
		Random random = new Random();
		return playerManager.getCharacterAt(random.nextInt(playerManager.getList().size()));
	}

	public CharacterStack getFastest() {
		return fastest;
	}

	public PlayerManager getPlayerManager() {
		return playerManager;
	}

	public EnemyMamager getEnemyManager() {
		return enemyManager;
	}
}