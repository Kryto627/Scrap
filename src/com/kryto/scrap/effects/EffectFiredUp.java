package com.kryto.scrap.effects;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;

public class EffectFiredUp extends Effect {

	private int critChance;
	
	@Override
	public void onAttack(CharacterStack target) {
		wipe();
	}

	@Override
	public void onTurn() {
		
	}

	@Override
	public void init() {
		
		critChance = manager.getHost().getStats().getCritChance();
		manager.getHost().getStats().setCritChance(100);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void end() {
		manager.getHost().getStats().setCritChance(critChance);
	}

	@Override
	public void render(Rectangle rect) {
		
	}
}
