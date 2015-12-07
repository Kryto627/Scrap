package com.kryto.scrap;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.kryto.scrap.character.CharacterRegistry;
import com.kryto.scrap.profile.ProfileManager;
import com.kryto.scrap.state.ChooseMechState;
import com.kryto.scrap.state.GameStateManager;
import com.kryto.scrap.state.MenuState;
import com.kryto.scrap.state.ProfileState;

public class Scrap {
	
	public GameStateManager stateManager;
	
	public void init() {
		
		ProfileManager.getInstance().load();
		
		Assets.init();
		CharacterRegistry.init();
		
		stateManager = new GameStateManager();
		stateManager.addState(0, new MenuState());
		stateManager.addState(1, new ProfileState());
		stateManager.addState(2, new ChooseMechState());
		stateManager.switchState(0);
	}
	
	public void update() {
		
		stateManager.update();
		
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			Game.shutdown();
		}
	}
	
	public void render() {
		
		GL11.glPushAttrib(GL11.GL_CURRENT_BIT);
		
		stateManager.render();
		
		GL11.glPopAttrib();
	}
	
	public void cleanup() {
		ProfileManager.getInstance().save();
		Assets.cleanup();
	}
}
