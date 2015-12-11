package com.kryto.scrap.state;

import org.newdawn.slick.Color;

import com.kryto.scrap.Game;
import com.kryto.scrap.character.Character;
import com.kryto.scrap.character.type.ICharacterType;
import com.kryto.scrap.character.type.TypeBoiler;
import com.kryto.scrap.character.type.TypeCruise;
import com.kryto.scrap.character.type.TypeFrigid;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gui.CharacterInfoButton;

public class ChooseMechState implements IGameState {

	//private Profile profile = ProfileManager.getInstance().getCurrentProfile();
	
	private CharacterInfoButton cruise_button, boiler_button, frigid_button;
	
	@Override
	public void init(GameStateManager gsm) {
		
		cruise_button = new CharacterInfoButton(Game.getCenterX() - 300, Game.getCenterY(), buildCharacter(new TypeFrigid()));
		boiler_button = new CharacterInfoButton(Game.getCenterX(), Game.getCenterY(), buildCharacter(new TypeBoiler()));
		frigid_button = new CharacterInfoButton(Game.getCenterX() + 300, Game.getCenterY(), buildCharacter(new TypeCruise()));
	}

	private Character buildCharacter(ICharacterType type) {		
		Character character = new Character();		
		character.type = type;	
		return character;
	}
	
	@Override
	public void update(GameStateManager gsm) {
		
	}

	@Override
	public void render() {
		
		Assets.PIXEL_OPERATOR_BIG.renderCentered("CHOOSE A STARTER MECH", Game.getCenterX(), Game.getCenterY() - 300, Color.white);		
		
		cruise_button.render();
		boiler_button.render();
		frigid_button.render();
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void onLeave() {
		
	}
}
