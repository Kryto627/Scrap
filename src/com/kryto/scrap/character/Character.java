package com.kryto.scrap.character;

public class Character {
		
	public int id;
	public int level;
	public int exp;
	
	//TODO return character's baseHealth + (level * whatever);
	public int getMaxHealth() {
		return (level + 1) * 10;
	}
	
	//TODO Fix this!
	public int getLevelExpCost() {
		return (level + 1) * 10;
	}
}
