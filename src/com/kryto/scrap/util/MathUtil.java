package com.kryto.scrap.util;

import java.util.Random;

public class MathUtil {

	private static Random random = new Random();
	
	public static float scale(float value, float maxValue, float maxScale) {
		return (maxScale / maxValue) * value;
	}
	
	public static float percent(float value, float percent) {
		return value * (percent * 0.01F);
	}
	
	public static int percent(int value, int percent) {
		return (int) (value * (percent * 0.01F));
	}
	
	public static boolean chance(int chance) {
		return random.nextInt(100) <= chance;
	}
}
