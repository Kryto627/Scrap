package com.kryto.scrap.effects;

import java.util.function.Consumer;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.util.WipingArrayList;

public class EffectManager {

	private WipingArrayList<Effect> effects;
	private CharacterStack host;

	public EffectManager(CharacterStack host) {
		effects = new WipingArrayList<Effect>();
		this.host = host;
	}
	
	public void update() {
		effects.forEach(e -> e.update());
		effects.clean();
	}
	
	public void render(Rectangle rect) {

		for (Effect effect : effects) {
			effect.render(rect);
		}
	}
	
	public void call(Consumer<IEffect> c) {
		effects.forEach(c);
	}
	
	public void onAttack(CharacterStack target) {

		for (Effect effect : effects) {
			effect.onAttack(target);
		}
	}
	
	public void onTurn() {

		for (Effect effect : effects) {
			effect.onTurn();
		}
	}

	public void addEffect(Effect effect) {
		if (!hasEffect(effect.getClass())) {
			effect.manager = this;
			effect.init();
			effects.add(effect);
		}
	}

	public boolean hasEffect(Class<?> buffClass) {
		for (Effect effect : effects) {
			if (effect.getClass().equals(buffClass)) {
				return true;
			}
		}

		return false;
	}

	public CharacterStack getHost() {
		return host;
	}
}
