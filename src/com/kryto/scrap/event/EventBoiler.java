package com.kryto.scrap.event;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.character.type.TypeBoiler;
import com.kryto.scrap.effects.EffectFiredUp;

public class EventBoiler implements IEventListerner {

	@Override
	public void onCreated(CharacterStack stack) {
		
		if (stack.getCharacter().getType() instanceof TypeBoiler) {
			
			stack.getBuffManager().addEffect(new EffectFiredUp());			
		}
	}

	@Override
	public void onAttack(CharacterStack attacker, CharacterStack target) {
		
	}

	@Override
	public void onDodged(CharacterStack attacker, CharacterStack target) {
		
	}

	@Override
	public void onTurn(CharacterStack stack) {
		
	}

	@Override
	public void onPassive(CharacterStack stack) {
		
	}
}
