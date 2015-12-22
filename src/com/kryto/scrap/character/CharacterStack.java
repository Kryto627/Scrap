package com.kryto.scrap.character;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

import com.kryto.scrap.effects.EffectManager;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gfx.GLAnimation;
import com.kryto.scrap.gfx.GLFont;
import com.kryto.scrap.particle.ParticleSystem;
import com.kryto.scrap.particle.TextParticle;

public class CharacterStack {

	private Character character;
	private GLAnimation animation;

	private int maxHealth;
	private int health;

	private int maxDamage;

	private boolean isDone;
	
	private ParticleSystem particleSystem = new ParticleSystem();
	
	private EffectManager buffManager;

	public CharacterStack(Character character) {
		initCharData(character);
	}

	public void initCharData(Character character) {
		this.character = character;

		animation = character.type.getAnimationByString();

		maxHealth = character.getMaxHealth();
		health = maxHealth;

		maxDamage = character.getMaxDamage();
		
		buffManager = new EffectManager(this);
	}

	public void render(Rectangle rect) {
		animation.render(rect);
		renderStats(rect.getX() + (rect.getWidth() / 2), rect.getY() - 100);
		
		particleSystem.update();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(rect.getX() + (rect.getWidth() / 2), rect.getY() + (rect.getHeight() / 2), 0);
		particleSystem.render();
		GL11.glPopMatrix();
		
		if (buffManager != null) {
			buffManager.render(rect);
		}
	}

	public void renderFlipped(Rectangle rect) {
		animation.render(rect, true);
		renderStats(rect.getX() + (rect.getWidth() / 2), rect.getY() - 100);
		
		particleSystem.update();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(rect.getX() + (rect.getWidth() / 2), rect.getY() + (rect.getHeight() / 2), 0);
		particleSystem.render();
		GL11.glPopMatrix();
		
		if (buffManager != null) {
			buffManager.render(rect);
		}
	}
	
	public void renderStats(float x, float y) {
		GLFont font = Assets.PIXEL_OPERATOR_SMALL;
		
		font.renderCentered("HP: " + health + "/" + maxHealth, x, y, Color.red);
	}

	public Character getCharacter() {
		return character;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getHealth() {
		return health;
	}

	public int getMaxDamage() {
		return maxDamage;
	}
	
	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	public EffectManager getBuffManager() {
		return buffManager;
	}
	
	public ParticleSystem getParticleSystem() {
		return particleSystem;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------

	public void heal(int amount) {
		health += amount;
		
		TextParticle text = new TextParticle(Integer.toString(amount), 0, 0, Color.green, 3000);
		particleSystem.addParticle(text);
	}
	
	public void damage(int damage) {

		health -= damage;
		
		TextParticle text = new TextParticle(Integer.toString(damage), 0, 0, Color.red, 3000);
		particleSystem.addParticle(text);
		
		particleSystem.spawnParticlesWithGravity(0, 0, 8, 8, 1000, Color.red, 2, 20);
	}
	
	public void damageCritical(int damage) {
		
		damage *= 2;
		
		health -= damage;
		
		TextParticle text = new TextParticle(Integer.toString(damage), 0, 0, Color.pink, 3000);
		particleSystem.addParticle(text);
		
		particleSystem.spawnParticlesWithGravity(0, 0, 8, 8, 1000, Color.red, 2, 20);
	}
	
	public void dodge() {
		TextParticle text = new TextParticle("Dodged", 0, 0, Color.yellow, 3000);
		particleSystem.addParticle(text);
	}
}
