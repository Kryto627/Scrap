package com.kryto.scrap.level;

import com.kryto.scrap.battle.BattleSetup;
import com.kryto.scrap.character.Character;
import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;

public class EnemyMamager {

	public static final int AMOUNT = 2;

	public CharacterStack[] hand;

	public EnemyMamager() {
		hand = new CharacterStack[AMOUNT];
	}

	public void setup(BattleSetup setup) {

		for (int i = 0; i < AMOUNT; i++) {

			Character character = setup.getCharacters()[i];

			if (character != null) {
				hand[i] = new CharacterStack(character);
			}
		}
	}
	
	public void render(float x, float y) {
		
		for (int i = 0; i < AMOUNT; i++) {
			
			Rectangle rect = new Rectangle(x - (i * 175) - 128, y, 128, 128);
			
			if (hand[i] != null) {
				hand[i].renderFlipped(rect);
			}
		}
	}
}