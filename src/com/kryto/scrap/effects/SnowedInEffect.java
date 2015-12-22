package com.kryto.scrap.effects;

import org.newdawn.slick.Color;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;

public class SnowedInEffect extends Effect {

	@Override
	public void onAttack(CharacterStack target) {
	}

	@Override
	public void onTurn() {
		manager.getHost().setDone(true);
		wipe();
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
	}

	@Override
	public void end() {
	}

	@Override
	public void render(Rectangle rect) {
		rect.fill(new Color(0, 0, 255, 90));
	}
}
