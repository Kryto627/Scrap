package com.kryto.scrap.level;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import com.kryto.scrap.character.Character;
import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.RenderUtil;
import com.kryto.scrap.profile.ProfileManager;

public class HandManager {

	public static final int AMOUNT = 2;

	public CharacterStack[] hand;
	
	public int selectedIndex;
	public boolean canSkip;

	public HandManager() {
		hand = new CharacterStack[AMOUNT];
	}

	public void setup() {

		for (int i = 0; i < AMOUNT; i++) {

			Character character = ProfileManager.getInstance().getCurrentProfile().charLib.hand[i];

			if (character != null) {
				hand[i] = new CharacterStack(character);
			}
		}
	}
	
	public void update() {
		
		boolean forward = Keyboard.isKeyDown(Keyboard.KEY_RIGHT);
		boolean backward = Keyboard.isKeyDown(Keyboard.KEY_LEFT);
		
		if (canSkip && forward) {
			selectedIndex++;
			canSkip = false;
		}
		
		if (canSkip && backward) {
			selectedIndex--;
			canSkip = false;
		}
		
		if (!forward && !backward) {
			canSkip = true;
		}
		
		if (selectedIndex < 0) {
			selectedIndex = AMOUNT - 1;
		}
		
		selectedIndex %= AMOUNT;
	}
	
	public void render(float x, float y) {
		
		for (int i = 0; i < AMOUNT; i++) {
			
			Rectangle rect = new Rectangle(x + (i * 175), y, 128, 128);
			
			if (hand[i] != null) {
				hand[i].render(rect);
			}
			
			if (selectedIndex == i) {
				
				RenderUtil.trace(rect.addSize(20, 20), Color.white);
			}
		}
	}
	
	public CharacterStack getCurrentChar() {
		return hand[selectedIndex];
	}
}