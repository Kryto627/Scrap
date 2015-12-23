package com.kryto.scrap.gui;

import com.kryto.scrap.character.CharacterStack;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.level.Level;
import com.kryto.scrap.level.attack.BufferedAttack;

public class AbilityButton extends Component {

	private Level level;
		
	public AbilityButton(Level level, int i) {
		
		this.level = level;
		
		float width = 72 * 4;
		float height = 28 * 4;
		
		float x = (13 * 4) + ((i / 2) * (width + (10 * 4)));
		float y = (103 * 4) + ((i % 2) * (height + (8 * 4)));
		
		bounds = new Rectangle(x, y, width, height);
	}
	
	@Override
	public void update() {
		
		CharacterStack stack = level.getPlayerManager().nextActingCharacter();
		
		if (isClicked()) {
			
			BufferedAttack attack = new BufferedAttack(stack, level.getEnemyManager().getTargetCharacter(), 75);
			level.getAttackManager().addAttack(attack);
			
			stack.setDone(true);		
		}
	} 
	
	@Override
	public void render() {
		
		Assets.abl_button.render(bounds);		
	}
}
