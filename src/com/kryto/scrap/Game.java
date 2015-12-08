package com.kryto.scrap;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class Game {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

	public static final String TITLE = "Scrap";
	private static boolean running = true;
	private Scrap scrap;

	public static void main(String[] args) {
		new Game().start();
	}

	public void start() {
		initDisplay();
		initGL();
		initGameLoop();
	}

	public void initDisplay() {

		Display.setTitle(TITLE);

		try {
			Display.setFullscreen(true);
			Display.create();
		}

		catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	public void initGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, getWidth(), getHeight(), 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	}

	public void initGameLoop() {
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
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}

	public static int getCenterX() {
		return getWidth() / 2;
	}

	public static int getCenterY() {
		return getHeight() / 2;
	}

	public static int getRealMouseY() {

		double windowHeight = (double) Display.getHeight();
		double resHeight = (double) HEIGHT;
		double mouseY = (double) Mouse.getY();

		double scaleFact = (windowHeight / resHeight);

		int result = (int) (resHeight - (mouseY / scaleFact));

		return result;
	}

	public static int getRealMouseX() {

		double windowWidth = (double) Display.getWidth();
		double resWidth = (double) WIDTH;
		double mouseX = (double) Mouse.getX();

		double scaleFact = (windowWidth / resWidth);

		int result = (int) (resWidth - (mouseX / scaleFact));

		return result;
	}
}
