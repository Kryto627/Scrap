package com.kryto.scrap.abilities;

import java.util.ArrayList;
import java.util.List;

public class AbilityBank {

	private List<IAbility> abilities;
	
	public AbilityBank() {
		abilities = new ArrayList<IAbility>();
	}
	
	public void add(IAbility ability) {
		abilities.add(ability);
	}

	public List<IAbility> getAbilities() {
		return abilities;
	}
}
