package com.kryto.scrap.event;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.effects.EnrageEffect;
import com.kryto.scrap.element.ElementFire;
import com.kryto.scrap.stats.Stats;
import com.kryto.scrap.util.MathUtil;

public class EventElementFire implements IEventListerner {

	private final int ENRAGE_PERCENT = 30;

	@Override
	public void onAttack(CharacterStack attacker, CharacterStack target) {

	}

	@Override
	public void onTurn(CharacterStack stack) {

	}

	@Override
	public void onPassive(CharacterStack stack) {

		Stats stats = stack.getStats();
		
		if (isFireType(stack) && stats.getHealth() < MathUtil.percent(stats.getMaxHealth(), ENRAGE_PERCENT)) {

			stack.getBuffManager().addEffect(new EnrageEffect());
		}

	}

	private boolean isFireType(CharacterStack stack) {
		return stack.getCharacter().getType().getElement() instanceof ElementFire;
	}
}
