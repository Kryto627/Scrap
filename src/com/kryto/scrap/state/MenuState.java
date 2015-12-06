package com.kryto.scrap.state;

import org.newdawn.slick.Color;

import com.kryto.scrap.Game;
import com.kryto.scrap.gfx.GLAssets;
import com.kryto.scrap.gfx.RenderUtil;
import com.kryto.scrap.gui.Button;

public class MenuState implements IGameState {

	public Button start_button, options_button, exit_button;
	
	@Override
	public void init(GameStateManager gsm) {
		start_button = new Button(2, "START");
		options_button = new Button(1, "OPTIONS");
		exit_button = new Button(0, "EXIT");
	}

	@Override
	public void update(GameStateManager gsm) {
		
		if (start_button.isClicked()) {
			gsm.switchState(1);
		}
		
		if (exit_button.isClicked()) {
			Game.shutdown();
		}
	}

	@Override
	public void render() {
		
		RenderUtil.setBackgroundColor(new Color(0x38698C));
		
		GLAssets.logo.renderCentered(Game.getCenterX(), 150, 7);
		
		start_button.render();	
		options_button.render();
		exit_button.render();
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void onLeave() {
		
	}
}