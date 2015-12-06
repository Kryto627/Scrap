package com.kryto.scrap.state;

import org.newdawn.slick.Color;

import com.kryto.scrap.Game;
import com.kryto.scrap.gfx.GLAssets;
import com.kryto.scrap.gfx.RenderUtil;
import com.kryto.scrap.profile.Profile;
import com.kryto.scrap.profile.ProfileManager;

public class ChooseMechState implements IGameState {

	private Profile profile = ProfileManager.getInstance().getCurrentProfile();
	
	@Override
	public void init(GameStateManager gsm) {
		
	}

	@Override
	public void update(GameStateManager gsm) {
		
	}

	@Override
	public void render() {
		
		RenderUtil.setBackgroundColor(new Color(0x38698C));
		
		GLAssets.PIXEL_OPERATOR.renderCentered("CHOOSE A MECH", Game.getCenterX(), Game.getCenterY() - 200, Color.white);		
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void onLeave() {
		
	}
}
