package com.kryto.scrap.element;

import java.util.Random;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.effects.SnowedInEffect;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gfx.GLSprite;

public class ElementIce implements IElement {

	private final int FROST_CHANCE = 40;
	private final Random RANDOM = new Random();

	@Override
	public String getName() {
		return "Ice";
	}

	@Override
	public GLSprite getEmblem() {
		return Assets.gui_sheet.getSubSprite(52, 63, 26, 26);
	}

	@Override
	public void onAttack(CharacterStack attacker, CharacterStack target) {

		if (RANDOM.nextInt(100) <= FROST_CHANCE) {

			target.getBuffManager().addEffect(new SnowedInEffect());
		}
	}
}
