package com.kryto.scrap.framework;

import java.awt.Color;
import java.awt.Graphics2D;

import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.state.GameStateManager;
import com.kryto.scrap.state.MenuState;
import com.kryto.scrap.util.Timer;

public class Scrap {
	
	public static final boolean DEBUGMODE = false;
	
	public Timer timer = new Timer(1000);
	public int fps, lastfps;
	
	public GameStateManager stateManager;
	
	public void init() {
		Assets.init();
		stateManager = new GameStateManager();
		stateManager.addState(0, new MenuState());
		stateManager.switchState(0);
	}
	
	public void update() {
		stateManager.update();
	}
	
	public void render(Graphics2D g) {	
		
		fps++;
		
		if (timer.isDoneAndReset()) {	
			lastfps = fps;
			fps = 0;
		}
		
		if (DEBUGMODE) {
			Assets.GRAVITY_ITALIC.renderString(g, Integer.toString(lastfps), Color.WHITE, 0, 50);
		}
		
		stateManager.render(g);
	}
}
