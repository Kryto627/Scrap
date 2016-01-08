package com.kryto.scrap.abilities;

public abstract class AbilityBase implements IAbility {

	private String name;
	private AbilityType type;
	
	public AbilityBase(AbilityType type, String name) {
		this.name = name;
		this.type = type;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public AbilityType getType() {
		return type;
	}
}
