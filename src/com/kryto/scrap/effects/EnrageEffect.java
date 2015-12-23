package com.kryto.scrap.effects;

import java.util.Random;

import org.newdawn.slick.Color;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.particle.Particle;
import com.kryto.scrap.util.MathUtil;

public class EnrageEffect extends Effect {

	private Random random = new Random();
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
		CharacterStack stack = manager.getHost();
		
		Particle particle = new Particle(0, 0, 8, 8, new Color(255, 128, 0, 90), 1000, true);
		
		particle.x += random.nextInt(128) - 64;
		particle.y += random.nextInt(128) - 64;
		
		particle.gravity = -0.1F;
		particle.maxGravity = 2.0F;
		
		stack.getParticleSystem().addParticle(particle);
	}
}
