package com.kryto.scrap.gui;

import com.kryto.scrap.level.Level;

public class GuiAbilities {

	private Level level;
	
	private GuiState currentState;
	
	private ButtonBack backBtn;
	
	private AbilityTypeButton attackBtn, defenseBtn, specialBtn;
	
	private AbilityButton[] abilityBtns = new AbilityButton[6];
	
	public GuiAbilities(Level level) {
		
		this.level = level;
		
		currentState = GuiState.MAIN;
		
		backBtn = new ButtonBack(264 * 4, 156 * 4);
		
		attackBtn = new AbilityTypeButton(1);
		defenseBtn = new AbilityTypeButton(2);
		specialBtn = new AbilityTypeButton(3);	
	}
	
	public void update() {
		
		if (currentState == GuiState.MAIN) {
			
			if (attackBtn.isClicked()) {
				currentState = GuiState.ATTACK;
				
				abilityBtns[0] = new AbilityButton(level, 0);
			}
			
			if (defenseBtn.isClicked()) {
				currentState = GuiState.DEFENSE;
			}
			
			if (specialBtn.isClicked()) {
				currentState = GuiState.SPECIAL;
			}
		}		
		
		else {
			
			if (backBtn.isClicked()) {
				reset();
			}
			
			for (int i = 0; i < abilityBtns.length; i++) {	
				
				if (abilityBtns[i] != null) {
					
					abilityBtns[i].update();						
				}
			}
		}
	}
	
	public void render() {
		
		if (currentState == GuiState.MAIN) {
			attackBtn.render();
			defenseBtn.render();
			specialBtn.render();
		}
		
		else {
			
			backBtn.render();
			
			for (int i = 0; i < abilityBtns.length; i++) {						
				if (abilityBtns[i] != null) abilityBtns[i].render();
			}
		}
	}
	
	public void reset() {
		currentState = GuiState.MAIN;
		
		for (int i = 0; i < abilityBtns.length; i++) {						
			abilityBtns[i] = null;
		}
	}
	
	public enum GuiState {
		
		MAIN, ATTACK, DEFENSE, SPECIAL;
	}
}
