package com.kryto.scrap;

import org.lwjgl.opengl.GL11;

import com.kryto.scrap.state.GameStateManager;
import com.kryto.scrap.state.MenuState;

public class GLScrap {
	
	public GameStateManager stateManager;
	
	public void init() {
		GLAssets.init();
		
		stateManager = new GameStateManager();
		stateManager.addState(0, new MenuState());
		stateManager.switchState(0);
	}
	
	public void update() {
		stateManager.update();
	}
	
	public void render() {
		
		GL11.glPushAttrib(GL11.GL_CURRENT_BIT);
		
		stateManager.render();
		
		GL11.glPopAttrib();
	}
	
	public void cleanup() {
		GLAssets.cleanup();
	}
}
