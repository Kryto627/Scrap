package com.kryto.scrap.events.listeners;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.character.element.ElementIce;
import com.kryto.scrap.effects.EffectSnowedIn;
import com.kryto.scrap.events.EventAttack;
import com.kryto.scrap.util.MathUtil;

public class EventElementIce implements IEventListener {

	private final int FROST_CHANCE = 15;

	public void onAttack(EventAttack event) {

		if (isIceType(event.getCharacter()) && MathUtil.chance(FROST_CHANCE)) {
			
			event.getTarget().getEffectManager().addEffect(new EffectSnowedIn());
		}
	}

	private boolean isIceType(CharacterStack stack) {
		return stack.getCharacter().getType().getElement() instanceof ElementIce;
	}
}
