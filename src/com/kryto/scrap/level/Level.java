package com.kryto.scrap.level;

import com.kryto.scrap.Game;
import com.kryto.scrap.character.Character;
import com.kryto.scrap.character.CharacterSlot;
import com.kryto.scrap.gfx.GLSprite;
import com.kryto.scrap.profile.ProfileManager;

public class Level {

	private static final int CHAR_AMOUNT = 2;

	private GLSprite panel, background;
	private CharacterSlot[] playerMechs, enemyMechs;

	public Level() {

		panel = new GLSprite("panel.png");
		background = new GLSprite("battle_bg.png");

		playerMechs = new CharacterSlot[CHAR_AMOUNT];
		enemyMechs = new CharacterSlot[CHAR_AMOUNT];
	}
	
	public void createFromHand() {
		for (int i = 0; i < CHAR_AMOUNT; i++) {

			playerMechs[i] = null;

			Character character = ProfileManager.getInstance().getCurrentProfile().charLib.hand[i];

			if (character != null) {
				playerMechs[i] = new CharacterSlot(character);
			}
		}
	}
	
	public void setEnemy(int index, Character character) {
		enemyMechs[index] = new CharacterSlot(character);
	}

	public void update() {
	}

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
}
