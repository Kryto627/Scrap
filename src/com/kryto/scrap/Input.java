package com.kryto.scrap;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import com.kryto.scrap.util.MathUtil;

public class Input {

	public static float getMouseX() {

		return MathUtil.scale(Mouse.getX(), Display.getWidth(), Game.WIDTH);
	}

	public static float getMouseY() {

		return (float) (Game.HEIGHT - MathUtil.scale(Mouse.getY(), Display.getHeight(), Game.HEIGHT));
	}
}
