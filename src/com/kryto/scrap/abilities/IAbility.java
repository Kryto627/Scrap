package com.kryto.scrap.abilities;

public interface IAbility {

	public void onAction();
	
	public String getName();
	
	public AbilityType getType();
}
