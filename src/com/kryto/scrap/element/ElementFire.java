package com.kryto.scrap.element;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.effects.EnrageEffect;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gfx.GLSprite;
import com.kryto.scrap.util.MathUtil;

public class ElementFire implements IElement {

	private static final int ENRAGE_VALUE = 30;
	
	@Override
	public String getName() {
		return "Fire";
	}

	@Override
	public GLSprite getEmblem() {
		return Assets.gui_sheet.getSubSprite(0, 63, 26, 26);
	}
	
	@Override
	public void updatePassive(CharacterStack stack) {
		
		if (stack.getHealth() < MathUtil.percent(stack.getMaxHealth(), ENRAGE_VALUE)) {
			
			stack.getBuffManager().addEffect(new EnrageEffect());
		}
	}
}
