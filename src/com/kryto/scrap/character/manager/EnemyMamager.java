package com.kryto.scrap.character.manager;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import com.kryto.scrap.battle.BattleSetup;
import com.kryto.scrap.character.Character;
import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.RenderUtil;

public class EnemyMamager extends CharacterManager {

	public boolean canClick = true;
	
	public float x, y;
	public int target;

	public EnemyMamager(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void setup(BattleSetup setup) {

		for (int i = 0; i < setup.getCharacters().size(); i++) {

			Character character = setup.getCharacters().get(i);
			
			list.add(new CharacterStack(character));
		}
	}

	public void update() {

		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && canClick) {
			target++;
			target %= list.size();
			canClick = false;
		}
		
		if (!Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			canClick = true;
		}
	}

	public void render() {

		for (int i = 0; i < list.size(); i++) {

			Rectangle rect = getBounds(i);

			list.get(i).render(rect);

			if (i == target) {
				RenderUtil.trace(getBounds(i).addSize(20, 20), Color.white);
			}
		}
	}

	public Rectangle getBounds(int index) {
		return new Rectangle(x - (index * 175) - 128, y, 128, 128);
	}

	public CharacterStack getTargetCharacter() {
		return getCharacterAt(target);
	}
}