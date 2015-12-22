package com.kryto.scrap.event;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.effects.SnowedInEffect;
import com.kryto.scrap.element.ElementIce;
import com.kryto.scrap.util.MathUtil;

public class EventElementIce implements IEventListerner {

	private final int FROST_CHANCE = 40;

	@Override
	public void onAttack(CharacterStack attacker, CharacterStack target) {

		if (isIceType(attacker) && MathUtil.chance(FROST_CHANCE)) {
			target.getBuffManager().addEffect(new SnowedInEffect());
		}
	}

	@Override
	public void onTurn(CharacterStack stack) {
	}

	@Override
	public void onPassive(CharacterStack stack) {
	}

	private boolean isIceType(CharacterStack stack) {
		return stack.getCharacter().getType().getElement() instanceof ElementIce;
	}
}
