package com.kryto.scrap;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;

import com.kryto.scrap.battle.BattleSetups;
import com.kryto.scrap.gfx.Assets;
import com.kryto.scrap.gfx.RenderUtil;
import com.kryto.scrap.profile.ProfileManager;
import com.kryto.scrap.state.BattleState;
import com.kryto.scrap.state.ChooseMechState;
import com.kryto.scrap.state.GameStateManager;
import com.kryto.scrap.state.MenuState;
import com.kryto.scrap.state.ProfileState;

public class Scrap {
	
	public GameStateManager stateManager = GameStateManager.getInstance();
	
	public static BattleState battleState;
	
	public void init() {
		
		ProfileManager.getInstance().load();
		
		Assets.init();
		BattleSetups.init();
		
		battleState = new BattleState();
		
		stateManager.addState(0, new MenuState());
		stateManager.addState(1, new ProfileState());
		stateManager.addState(2, new ChooseMechState());
		stateManager.addState(3, battleState);
		stateManager.switchState(0);
	}
	
	public void update() {
		
		stateManager.update();
		
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			Game.shutdown();
		}
	}
	
	public void render() {
		
		Assets.background.render(0, 0, Display.getWidth(), Display.getHeight());
		RenderUtil.setBackgroundColor(new Color(0, 0, 0, 0.5F));
		
		stateManager.render();
	}
	
	public void cleanup() {
		ProfileManager.getInstance().save();
		Assets.cleanup();
	}
}
