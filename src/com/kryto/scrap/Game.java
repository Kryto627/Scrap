package com.kryto.scrap;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class Game {

	public static final float VERSION = 0.1F;
	public static final String TITLE = "Scrap";

	private static boolean running = true;
	
	private Scrap scrap;
	
	public static void main(String[] args) {
		new Game().start();
	}
	
	public void start() {
		
		Display.setTitle(TITLE);
		Display.setResizable(false);

		try {
			
			Display.setFullscreen(true);			
			Display.create();
		} 
		
		catch (LWJGLException e) {
			e.printStackTrace();
		}

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, getWidth(), getHeight(), 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	
		GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
        scrap = new Scrap();
        scrap.init();
        
		while (running && !Display.isCloseRequested()) {

			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glClearColor(0, 0, 0, 1);
			
			scrap.update();
			scrap.render();

			Display.update();
			Display.sync(60);
		}

		scrap.cleanup();
		Display.destroy();
	}
	
	public static void shutdown() {
		running = false;
	}
	
	public static int getWidth() {
		return Display.getWidth();
	}
	
	public static int getHeight() {
		return Display.getHeight();
	}
	
	public static int getCenterX() {
		return getWidth() / 2;
	}
	
	public static int getCenterY() {
		return getHeight() / 2;
	}
	
	public static double getRealMouseY() {
		return getHeight() - Mouse.getY();
	}
}
