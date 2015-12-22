package com.kryto.scrap.util;

public class MathUtil {

	public static float scale(float value, float maxValue, float maxScale) {
		return (maxScale / maxValue) * value;
	}
	
	public static float percent(float value, float percent) {
		return value * (percent * 0.01F);
	}
	
	public static int percent(int value, int percent) {
		return (int) (value * (percent * 0.01F));
	}
}
