package com.kryto.scrap.character.manager;

import org.newdawn.slick.Color;

import com.kryto.scrap.character.Character;
import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.RenderUtil;
import com.kryto.scrap.profile.ProfileManager;

public class PlayerManager extends CharacterManager {

	public float x, y;
	public int selectedIndex;
	
	public PlayerManager(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void setup() {

		Character[] charLib = ProfileManager.getInstance().getCurrentProfile().charLib.hand;
		
		for (int i = 0; i < charLib.length; i++) {

			Character character = charLib[i];

			if (character != null) {
				
				list.add(new CharacterStack(character));
			}
		}
	}
		
	public void render() {

		for (int i = 0; i < list.size(); i++) {

			Rectangle rect = getBounds(i);

			list.get(i).render(rect);
			
			if (list.get(i) == nextActingCharacter()) {
				
				RenderUtil.trace(getBounds(i).addSize(20, 20), Color.white);
			}
		}
	}

	public Rectangle getBounds(int index) {
		return new Rectangle(x + (index * 175), y, 128, 128);
	}
	
	public CharacterStack getSelectedCharacter() {
		return getCharacterAt(selectedIndex);
	}
}