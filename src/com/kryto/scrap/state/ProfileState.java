package com.kryto.scrap.state;

import org.newdawn.slick.Color;

import com.kryto.scrap.Game;
import com.kryto.scrap.gfx.GLAssets;
import com.kryto.scrap.gfx.RenderUtil;
import com.kryto.scrap.gui.Button;

public class ProfileState implements IGameState {

	public Button profile_1, profile_2, profile_3;
	
	@Override
	public void init(GameStateManager gsm) {
		profile_1 = new Button(2, "");
		profile_2 = new Button(1, "");
		profile_3 = new Button(0, "");
	}

	@Override
	public void update(GameStateManager gsm) {
		
	}

	@Override
	public void render() {
		
		RenderUtil.setBackgroundColor(new Color(0x38698C));
		
		GLAssets.PIXEL_OPERATOR.renderCentered("CHOOSE A PROFILE", Game.getCenterX(), Game.getCenterY() - 200, Color.white);
		
		profile_1.render();
		profile_2.render();
		profile_3.render();
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void onLeave() {

	}
}
