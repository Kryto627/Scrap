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
import com.kryto.scrap.profile.Profile;
import com.kryto.scrap.profile.ProfileManager;

public class ChooseMechState implements IGameState {

	private Profile profile;
	
	private CharacterInfoButton cruise_button, boiler_button, frigid_button;
	
	@Override
	public void init(GameStateManager gsm) {
		
		cruise_button = new CharacterInfoButton(Game.getCenterX() - 300, Game.getCenterY(), buildCharacter(new TypeCruise()));
		boiler_button = new CharacterInfoButton(Game.getCenterX(), Game.getCenterY(), buildCharacter(new TypeBoiler()));
		frigid_button = new CharacterInfoButton(Game.getCenterX() + 300, Game.getCenterY(), buildCharacter(new TypeFrigid()));
	}
	
	@Override
	public void onEnter() {
		profile = ProfileManager.getInstance().getCurrentProfile();
	}

	private Character buildCharacter(ICharacterType type) {		
		Character character = new Character();		
		character.type = type;	
		return character;
	}
	
	@Override
	public void update(GameStateManager gsm) {
		if (cruise_button.isClicked()) {
			Character character = new Character();
			character.type = new TypeCruise();
			profile.charLib.characters.add(character);
			enterFight(gsm, character);
		}
		
		if (boiler_button.isClicked()) {
			Character character = new Character();
			character.type = new TypeBoiler();
			profile.charLib.characters.add(character);
			enterFight(gsm, character);
		}
		
		if (frigid_button.isClicked()) {
			Character character = new Character();
			character.type = new TypeFrigid();
			profile.charLib.characters.add(character);
			enterFight(gsm, character);
		}
	}

	private void enterFight(GameStateManager gsm, Character character) {
		profile.charLib.hand[0] = character;
		gsm.switchState(3);
	}

	@Override
	public void render() {
		
		Assets.PIXEL_OPERATOR_BIG.renderCentered("CHOOSE A STARTER MECH", Game.getCenterX(), Game.getCenterY() - 300, Color.white);		
		
		cruise_button.render();
		boiler_button.render();
		frigid_button.render();
	}

	@Override
	public void onLeave() {
		
	}
}
