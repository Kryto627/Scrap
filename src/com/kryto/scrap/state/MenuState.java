package com.kryto.scrap.state;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import com.kryto.scrap.GLAssets;
import com.kryto.scrap.GLGame;
import com.kryto.scrap.RenderUtil;
import com.kryto.scrap.gui.Button;

public class MenuState implements IGameState {

	public static Button button;
	
	@Override
	public void init(GameStateManager gsm) {
		button = new Button(GLGame.getCenterX(), GLGame.getCenterY(), 70, "START");
	}

	@Override
	public void update(GameStateManager gsm) {
		
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			System.exit(0);
		}
	}

	@Override
	public void render() {
		
		RenderUtil.renderRect(0, 0, GLGame.getWidth(), GLGame.getHeight(), new Color(0x38698C));
		
		GLAssets.logo.renderCentered(GLGame.getCenterX(), 100, 7);
		
		button.render();	
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void onLeave() {
		
	}
}