package com.kryto.scrap.state;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.kryto.scrap.framework.Window;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gui.Button;
import com.kryto.scrap.input.Keyboard;

public class MenuState implements IGameState {

	public static Button button = new Button(0, "Start");
	
	@Override
	public void init(GameStateManager gsm) {
		
	}

	@Override
	public void update(GameStateManager gsm) {
		
		Assets.updateAnimations();
		
		if (Keyboard.getInstance().isPressed(KeyEvent.VK_ESCAPE)) {
			System.exit(0);
		}
	}

	@Override
	public void render(Graphics2D g) {
		
		g.setColor(new Color(0x335F7F));
		g.fillRect(0, 0, Window.WIDTH + 10, Window.HEIGHT + 10);
		
		int width = 57 * 7;
		int height = 21 * 7;
		Assets.logo.render(g, Window.getCenterX() - (width / 2), 100, width, height);
		
		button.render(g);
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void onLeave() {
		
	}
}