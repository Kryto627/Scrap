package com.kryto.scrap.gui;

import org.newdawn.slick.Color;

import com.kryto.scrap.abilities.IAbility;
import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.Assets;

public class AbilityButton extends Component {

	private IAbility ability;
	public boolean active = false;
		
	public AbilityButton(int i, IAbility ability) {
		float width = 72 * 4;
		float height = 28 * 4;
		
		float x = (13 * 4) + ((i / 2) * (width + (10 * 4)));
		float y = (103 * 4) + ((i % 2) * (height + (8 * 4)));
		
		bounds = new Rectangle(x, y, width, height);
		
		this.ability = ability;
	}
	
	
	public void update(CharacterStack fastest) {
		
		if (isClicked()) {
			
			ability.onAction();
			
			fastest.setDone(true);
			
			active = true;
		}
	} 
	
	@Override
	public void render() {
		Assets.abl_button.render(bounds);
		Assets.PIXEL_OPERATOR_SMALL.renderCentered(ability.getName(), bounds.getCenterX(), bounds.getCenterY(), Color.white);
	}
}
