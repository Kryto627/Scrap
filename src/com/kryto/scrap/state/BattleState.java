package com.kryto.scrap.state;

import com.kryto.scrap.Game;
import com.kryto.scrap.character.Character;
import com.kryto.scrap.character.CharacterSlot;
import com.kryto.scrap.character.type.TypeFrigid;
import com.kryto.scrap.gfx.GLSprite;

public class BattleState implements IGameState {

	private GLSprite panel, background;
	
	private CharacterSlot[] playerMechs, enemyMechs;
	
	@Override
	public void init(GameStateManager gsm) {
		panel = new GLSprite("panel.png");
		background = new GLSprite("battle_bg.png");
		
		playerMechs = new CharacterSlot[2];
		enemyMechs = new CharacterSlot[2];
		
		for (int i = 0 ; i < playerMechs.length; i++) {
			Character character = new Character();
			character.type = new TypeFrigid();
			playerMechs[i] = new CharacterSlot(character);
		}
		
		for (int i = 0 ; i < enemyMechs.length; i++) {
			Character character = new Character();
			character.type = new TypeFrigid();
			enemyMechs[i] = new CharacterSlot(character);
		}
	}

	@Override
	public void update(GameStateManager gsm) {
		
	}

	@Override
	public void render() {
		panel.render(0, 360, Game.getWidth(), 360);
		background.render(0, 0, Game.getWidth(), Game.getHeight() / 2);
		
		for (int i = 0 ; i < playerMechs.length; i++) {
			if (playerMechs[i] != null) {
				playerMechs[i].render(100 + (i * 175), 200, 128, 128, false);
			}
		}
		
		for (int i = 0 ; i < enemyMechs.length; i++) {
			if (enemyMechs[i] != null) {
				enemyMechs[i].render(Game.getWidth() - 100 - ((i + 1) * 150), 200, 128, 128, true);
			}
		}
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void onLeave() {
		
	}
}