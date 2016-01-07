package com.kryto.scrap.events.listeners;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.character.element.ElementFire;
import com.kryto.scrap.effects.EffectEnrage;
import com.kryto.scrap.events.EventPassive;
import com.kryto.scrap.stats.Stats;
import com.kryto.scrap.util.MathUtil;

public class EventElementFire implements IEventListerner {

	private final int ENRAGE_PERCENT = 30;

	public void onPassive(EventPassive event) {

		Stats stats = event.getCharacter().getStats();
		
		if (isFireType(event.getCharacter()) && stats.getHealth() < MathUtil.percent(stats.getMaxHealth(), ENRAGE_PERCENT)) {

			event.getCharacter().getEffectManager().addEffect(new EffectEnrage());
		}

	}

	private boolean isFireType(CharacterStack stack) {
		return stack.getCharacter().getType().getElement() instanceof ElementFire;
	}
}
