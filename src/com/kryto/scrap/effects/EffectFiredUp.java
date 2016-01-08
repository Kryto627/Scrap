package com.kryto.scrap.effects;

import java.util.Random;

import org.newdawn.slick.Color;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.particle.Particle;
import com.kryto.scrap.stats.Stats;

public class EffectFiredUp extends Effect {

	private Stats stats;

	@Override
	public void onAttack(CharacterStack target) {
		wipe();
	}

	@Override
	public void onTurn() {

	}

	@Override
	public void init() {

		stats = new Stats();
		stats.setCritChance(100);
		manager.getHost().addTempStats(stats);
	}

	@Override
	public void update() {

	}

	@Override
	public void end() {
		manager.getHost().getTemporaryStats().remove(stats);
	}

	@Override
	public void render(Rectangle rect) {
		CharacterStack stack = manager.getHost();

		Particle particle = new Particle(0, 0, 8, 8, new Color(0, 0, 0, 90), 1000, true);

		particle.x += new Random().nextInt(128) - 64;
		particle.y += new Random().nextInt(128) - 64;

		particle.gravity = -0.1F;
		particle.maxGravity = 2.0F;

		stack.getParticleSystem().addParticle(particle);
	}
}
