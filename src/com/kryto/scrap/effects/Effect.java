package com.kryto.scrap.effects;

import com.kryto.scrap.util.IWipeable;

public abstract class Effect implements IEffect, IWipeable {

	private boolean isDead = false;
	protected EffectManager manager;

	@Override
	public void wipe() {
		end();
		isDead = true;		
	}

	@Override
	public boolean wiped() {
		return isDead;
	}
}
