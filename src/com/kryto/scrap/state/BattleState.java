package com.kryto.scrap.state;

import com.kryto.scrap.Game;
import com.kryto.scrap.battle.BattleSetup;
import com.kryto.scrap.character.Character;
import com.kryto.scrap.character.CharacterSlot;
import com.kryto.scrap.gfx.GLSprite;
import com.kryto.scrap.profile.ProfileManager;

public class BattleState implements IGameState {
	
	private static BattleState instance = new BattleState();
	
	public static BattleState getInstance() {
		return instance;
	}
	
	public static final int CHAR_AMOUNT = 2;

	private GLSprite panel, background;
	private CharacterSlot[] playerMechs, enemyMechs;
	
	private BattleState() {
		panel = new GLSprite("panel.png");
		background = new GLSprite("battle_bg.png");

		playerMechs = new CharacterSlot[CHAR_AMOUNT];
		enemyMechs = new CharacterSlot[CHAR_AMOUNT];
	}
	
	public static void enterBattle(BattleSetup setup) {
		
		GameStateManager.getInstance().switchState(3);
		
		for (int i = 0; i < CHAR_AMOUNT; i++) {
			getInstance().enemyMechs[i] = null;
			
			Character character = setup.getCharacters()[i];
			
			if (character != null) {
				getInstance().enemyMechs[i] = new CharacterSlot(character);
			}
		}
	}
	
	private Character[] getCurrentHand() {
		return ProfileManager.getInstance().getCurrentProfile().charLib.hand;
	}
	
	public void createFromHand() {
		
		for (int i = 0; i < CHAR_AMOUNT; i++) {

			playerMechs[i] = null;

			Character character = getCurrentHand()[i];

			if (character != null) {
				playerMechs[i] = new CharacterSlot(character);
			}
		}
	}

	@Override
	public void update(GameStateManager gsm) {
		
	}

	@Override
	public void render() {
		
		panel.render(0, 360, Game.getWidth(), 360);
		background.render(0, 0, Game.getWidth(), Game.getHeight() / 2);

		for (int i = 0; i < CHAR_AMOUNT; i++) {
			if (playerMechs[i] != null) {
				playerMechs[i].render(100 + (i * 175), 200, 128, 128, false);
			}

			if (enemyMechs[i] != null) {
				enemyMechs[i].render(Game.getWidth() - 100 - ((i + 1) * 150), 200, 128, 128, true);
			}
		}
	}
	
	@Override
	public void onEnter() {
		createFromHand();
	}

	@Override
	public void init(GameStateManager gsm) {
	}
	
	@Override
	public void onLeave() {
	}
}