package com.kryto.scrap.state;

import java.awt.Graphics2D;

public interface IGameState {

	public void init(GameStateManager gsm);
	public void update(GameStateManager gsm);

	public void render(Graphics2D g);

	public void onEnter();
	public void onLeave();
}
