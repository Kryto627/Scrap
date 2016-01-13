package com.kryto.scrap.gui;

import com.kryto.scrap.abilities.AbilityType;
import com.kryto.scrap.abilities.IAbility;
import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;

public class GuiAbilities {

	private GuiState currentState;

	private ButtonBack backBtn;

	private AbilityTypeButton attackBtn, defenseBtn, specialBtn;

	private AbilityButton[] abilityBtns = new AbilityButton[6];

	private Tooltip attackTooltip, defenseTooltip, specialTooltip;

	public GuiAbilities() {

		currentState = GuiState.MAIN;

		backBtn = new ButtonBack(264 * 4, 156 * 4);

		attackBtn = new AbilityTypeButton(1);
		defenseBtn = new AbilityTypeButton(2);
		specialBtn = new AbilityTypeButton(3);

		attackTooltip = new Tooltip(new Rectangle(attackBtn.bounds), "Attack");
		defenseTooltip = new Tooltip(new Rectangle(defenseBtn.bounds), "Defense");
		specialTooltip = new Tooltip(new Rectangle(specialBtn.bounds), "Special");
	}

	public void update(CharacterStack player) {

		if (currentState == GuiState.MAIN) {

			if (attackBtn.isClicked()) {
				currentState = GuiState.ATTACK;

				int i = 0;

				for (IAbility ability : player.getAbilities().getAbilitiesByType(AbilityType.ATTACK)) {
					abilityBtns[i] = new AbilityButton(i, ability);
					i++;
				}
			}

			if (defenseBtn.isClicked()) {
				currentState = GuiState.DEFENSE;

				int i = 0;

				for (IAbility ability : player.getAbilities().getAbilitiesByType(AbilityType.DEFENSE)) {
					abilityBtns[i] = new AbilityButton(i, ability);
					i++;
				}
			}

			if (specialBtn.isClicked()) {
				currentState = GuiState.SPECIAL;

				int i = 0;

				for (IAbility ability : player.getAbilities().getAbilitiesByType(AbilityType.SPECIAL)) {
					abilityBtns[i] = new AbilityButton(i, ability);
					i++;
				}
			}
		}

		else {

			if (backBtn.isClicked()) {
				reset();
			}

			for (int i = 0; i < abilityBtns.length; i++) {

				if (abilityBtns[i] != null) {

					abilityBtns[i].update(player);
					
					if (abilityBtns[i].active) {
						reset();
					}
				}
			}
		}
	}

	public void render() {

		if (currentState == GuiState.MAIN) {
			attackBtn.render();
			defenseBtn.render();
			specialBtn.render();

			attackTooltip.render();
			defenseTooltip.render();
			specialTooltip.render();
		}

		else {

			backBtn.render();

			for (int i = 0; i < abilityBtns.length; i++) {
				if (abilityBtns[i] != null)
					abilityBtns[i].render();
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
