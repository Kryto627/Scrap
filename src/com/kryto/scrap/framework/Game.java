package com.kryto.scrap.framework;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private Thread thread;
	private boolean running;
	private Scrap scrapGame;
	
	public Game() {
		scrapGame = new Scrap();
	}	
	
	public synchronized void start() {
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		
		scrapGame.init();
		
		double delta = 0;
		double nsPerTick = 1000000000 / 60;
		double last = System.nanoTime();
		
		while(running) {
			
			double now = System.nanoTime();
			delta += (now - last) / nsPerTick;
			last = now;
			
			while(delta >= 1) {
				
				update();
				delta--;
			}
			
			render();
		}	
	}
	
	public void update() {
		scrapGame.update();
	}
	
	public void render() {
		
		BufferStrategy bStrat = getBufferStrategy();
		
		if (bStrat == null) {
			
			createBufferStrategy(3);
			requestFocus();
			return;
		}
		
		Graphics2D g = (Graphics2D)bStrat.getDrawGraphics();
		//Draw stuff
		
		scrapGame.render(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.dispose();
		bStrat.show();
	}
}