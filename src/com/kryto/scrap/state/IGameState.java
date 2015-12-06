package com.kryto.scrap.state;

public interface IGameState {

	public void init(GameStateManager gsm);
	public void update(GameStateManager gsm);

	public void render();

	public void onEnter();
	public void onLeave();
}
