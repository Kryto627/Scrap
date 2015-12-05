package com.kryto.scrap.framework;

import java.awt.Color;
import java.awt.Graphics2D;

import com.kryto.scrap.gfx.Animation;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gfx.Sprite;
import com.kryto.scrap.util.Timer;

public class Scrap {
	
	public static final boolean DEBUGMODE = true;
	
	public Timer timer = new Timer(1000);
	public int fps, lastfps;
	
	private Sprite frigid = new Sprite("/Frigid.png");
	private Animation frigedAnimated = new Animation(100, frigid.getSubSprite(0, 0, 32, 32), frigid.getSubSprite(0, 32, 32, 32));
	
	int i = 0;
	
	public void init() {
		Assets.init();
	}
	
	public void update() {
		
		frigedAnimated.update();
		
		if (i > Window.WIDTH + 256) {
			i = 0;
		}
		
		else i+= 5;
	}
	
	public void render(Graphics2D g) {	
		
		fps++;
		
		if (timer.isDoneAndReset()) {	
			lastfps = fps;
			fps = 0;
		}
		
		if (DEBUGMODE) Assets.GRAVITY_ITALIC.renderString(g, Integer.toString(lastfps), Color.WHITE, 0, 50);
		
		Assets.GRAVITY_ITALIC.renderCenteredString(g, "Your game is loading...", Color.WHITE, Window.WIDTH / 2, Window.HEIGHT / 2);
		frigedAnimated.render(g, -256 + i, Window.HEIGHT / 2 - 128, 256, 256);
	}
}
