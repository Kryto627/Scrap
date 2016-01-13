package com.kryto.scrap.character.manager;

import java.util.ArrayList;
import java.util.List;

import com.kryto.scrap.Game;
import com.kryto.scrap.battle.BattleSetup;
import com.kryto.scrap.character.Character;
import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.profile.ProfileManager;

public class StackManager {

	private List<CharacterStack> characters;
	
	public StackManager() {
		characters = new ArrayList<CharacterStack>();
	}
	
	public void setup(BattleSetup setup) {
		
		for (Character c : ProfileManager.getInstance().getCurrentProfile().charLib.hand) {
			
			if (c != null) {
				
				CharacterStack stack = new CharacterStack(c);
				stack.isPlayer = true;
				characters.add(stack);
			}
		}
		
		for (Character c : setup.getCharacters()) {
			
			characters.add(new CharacterStack(c));
		}
	}
	
	public void render() {
		
		int i = 0;
		
		for (CharacterStack stack : getPlayers()) {
			Rectangle rect = new Rectangle(100 + (i * 175), 200, 128, 128);
			stack.render(rect);
			i++;
		}
		
		i= 0;
		
		for (CharacterStack stack : getEnemies()) {
			Rectangle rect = new Rectangle((Game.WIDTH - 100) - (i * 175) - 128, 200, 128, 128);
			stack.render(rect);
			i++;
		}
	}
	
	public List<CharacterStack> getList() {
		return characters;
	}
	
	public List<CharacterStack> getEnemies() {
		
		List<CharacterStack> list = new ArrayList<CharacterStack>();
		
		characters.stream().filter(c -> !c.isPlayer).forEach(c -> list.add(c));
		
		return list;
	}
	
	public List<CharacterStack> getPlayers() {
		
		List<CharacterStack> list = new ArrayList<CharacterStack>();
		
		characters.stream().filter(c -> c.isPlayer).forEach(c -> list.add(c));
		
		return list;
	}
}
