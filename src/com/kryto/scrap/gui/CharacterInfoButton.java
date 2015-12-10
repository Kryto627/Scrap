package com.kryto.scrap.gui;

import org.newdawn.slick.Color;

import com.kryto.scrap.Game;
import com.kryto.scrap.character.Character;
import com.kryto.scrap.geometry.Rectangle;
import com.kryto.scrap.gfx.Assets;

public class CharacterInfoButton extends Component {

	private Character character;
	
	public CharacterInfoButton(int x, int y, Character character) {
		super(new Rectangle(x - (200 / 2), y - (200 / 2), 200, 200));
		this.character = character;
	}
	
	public void render() {
		
		float scale = 1;
		
		if (isMouseOver()) {
			
			scale = 1.1F;
			
			character.getType().getElement().getEmblem().renderCentered((float)bounds.getCenterX(), (float)bounds.getCenterY() - 185, 3);
			Assets.PIXEL_OPERATOR_SMALL.renderCentered(character.getType().getElement().getName(), (float)bounds.getCenterX(), (float)(bounds.getY() - 30), Color.white);
			
			Assets.PIXEL_OPERATOR_SMALL.renderCentered(character.getType().getName(), (float)bounds.getCenterX(), (float)(bounds.getY() + bounds.getHeight() + 30), Color.white);
		
			Assets.PIXEL_OPERATOR_SMALL.renderCentered("HP: " + character.getMaxHealth(), (float)bounds.getCenterX(), (float)(bounds.getY() + bounds.getHeight() + 55), Color.green);
			Assets.PIXEL_OPERATOR_SMALL.renderCentered("ATTACK: " + character.getMaxAttack(), (float)bounds.getCenterX(), (float)(bounds.getY() + bounds.getHeight() + 80), Color.red);		
		
			Assets.PIXEL_OPERATOR_BIG.renderCentered("\"" + character.getType().getIntroQuote() + "\"", Game.getCenterX(), Game.getCenterY() + 300, Color.white);
		}
		
		character.renderCentered((float)bounds.getCenterX(), (float)bounds.getCenterY(), (float)bounds.getWidth(), (float)bounds.getHeight(), scale);	
	}
}
