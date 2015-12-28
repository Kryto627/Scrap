package com.kryto.scrap.stats;

import java.io.Serializable;

public class Stats implements Serializable {

	private static final long serialVersionUID = 1L;

	private int health;
	
	private int maxHealth;
	private int maxDamage;
	private int critChance;
	private int dodgeChance;
	private int defense;
	private int speed;

	public Stats(int maxHealth, int maxDamage, int critChance, int dodgeChance, int defense, int speed) {
		this.maxHealth = maxHealth;
		this.maxDamage = maxDamage;
		this.critChance = critChance;
		this.dodgeChance = dodgeChance;
		this.defense = defense;
		this.speed = speed;
		resetHealth();
	}

	public Stats() {
		this(0, 0, 0, 0, 0, 0);
	}
	
	public void add(Stats stats) {
		
		maxHealth += stats.maxHealth;
		maxDamage += stats.maxDamage;
		critChance += stats.critChance;
		dodgeChance += stats.dodgeChance;
		defense += stats.defense;
		speed += stats.speed;
	}

	public boolean isDead() {
		return health <= 0;
	}

	public void heal(int amount) {
		health += amount;
	}

	public void damage(int amount) {
		health -= amount;
	}
	
	public void resetHealth() {
		health = maxHealth;
	}
	
	public Stats clone() {
		Stats stats = new Stats(maxHealth, maxDamage, critChance, dodgeChance, defense, speed);
		stats.setHealth(health);
		return stats;
	}

	// Getters and Setters
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public int getCritChance() {
		return critChance;
	}

	public void setCritChance(int critChance) {
		this.critChance = critChance;
	}

	public int getDodgeChance() {
		return dodgeChance;
	}

	public void setDodgeChance(int dodgeChance) {
		this.dodgeChance = dodgeChance;
	}
	
	public int getDefense() {
		return defense ;
	}
	
	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
