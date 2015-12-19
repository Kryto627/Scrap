package com.kryto.scrap.character;

import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

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

	private int maxAttack;
	private int attack;

	private boolean isDone;
	
	private ParticleSystem particleSystem = new ParticleSystem();

	public CharacterStack(Character character) {
		initCharData(character);
	}

	public void initCharData(Character character) {
		this.character = character;

		animation = character.type.getAnimationByString();

		maxHealth = character.getMaxHealth();
		health = maxHealth;

		maxAttack = character.getMaxAttack();
		attack = maxAttack;
	}

	public void render(Rectangle rect) {
		animation.render(rect);
		renderStats(rect.getX() + (rect.getWidth() / 2), rect.getY() - 100);
		
		particleSystem.update();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(rect.getX() + (rect.getWidth() / 2), rect.getY() + (rect.getHeight() / 2), 0);
		particleSystem.render();
		GL11.glPopMatrix();
	}

	public void renderFlipped(Rectangle rect) {
		animation.render(rect, true);
		renderStats(rect.getX() + (rect.getWidth() / 2), rect.getY() - 100);
		
		particleSystem.update();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(rect.getX() + (rect.getWidth() / 2), rect.getY() + (rect.getHeight() / 2), 0);
		particleSystem.render();
		GL11.glPopMatrix();
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

	public int getMaxAttack() {
		return maxAttack;
	}

	public int getAttack() {
		return attack;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------

	public void attack(float power, CharacterStack target) {
		target.damage(power, this);
		isDone = true;
	}

	public void damage(float power, CharacterStack attacker) {

		Random random = new Random();

		int maxDamage = (int) (attacker.getMaxAttack() * (power * 0.01F));
		int damage = random.nextInt(maxDamage);

		health -= damage;
		
		TextParticle text = new TextParticle(Integer.toString(damage), 0, 0, Color.red, 3000);
		particleSystem.addParticle(text);
		
		particleSystem.spawnParticlesWithGravity(0, 0, 8, 8, 1000, Color.red, 2, 20);
	}
}
