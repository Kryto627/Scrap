package com.kryto.scrap;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.kryto.scrap.gfx.GLAssets;
import com.kryto.scrap.state.GameStateManager;
import com.kryto.scrap.state.MenuState;
import com.kryto.scrap.state.ProfileState;

public class Scrap {
	
	public GameStateManager stateManager;
	
	public void init() {
		GLAssets.init();
		
		stateManager = new GameStateManager();
		stateManager.addState(0, new MenuState());
		stateManager.addState(1, new ProfileState());
		stateManager.switchState(0);
	}
	
	public void update() {
		stateManager.update();
		
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			System.exit(0);
		}
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
