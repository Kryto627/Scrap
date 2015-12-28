package com.kryto.scrap.events.listeners;

import com.kryto.scrap.character.type.TypeFrigid;
import com.kryto.scrap.events.EventPassive;
import com.kryto.scrap.util.MathUtil;

public class EventFridged implements IEventListerner {

	public void onPassive(EventPassive event) {
		
		if (event.getCharacter().getCharacter().getType() instanceof TypeFrigid) {
			
			event.getCharacter().heal(MathUtil.percent(event.getCharacter().getStats().getMaxHealth(), 1));
		}	
	}
}
