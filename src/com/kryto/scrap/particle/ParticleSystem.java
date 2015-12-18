package com.kryto.scrap.particle;

import java.util.Random;

import org.newdawn.slick.Color;

import com.kryto.scrap.util.WipingArrayList;

public class ParticleSystem {

	private WipingArrayList<Particle> particles, buffer;
	
	public ParticleSystem() {
		particles = new WipingArrayList<Particle>();
		buffer = new WipingArrayList<Particle>();
	}
	
	public void update() {
		for (Particle p : particles) {
			p.update();
		}
		
		particles.clean();
		particles.addAll(buffer);
		buffer.clear();
	}
	
	public void render() {
		for (Particle p : particles) {
			p.render();
		}
	}
	
	public void spawnParticle(float x, float y, float width, float height, Color color, long time, float dx, float dy) {
		Particle p = new Particle(x, y, width, height, color, time, false);
		p.setVelcity(dx, dy);
		addParticle(p);
	}
	
	public void spawnParticleWithGravity(float x, float y, float width, float height, Color color, long time, float dx, float dy) {
		Particle p = new Particle(x, y, width, height, color, time, true);
		p.setVelcity(dx, dy);
		addParticle(p);
	}
	
	public void spawnParticleWithGravity(float x, float y, float size, Color color, long time, float dx, float dy) {
		Particle p = new Particle(x, y, size, size, color, time, true);
		p.setVelcity(dx, dy);
		addParticle(p);
	}
	
	public void spawnParticles(float x, float y, float width, float height, long time, Color color, float spred, int amount) {
		
		Random random = new Random();
		
		for (int i =  0; i < amount; i++) {
			
			float dx = (random.nextFloat() + (spred + spred)) - spred;
			float dy = (random.nextFloat() + (spred + spred)) - spred;
			
			spawnParticle(x, y, width, height, color, time, dx, dy);
		}
	}
	
	public void spawnParticlesWithGravity(float x, float y, float width, float height, long time, Color color, float spred, int amount) {
		
		Random random = new Random();
		
		for (int i =  0; i < amount; i++) {
			
			float max = spred;
			float min = -spred;
			
			float dx = random.nextFloat() * (max - min) + min;
			float dy = random.nextFloat() * (max - min) + min;
			
			spawnParticleWithGravity(x, y, width, height, color, time, dx, dy);
		}
	}
	
	public void addParticle(Particle particle) {
		buffer.add(particle);
	}
}
