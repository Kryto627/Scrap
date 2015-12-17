package com.kryto.scrap.state;

import java.util.HashMap;
import java.util.Map;

public class GameStateManager {

	private static GameStateManager instance = new GameStateManager();
	
	public static GameStateManager getInstance() {
		return instance;
	}
	
	private Map<Integer, IGameState> register;
	private IGameState currentState;
	
	private GameStateManager() {
		register = new HashMap<Integer, IGameState>();
	}
	
	public IGameState getCurrentState() {
		return currentState;
	}
	
	public void addState(int id, IGameState state) {
		register.put(id, state);
		state.init(this);
	}
	
	public void switchState(int id) {
		
		if (currentState != null) {
			currentState.onLeave();
		}
		
		currentState = register.get(id);
		currentState.onEnter();
	}
	
	public void update() {
		if (currentState != null) {
			currentState.update(this);
		}
	}
	
	public void render() {
		if (currentState != null) {
			currentState.render();
		}
	}
}