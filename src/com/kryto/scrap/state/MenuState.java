package com.kryto.scrap.state;

import java.awt.Color;
import java.awt.Graphics2D;

import com.kryto.scrap.framework.Window;
import com.kryto.scrap.gfx.Animation;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gfx.Sprite;

public class MenuState implements IGameState {

	private Sprite frigid = new Sprite("/Frigid.png");
	private Animation frigedAnimated = new Animation(100, frigid.getSubSprite(0, 0, 32, 32), frigid.getSubSprite(0, 32, 32, 32));
	private int x;
	
	@Override
	public void init(GameStateManager gsm) {
		frigid = new Sprite("/Frigid.png");
		frigedAnimated = new Animation(100, frigid.getSubSprite(0, 0, 32, 32), frigid.getSubSprite(0, 32, 32, 32));
	}

	@Override
	public void update(GameStateManager gsm) {
		
		frigedAnimated.update();
		
		if (x > Window.WIDTH + 256) {
			x = 0;
		} else {
			x+= 5;
		}
	}

	@Override
	public void render(Graphics2D g) {
		Assets.GRAVITY_ITALIC.renderCenteredString(g, "Your game is loading...", Color.WHITE, Window.WIDTH / 2, Window.HEIGHT / 2);
		frigedAnimated.render(g, -256 + x, Window.HEIGHT / 2 - 128, 256, 256);
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void onLeave() {
		
	}
}