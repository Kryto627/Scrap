package com.kryto.scrap.level;

import org.newdawn.slick.Color;

import com.kryto.scrap.character.Character;
import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.RenderUtil;
import com.kryto.scrap.profile.ProfileManager;

public class HandManager {

	public static final int AMOUNT = 2;

	public CharacterStack[] hand;
	public float x, y;

	public int selectedIndex;
	
	public HandManager(float x, float y) {
		hand = new CharacterStack[AMOUNT];
		this.x = x;
		this.y = y;
	}

	public void setup() {

		for (int i = 0; i < AMOUNT; i++) {

			Character character = ProfileManager.getInstance().getCurrentProfile().charLib.hand[i];

			if (character != null) {
				hand[i] = new CharacterStack(character);
			}
			
			if (i == selectedIndex) {
				
				RenderUtil.trace(getBounds(i).addSize(20, 20), Color.white);
			}
		}
	}
	
	public void update() {
		
		if (!isAllDone()) {
			
			selectNextActingCharacter();
			
		}
	}
		
	public void render() {

		for (int i = 0; i < AMOUNT; i++) {

			Rectangle rect = getBounds(i);

			if (hand[i] != null) {
				hand[i].render(rect);
			}
		}
	}

	public Rectangle getBounds(int index) {
		return new Rectangle(x + (index * 175), y, 128, 128);
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
	
	public CharacterStack getSelectedCharacter() {
		return hand[selectedIndex];
	}
	
	public void selectNextActingCharacter() {
		
		for (int i = 0; i < AMOUNT; i++) {
			
			if (hand[i] != null && !hand[i].isDone()) {
				
				selectedIndex = i;
			}
		}
	}
}