package com.kryto.scrap.effects;

import java.util.function.Consumer;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.util.WipingArrayList;

public class EffectManager {

	private WipingArrayList<Effect> effects, temp;
	private CharacterStack host;

	public EffectManager(CharacterStack host) {
		effects = new WipingArrayList<Effect>();
		this.host = host;
	}

	public void setup() {
		temp = new WipingArrayList<Effect>();
		temp.addAll(effects);
	}
	
	public void update() {
		clean();

		if (temp != null && !temp.isEmpty()) {
			Effect effect = temp.get(0);
			effect.update();
			temp.remove(effect);
		} else {
			temp = null;
		}
	}
	
	public boolean isUpdateDone() {
		return temp == null;
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

	public void clean() {
		effects.clean();
	}

	public CharacterStack getHost() {
		return host;
	}
}
