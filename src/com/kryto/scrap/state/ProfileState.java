package com.kryto.scrap.state;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;

import com.kryto.scrap.Assets;
import com.kryto.scrap.Game;
import com.kryto.scrap.gfx.RenderUtil;
import com.kryto.scrap.gui.Button;
import com.kryto.scrap.profile.ProfileManager;

public class ProfileState implements IGameState {

	public Button profile_1, profile_2, profile_3, back_button;
	
	private ProfileManager manager = ProfileManager.getInstance();
	
	@Override
	public void init(GameStateManager gsm) {
		profile_1 = new Button(3, "");
		profile_2 = new Button(2, "");
		profile_3 = new Button(1, "");
		back_button = new Button(0, "Back");
	}

	@Override
	public void update(GameStateManager gsm) {
		
		if (profile_1.isClicked()) manager.loadProfile(0);
		if (profile_2.isClicked()) manager.loadProfile(1);
		if (profile_3.isClicked()) manager.loadProfile(2);
		
		if (manager.getCurrentProfile() != null) {
			gsm.switchState(2);
		}
		
		if (back_button.isClicked()) {		
			gsm.switchState(0);
		}
	}

	@Override
	public void render() {
		
		//RenderUtil.setBackgroundColor(new Color(0x38698C));
		
		profile_1.setText(manager.profiles[0] == null ? "New" : "Load 1");
		profile_2.setText(manager.profiles[1] == null ? "New" : "Load 2");
		profile_3.setText(manager.profiles[2] == null ? "New" : "Load 3");
			
		Assets.PIXEL_OPERATOR.renderCentered("CHOOSE A PROFILE", Game.getCenterX(), Game.getCenterY() - 200, Color.white);
		
		profile_1.render();
		profile_2.render();
		profile_3.render();
		back_button.render();
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void onLeave() {

	}
}
