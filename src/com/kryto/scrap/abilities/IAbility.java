package com.kryto.scrap.abilities;

import com.kryto.scrap.level.Level;

public interface IAbility {

	public void onAction(Level level);
	
	public String getName();
	
	public AbilityType getType();
}
