package com.kryto.scrap.event;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.character.type.TypeCruise;
import com.kryto.scrap.effects.EffectRetaliation;

public class EventRetaliation implements IEventListerner {

	@Override
	public void onAttack(CharacterStack attacker, CharacterStack target) {
		
	}

	@Override
	public void onDodged(CharacterStack attacker, CharacterStack target) {
		
		if (target.getCharacter().getType() instanceof TypeCruise) {
			target.getBuffManager().addEffect(new EffectRetaliation());
		}
	}

	@Override
	public void onTurn(CharacterStack stack) {
		
	}

	@Override
	public void onPassive(CharacterStack stack) {
		
	}
}
