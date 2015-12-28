package com.kryto.scrap.events.listeners;

import com.kryto.scrap.character.type.TypeBoiler;
import com.kryto.scrap.effects.EffectFiredUp;
import com.kryto.scrap.events.EventCreated;

public class EventBoiler implements IEventListerner {

	public void onCreated(EventCreated setup) {

		if (setup.getCharacter().getCharacter().getType() instanceof TypeBoiler) {

			setup.getCharacter().getBuffManager().addEffect(new EffectFiredUp());
		}
	}
}
