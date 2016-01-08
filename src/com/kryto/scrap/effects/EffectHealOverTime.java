package com.kryto.scrap.effects;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;

public class EffectHealOverTime extends Effect {
		
	private int amount, turns;
	
	public EffectHealOverTime(int maxAmount, int maxTurns) {
		turns = maxTurns;
		amount = maxAmount / turns;
	}

	@Override
	public void onAttack(CharacterStack target) {
	}

	@Override
	public void onTurn() {

	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		CharacterStack host = manager.getHost();
		
		host.heal(amount);
		turns--;
		
		if (turns <= 0) {
			wipe();
		}
	}

	@Override
	public void end() {
		
	}
	
	@Override
	public void render(Rectangle rect) {
	}

	/*@Override
	public void render(Rectangle rect) {
		CharacterStack stack = manager.getHost();
		
		Particle particle = new Particle(0, 0, 8, 8, new Color(255, 128, 0, 90), 1000, true);
		
		particle.x += random.nextInt(128) - 64;
		particle.y += random.nextInt(128) - 64;
		
		particle.gravity = -0.1F;
		particle.maxGravity = 2.0F;
		
		stack.getParticleSystem().addParticle(particle);
	}*/
}
