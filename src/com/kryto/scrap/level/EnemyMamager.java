package com.kryto.scrap.level;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;

import com.kryto.scrap.battle.BattleSetup;
import com.kryto.scrap.character.Character;
import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.RenderUtil;
import com.kryto.scrap.Input;

public class EnemyMamager {

	public static final int AMOUNT = 2;

	public CharacterStack[] hand;
	public float x, y;

	public int target;

	public EnemyMamager(float x, float y) {
		hand = new CharacterStack[AMOUNT];
		this.x = x;
		this.y = y;
	}

	public void setup(BattleSetup setup) {

		for (int i = 0; i < AMOUNT; i++) {

			Character character = setup.getCharacters()[i];

			if (character != null) {
				hand[i] = new CharacterStack(character);
			}
		}
	}

	public void update() {

		for (int i = 0; i < AMOUNT; i++) {

			Rectangle bounds = getBounds(i);

			if (Mouse.isButtonDown(0) && bounds.contains(Input.getMouseX(), Input.getMouseY())) {

				target = i;
			}
		}
	}

	public void render() {

		for (int i = 0; i < AMOUNT; i++) {

			Rectangle rect = getBounds(i);

			if (hand[i] != null) {
				hand[i].renderFlipped(rect);
			}

			if (i == target) {
				RenderUtil.trace(getBounds(i).addSize(20, 20), Color.white);
			}
		}
	}

	public Rectangle getBounds(int index) {
		return new Rectangle(x - (index * 175) - 128, y, 128, 128);
	}

	public CharacterStack getTargetCharacter() {
		return hand[target];
	}

	public boolean isAllDone() {
		boolean done = true;

		for (CharacterStack stack : hand) {
			if (stack != null && !stack.isDone()) {
				done = false;
			}
		}

		return done;
	}

	public CharacterStack nextActingCharacter() {

		for (CharacterStack stack : hand) {

			if (stack != null && !stack.isDone()) {

				return stack;
			}
		}

		return null;
	}
}