package com.kryto.scrap.character;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

import com.kryto.scrap.abilities.AbilityBank;
import com.kryto.scrap.effects.EffectManager;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gfx.GLAnimation;
import com.kryto.scrap.gfx.GLFont;
import com.kryto.scrap.particle.ParticleSystem;
import com.kryto.scrap.particle.TextParticle;
import com.kryto.scrap.stats.Stats;
import com.kryto.scrap.util.MathUtil;

public class CharacterStack {

	private Character character;
	private GLAnimation animation;
	private ParticleSystem particleSystem;

	private List<Stats> temporaryStats;
	private Stats stats;

	private boolean isDone;
	
	private EffectManager effectManager;
	private AbilityBank abilities;

	public CharacterStack(Character character) {
		initCharData(character);
	}

	public void initCharData(Character character) {
		this.character = character;

		animation = character.type.getAnimationByString();
		particleSystem = new ParticleSystem();

		temporaryStats = new ArrayList<Stats>();
		stats = character.getStats().clone();
		
		effectManager = new EffectManager(this);
		abilities = character.getAbilities();
	}

	public void render(Rectangle rect) {
		animation.render(rect);
		renderStats(rect.getX() + (rect.getWidth() / 2), rect.getY() - 100);
		
		particleSystem.update();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(rect.getX() + (rect.getWidth() / 2), rect.getY() + (rect.getHeight() / 2), 0);
		particleSystem.render();
		GL11.glPopMatrix();
		
		if (effectManager != null) {
			effectManager.render(rect);
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
		
		if (effectManager != null) {
			effectManager.render(rect);
		}
	}
	
	public void renderStats(float x, float y) {
		GLFont font = Assets.PIXEL_OPERATOR_SMALL;
		
		font.renderCentered("HP: " + stats.getHealth() + "/" + stats.getMaxHealth(), x, y, Color.red);
	}

	public Character getCharacter() {
		return character;
	}
	
	public List<Stats> getTemporaryStats() {
		return temporaryStats;
	}
	
	public Stats getStats() {
		return stats.getTotalStats(temporaryStats);
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	public EffectManager getEffectManager() {
		return effectManager;
	}
	
	public ParticleSystem getParticleSystem() {
		return particleSystem;
	}
	
	public AbilityBank getAbilities() {
		return abilities;
	}
	
	public void addTempStats(Stats stats) {
		temporaryStats.add(stats);
	}
	
	//-------------------------------------------------------------------------------------------------------------------------

	public void heal(int amount) {
		
		stats.heal(amount);
		
		TextParticle text = new TextParticle(Integer.toString(amount), 0, 0, Color.green, 3000);
		particleSystem.addParticle(text);
		
		stats.setHealth(MathUtil.clamp(stats.getHealth(), 0, stats.getMaxHealth()));
	}
	
	public void damage(int amount) {

		stats.damage(amount);
		
		TextParticle text = new TextParticle(Integer.toString(amount), 0, 0, Color.red, 3000);
		particleSystem.addParticle(text);
		
		particleSystem.spawnParticlesWithGravity(0, 0, 8, 8, Color.red, 1000, 1, 20);
	}
	
	public void damageCritical(int amount) {
		
		amount *= 2;
		
		stats.damage(amount);
		
		TextParticle text = new TextParticle(Integer.toString(amount), 0, 0, Color.pink, 3000);
		particleSystem.addParticle(text);
		
		particleSystem.spawnParticlesWithGravity(0, 0, 8, 8, Color.red, 1000, 2, 20);
	}
	
	public void dodge() {
		TextParticle text = new TextParticle("Dodged", 0, 0, Color.yellow, 3000);
		particleSystem.addParticle(text);
	}
}
