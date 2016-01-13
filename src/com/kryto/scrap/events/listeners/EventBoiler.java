package com.kryto.scrap.events.listeners;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.character.type.TypeBoiler;
import com.kryto.scrap.effects.EffectFiredUp;
import com.kryto.scrap.events.EventCreated;

public class EventBoiler implements IEventListener {

	public void onCreated(EventCreated setup) {
		
		CharacterStack stack = setup.getCharacter();

		if (stack.getCharacter().getType() instanceof TypeBoiler) {

			setup.getCharacter().getEffectManager().addEffect(new EffectFiredUp());

		}
	}
}
