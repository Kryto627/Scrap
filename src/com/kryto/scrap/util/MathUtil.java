package com.kryto.scrap.util;

public class MathUtil {

	public static float sacle(float value, float maxValue, float maxScale) {
		return (maxScale / maxValue) * value;
	}
}
