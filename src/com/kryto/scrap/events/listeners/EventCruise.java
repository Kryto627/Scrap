package com.kryto.scrap.events.listeners;

import com.kryto.scrap.character.type.TypeCruise;
import com.kryto.scrap.effects.EffectRetaliation;
import com.kryto.scrap.events.EventDodged;

public class EventCruise implements IEventListerner {

	public void onDodged(EventDodged event) {
		
		if (event.getTarget().getCharacter().getType() instanceof TypeCruise) {
			event.getTarget().getEffectManager().addEffect(new EffectRetaliation());
		}
	}
}
