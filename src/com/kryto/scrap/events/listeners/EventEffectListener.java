package com.kryto.scrap.events.listeners;

import com.kryto.scrap.events.EventAttack;
import com.kryto.scrap.events.EventPassive;
import com.kryto.scrap.events.EventTurn;

public class EventEffectListener implements IEventListener {

	public void onAttack(EventAttack attack) {
		attack.getCharacter().getEffectManager().call(e -> e.onAttack(attack.getTarget()));
	}
	
	public void onTurn(EventTurn turn) {
		turn.getCharacter().getEffectManager().call(e -> e.onTurn());
	}

	public void onPassive(EventPassive passive) {
		passive.getCharacter().getEffectManager().update();
	}
}
