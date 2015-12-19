package com.kryto.scrap.level;

import java.util.ArrayList;
import java.util.List;

import com.kryto.scrap.character.CharacterStack;

public abstract class CharacterManager {

	protected List<CharacterStack> list;
	
	public CharacterManager() {
		list = new ArrayList<CharacterStack>();
	}
	
	public List<CharacterStack> getList() {
		return list;
	}
	
	public CharacterStack getCharacterAt(int index) {
		return list.get(index);
	}
	
	public CharacterStack nextActingCharacter() {
		
		for (CharacterStack stack : list) {
			
			if (!stack.isDone()) {
				
				return stack;
			}
		}
		
		return null;
	}
	
	public boolean isAllDone() {
		
		boolean done = true;

		for (CharacterStack stack : list) {
			
			if (!stack.isDone()) {
				
				done = false;
			}
		}

		return done;
	}
	
	public void resetAllCharacters() {
		
		for (CharacterStack stack : list) {
			
			stack.setDone(false);
		}
	}
}
