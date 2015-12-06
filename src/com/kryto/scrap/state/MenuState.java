package com.kryto.scrap.state;

import org.lwjgl.input.Keyboard;

import com.kryto.scrap.GLAssets;
import com.kryto.scrap.GLGame;
import com.kryto.scrap.gui.Button;

public class MenuState implements IGameState {

	public static Button button = new Button(0, "Start");
	
	@Override
	public void init(GameStateManager gsm) {
		
	}

	@Override
	public void update(GameStateManager gsm) {
		
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			System.exit(0);
		}
	}

	@Override
	public void render() {
		
		int width = 64 * 7;
		int height = 32 * 7;
		GLAssets.logo.render(GLGame.getCenterX() - (width / 2), 100, width, height);
		
		//Assets.cruiseAnimated.render(g, Window.getCenterX() - 256, Window.getCenterY(), 128, 128);
		//Assets.frigidAnimated.render(g, Window.getCenterX() + 64, Window.getCenterY(), -128, 128);
		//Assets.boilerAnimated.render(g, Window.getCenterX() + 256, Window.getCenterY(), -128, 128);
		
		button.render();
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void onLeave() {
		
	}
}