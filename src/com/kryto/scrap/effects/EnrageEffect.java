package com.kryto.scrap.effects;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.util.MathUtil;

public class EnrageEffect extends Effect {

	private int maxDamage;
	
	@Override
	public void onAttack(CharacterStack target) {
	}

	@Override
	public void onTurn() {
	}

	@Override
	public void init() {
		maxDamage = manager.getHost().getStats().getMaxDamage();
		manager.getHost().getStats().setMaxDamage(MathUtil.percent(maxDamage, 150));
	}

	@Override
	public void update() {
	}

	@Override
	public void end() {
	}

	@Override
	public void render(Rectangle rect) {
	}
}
