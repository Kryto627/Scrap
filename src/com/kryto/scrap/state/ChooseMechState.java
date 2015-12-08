package com.kryto.scrap.state;

import org.newdawn.slick.Color;

import com.kryto.scrap.Assets;
import com.kryto.scrap.Game;
import com.kryto.scrap.character.Character;
import com.kryto.scrap.gfx.RenderUtil;
import com.kryto.scrap.gui.CharacterInfoButton;
import com.kryto.scrap.profile.Profile;
import com.kryto.scrap.profile.ProfileManager;

public class ChooseMechState implements IGameState {

	private Profile profile = ProfileManager.getInstance().getCurrentProfile();
	
	private CharacterInfoButton frigid_button, cruise_button, boiler_button;
	
	@Override
	public void init(GameStateManager gsm) {			
		frigid_button = new CharacterInfoButton(Game.getCenterX() - 300, Game.getCenterY(), buildCharacter(1));
		cruise_button = new CharacterInfoButton(Game.getCenterX(), Game.getCenterY(), buildCharacter(2));
		boiler_button = new CharacterInfoButton(Game.getCenterX() + 300, Game.getCenterY(), buildCharacter(3));
	}
	
	private Character buildCharacter(int ID) {
		
		Character character = new Character();		
		character.ID = ID;
		
		return character;
	}

	@Override
	public void update(GameStateManager gsm) {
		
	}

	@Override
	public void render() {
		
		Assets.PIXEL_OPERATOR.renderCentered("CHOOSE A MECH", Game.getCenterX(), Game.getCenterY() - 200, Color.white);		
		
		frigid_button.render();
		cruise_button.render();
		boiler_button.render();
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void onLeave() {
		
	}
}
