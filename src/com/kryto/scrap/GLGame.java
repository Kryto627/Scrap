package com.kryto.scrap;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class GLGame {

	public static final float VERSION = 0.1F;
	public static final String TITLE = "Scrap";

	private GLScrap scrap;
	
	public static void main(String[] args) {
		new GLGame().start();
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
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
        scrap = new GLScrap();
        scrap.init();
        
		while (!Display.isCloseRequested()) {

			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			
			scrap.update();
			scrap.render();

			Display.update();
			Display.sync(60);
		}

		scrap.cleanup();
		Display.destroy();
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
}
