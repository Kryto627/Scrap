package com.kryto.scrap.gui;

import org.newdawn.slick.Color;

import com.kryto.scrap.abilities.IAbility;
import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.level.Level;

public class AbilityButton extends Component {

	private Level level;
	private IAbility ability;
		
	public AbilityButton(Level level, int i, IAbility ability) {
		
		this.level = level;
		
		float width = 72 * 4;
		float height = 28 * 4;
		
		float x = (13 * 4) + ((i / 2) * (width + (10 * 4)));
		float y = (103 * 4) + ((i % 2) * (height + (8 * 4)));
		
		bounds = new Rectangle(x, y, width, height);
		
		this.ability = ability;
	}
	
	@Override
	public void update() {
		
		CharacterStack stack = level.getPlayerManager().nextActingCharacter();
		
		if (isClicked()) {
			
			ability.onAction(level);
			
			stack.setDone(true);		
		}
	} 
	
	@Override
	public void render() {
		Assets.abl_button.render(bounds);
		Assets.PIXEL_OPERATOR_SMALL.renderCentered(ability.getName(), bounds.getCenterX(), bounds.getCenterY(), Color.white);
	}
}
