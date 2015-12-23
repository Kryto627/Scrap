package com.kryto.scrap.event;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.character.type.TypeFrigid;
import com.kryto.scrap.util.MathUtil;

public class EventRefreshment implements IEventListerner {

	@Override
	public void onAttack(CharacterStack attacker, CharacterStack target) {
		
	}

	@Override
	public void onDodged(CharacterStack attacker, CharacterStack target) {
		
	}
	
	@Override
	public void onTurn(CharacterStack stack) {
				
	}

	@Override
	public void onPassive(CharacterStack stack) {
		
		if (stack.getCharacter().getType() instanceof TypeFrigid) {
			stack.heal(MathUtil.percent(stack.getStats().getMaxHealth(), 1));
		}	
	}
}
