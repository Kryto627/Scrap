package com.kryto.scrap.level.attack;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.util.MathUtil;

public class BufferedHeal implements IBufferedAction {

	private boolean isDone = false;
	
	private CharacterStack source, target;
	private int amount;
	
	public BufferedHeal(CharacterStack source, CharacterStack target, int amount) {
		this.source = source;
		this.target = target;
		this.amount = amount;
	}

	@Override
	public void onAction() {
		target.heal(MathUtil.percent(target.getStats().getMaxHealth(), amount));
	}

	@Override
	public int getSpeed() {
		return source.getStats().getSpeed();
	}

	@Override
	public void wipe() {
		isDone = true;
	}

	@Override
	public boolean wiped() {
		return isDone;
	}
}
